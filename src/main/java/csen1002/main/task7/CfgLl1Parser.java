package csen1002.main.task7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class CfgLl1Parser {
    Language lang;
    HashMap<String, String> parseTable;
    boolean isValidParseTable = true;

    /**
     * Constructs a Context Free Grammar
     *
     * @param cfg A formatted string representation of the CFG, the First sets of
     *            each right-hand side, and the Follow sets of each variable. The
     *            string representation follows the one in the task description
     */
    public CfgLl1Parser(String input) {
        lang = new Language(input);
        buildingParseTable();
    }

    private void buildingParseTable() {
        parseTable = new HashMap<String, String>();
        ArrayList<String> terminalsWithDollar = (ArrayList<String>) lang.terminalsList.clone();
        terminalsWithDollar.add("$");
        for (String variable : lang.variablesList) {
            for (String production : lang.getProuctionsOfVariable(variable)) {
                for (String terminal : terminalsWithDollar) {
                    if (lang.isRulesFirstContainsTerminal(production, terminal)) {
                        if (parseTable.containsKey(variable + terminal)) {
                            isValidParseTable = false;
                            return;
                        }
                        parseTable.put(variable + terminal, production);
                    } else if (lang.isVariableFollowsContainsTerminal(variable, terminal) && lang.isRulesFirstContainsTerminal(production, "e")) {
                        if (parseTable.containsKey(variable + terminal)) {
                            isValidParseTable = false;
                            return;
                        }
                        parseTable.put(variable + terminal, "e");
                    }
                }
            }
        }
    }

    /**
     * @param input The string to be parsed by the LL(1) CFG.
     * @return A string encoding a left-most derivation.
     */
    public String parse(String input) {
        if (!isValidParseTable) return "ERROR";
        return PDA.getOutputTree(input, parseTable);
    }

    static class PDA {
        Stack<String> stack;
        String input;
        String output;
        StringBuilder outputTree;
        HashMap<String, String> parseTable;

        public PDA(String input, HashMap<String, String> parseTable) {
            this.input = input+"$";
            this.parseTable = parseTable;
            stack = new Stack<>();
            output = "";
            outputTree= new StringBuilder();
        }

        public void parse() {
            stack.push("$");
            stack.push("S");
            outputTree.append("S");
            while (!stack.isEmpty()) {
                String top = stack.pop();
                if(top.equals("$")) {
                    if(input.equals("$")) {
                        return;
                    } else {
                        outputTree.append(";ERROR");
                        return;
                    }
                }
                if(top.length()==1 && Character.isLowerCase(top.charAt(0))){
                    if(top.equals(input.charAt(0)+"")) {
                        output+=top;
                        input = input.substring(1);
                    } else {
                        outputTree.append(";ERROR");
                        return;
                    }
                }else{
                    String production = parseTable.get(top+input.charAt(0));
                    if(production==null) {
                        outputTree.append(";ERROR");
                        return;
                    }
                    if(production.equals("e")) {
                        outputTree.append(";").append(output).append(getTheRemandingInStack());
                        continue;
                    }
                    outputTree.append(";").append(output).append(production).append(getTheRemandingInStack());
                    for(int i=production.length()-1;i>=0;i--) {
                        stack.push(production.charAt(i)+"");
                    }
                }
            }
        }
        private StringBuilder getTheRemandingInStack(){
            StringBuilder sb=new StringBuilder();
            for(int i=stack.size()-1;i>0;i--){
                sb.append(stack.get(i));
            }
            return sb;
        }
        public static String getOutputTree(String input, HashMap<String, String> parseTable) {
            PDA pda = new PDA(input, parseTable);
            pda.parse();
            return pda.outputTree.toString();
        }
    }

    static class Language {
        ArrayList<String> variablesList, terminalsList;
        HashMap<String, ArrayList<String>> productionsMap, firstsMap, followsMap;

        public Language(String input) {
            // S;T#a;c;i#S/iST,e;T/cS,a#S/i,e;T/c,a#S/$ca;T/$ca
            // Variables # Terminals # Variables/Productions # Variables/Firsts # Variables/Follows
            // e for epsilon
            parseInput(input);
        }

        public void parseInput(String input) {
            String[] inputArray = input.split("#");
            parseVariables(inputArray[0].split(";"));
            parseTerminals(inputArray[1].split(";"));
            parseProductions(inputArray[2].split(";"));
            parseFirsts(inputArray[3].split(";"));
            parseFollows(inputArray[4].split(";"));
        }

        private void parseVariables(String[] input) {
            variablesList = new ArrayList<String>();
            for (String s : input) variablesList.add(s);
        }

        private void parseTerminals(String[] input) {
            terminalsList = new ArrayList<String>();
            for (String s : input) terminalsList.add(s);
        }

        private void parseProductions(String[] input) {
            productionsMap = new HashMap<String, ArrayList<String>>();
            for (String s : input) {
                String[] temp = s.split("/");
                ArrayList<String> rules = new ArrayList<String>();
                productionsMap.put(temp[0], rules);
                temp = temp[1].split(",");
                for (String rule : temp) rules.add(rule);
            }
        }

        private void parseFirsts(String[] input) {
            firstsMap = new HashMap<String, ArrayList<String>>();
            for (String s : input) {
                String[] temp = s.split("/");
                ArrayList<String> firsts = new ArrayList<String>();
                firstsMap.put(temp[0], firsts);
                temp = temp[1].split(",");
                for (String first : temp) firsts.add(first);
            }
        }

        private void parseFollows(String[] input) {
            followsMap = new HashMap<String, ArrayList<String>>();
            for (String s : input) {
                String[] temp = s.split("/");
                ArrayList<String> follows = new ArrayList<String>();
                followsMap.put(temp[0], follows);
                temp = temp[1].split("");
                for (String follow : temp) follows.add(follow);
            }
        }

        private ArrayList<String> getFirstsOfRule(String rule) {
            ArrayList<String> firsts = new ArrayList<String>();
            if (rule.equals("e")) {
                firsts.add("e");
                return firsts;
            }
            String[] temp = rule.split("");
            for (int i = 0; i < temp.length; i++) {
                String s = temp[i];
                if (terminalsList.contains(s)) {
                    firsts.add(s);
                    break;
                } else {
                    ArrayList<String> tempFirsts = firstsMap.get(s);
                    for (String first : tempFirsts) {
                        if (!first.equals("e")) firsts.add(first);
                    }
                    if (!tempFirsts.contains("e")) break;
                    if (tempFirsts.contains("e") && i == temp.length - 1) firsts.add("e");
                }
            }
            return firsts;
        }

        public boolean isRulesFirstContainsTerminal(String rule, String terminal) {
            ArrayList<String> firsts = getFirstsOfRule(rule);
            return firsts.contains(terminal);
        }

        public boolean isVariableFollowsContainsTerminal(String variable, String terminal) {
            ArrayList<String> follows = followsMap.get(variable);
            return follows.contains(terminal);
        }

        public ArrayList<String> getProuctionsOfVariable(String variable) {
            return productionsMap.get(variable);
        }
    }

    public static void main(String[] args) {
        String s = "S;T#a;c;i#S/iST,e;T/cS,a#S/i,e;T/c,a#S/$ca;T/$ca";
        String s1 = "S;A;B#a;+;*#S/aA;A/SB,e;B/+A,*A#S/a;A/a,e;B/+,*#S/$+*;A/$+*;B/$+*";
        CfgLl1Parser cfg = new CfgLl1Parser(s);
        System.out.println(cfg.parse("iia"));
    }
}
