package csen1002.main.task6;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class CfgFirstFollow {
    String[] variables, terminals;
    HashMap<String, HashSet<String>> rulesMap, firstSets, followSets;


    /**
     * Constructs a Context Free Grammar
     *
     * @param cfg A formatted string representation of the CFG. The string
     *            representation follows the one in the task description
     */
    public CfgFirstFollow(String cfg) {
        parseCFG(cfg);
    }

    private void parseCFG(String cfg) {
        // cfg_example="S;T;L#a;b;c;d;i#S/ScT,T;T/aSb,iaLb,e;L/SdL,S"
        String[] lines = cfg.split("#");
        variables = lines[0].split(";");
        terminals = lines[1].split(";");
        String[] rules = lines[2].split(";");
        rulesMap = new HashMap<>();
        for (String rule : rules) {
            String[] parts = rule.split("/");
            String variable = parts[0];
            String[] productions = parts[1].split(",");
            HashSet<String> productionsList = new HashSet<>();
            for (String production : productions) {
                productionsList.add(production);
            }
            rulesMap.put(variable, productionsList);
        }

        firstSets = new HashMap<>();
        followSets = new HashMap<>();
        for (String variable : variables) {
            firstSets.put(variable, new HashSet<>());
            followSets.put(variable, new HashSet<>());
        }
        followSets.get(variables[0]).add("$");
    }

    /**
     * Calculates the First Set of each variable in the CFG.
     *
     * @return A string representation of the First of each variable in the CFG,
     * formatted as specified in the task description.
     */
    public String first() {
        while (true) {
            boolean changed = false;
            for (String variable : variables) {
                for (String production : rulesMap.get(variable)) {
                    HashSet<String> firstSet = getFirst(production);
                    HashSet<String> oldFirstSet = firstSets.get(variable);
                    for (String first : firstSet) {
                        if (!oldFirstSet.contains(first)) {
                            oldFirstSet.add(first);
                            changed = true;
                        }
                    }
                }
            }
            if (!changed) break;
        }
        StringBuilder sb = new StringBuilder();
        for (String variable : variables) {
            sb.append(variable).append("/");
            HashSet<String> firstSet = firstSets.get(variable);
            String ans = "";
            for (String first : firstSet) {
                ans += first;
            }
            sb.append(sortString(ans));
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private HashSet<String> getFirst(String production) {
        HashSet<String> firstSet = new HashSet<>();
        if (production.length() == 1) {
            if (Character.isLowerCase(production.charAt(0))) {
                firstSet.add(production);
            } else {
                firstSet.addAll(firstSets.get(production));
            }
        } else {
            for (int i = 0; i < production.length(); i++) {
                char c = production.charAt(i);
                if (Character.isLowerCase(production.charAt(0))) {
                    firstSet.add(String.valueOf(c));
                    break;
                } else {
                    HashSet<String> first = getFirst(String.valueOf(c));
                    if (first.contains("e")) {
                        first.remove("e");
                        firstSet.addAll(first);
                    } else {
                        firstSet.addAll(first);
                        break;
                    }
                }
            }
        }
        return firstSet;
    }

    /**
     * Calculates the Follow Set of each variable in the CFG.
     *
     * @return A string representation of the Follow of each variable in the CFG,
     * formatted as specified in the task description.
     */
    public String follow() {
        first();
        while(true){
            int size= getFollowSetsSize();
            for (String variable : variables) {
                for (String production : rulesMap.get(variable)) {
                    getFollows(production);
                    getFollows(production, variable);
                }
            }
            if(size==getFollowSetsSize()) break;
        }
        StringBuilder sb = new StringBuilder();
        for (String variable : variables) {
            sb.append(variable).append("/");
            HashSet<String> followSet = followSets.get(variable);
            String ans = "";
            for (String follow : followSet) {
                ans += follow;
            }
            sb.append(sortString(ans));
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private int getFollowSetsSize(){
        int size = 0;
        for (String variable : variables) {
            size += followSets.get(variable).size();
        }
        return size;
    }

    public void getFollows(String production) {
        for (int i = 0; i < production.length(); i++) {
            char c = production.charAt(i);
            if (Character.isUpperCase(c)) {
                HashSet<String> first = getFirst(production.substring(i + 1));
                if (first.contains("e")) {
                    first.remove("e");
                    followSets.get(String.valueOf(c)).addAll(first);
                    getFollows(production.substring(i + 1));
                } else {
                    followSets.get(String.valueOf(c)).addAll(first);
                }
            }
        }
    }
    public void getFollows(String production, String variable) {
        if(Character.isUpperCase(production.charAt(production.length()-1))){
            followSets.get(""+production.charAt(production.length()-1)).addAll(followSets.get(variable));
        }
        for (int i = 0; i < production.length(); i++) {
            char c = production.charAt(i);
            if (Character.isUpperCase(c)) {
                HashSet<String> first = getFirst(production.substring(i + 1));
                if (first.contains("e")) {
                    followSets.get(String.valueOf(c)).addAll(followSets.get(variable));
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
        * S → SAB | SBC | ε
A → aAa | ε
B → bB | ε
C → cC | ε*/
        CfgFirstFollow cfgFirstFollow = new CfgFirstFollow("S;T;L#a;b;c;d;i#S/ScT,T;T/aSb,iaLb,e;L/SdL,S");
        CfgFirstFollow cfgFirstFollow1=new CfgFirstFollow("S;A;B;C#a;b;c#S/SAB,SBC,e;A/aAa,e;B/bB,e;C/cC,e");
        System.out.println(cfgFirstFollow1.first());
        System.out.println(cfgFirstFollow1.follow());
    }

}
