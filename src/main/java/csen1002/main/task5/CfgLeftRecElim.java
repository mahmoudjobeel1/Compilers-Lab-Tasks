package csen1002.main.task5;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class CfgLeftRecElim {
	Language language;

	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	public CfgLeftRecElim(String cfg) {
		language=new Language(cfg);
	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		return language.toString();
	}

	/**
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		language.eliminateLeftRecursion();
	}
	static class Language {
		String input;
		List<String> terminalsList, variablesList;
		HashMap<String, Rule> rulesMap;

		List<Rule> allRulesList;

		public Language(String input) {
			this.input = input;
			allRulesList = new ArrayList<>();
			parseInput();
		}

		private void parseInput() {
			StringTokenizer st = new StringTokenizer(input, "#");
			parseVariables(st);
			parseTerminals(st);
			parseRules(st);
		}

		private void parseVariables(StringTokenizer st) {
			String[] stringArray = st.nextToken().split(";");
			variablesList = new ArrayList<>();
			variablesList.addAll(List.of(stringArray));
		}

		private void parseTerminals(StringTokenizer st) {
			String[] stringArray = st.nextToken().split(";");
			terminalsList = new ArrayList<>();
			terminalsList.addAll(List.of(stringArray));
		}

		private void parseRules(StringTokenizer st) {
			rulesMap = new HashMap<>();
			String[] rulesStringArray = st.nextToken().split(";");
			for (String ruleString : rulesStringArray) {
				String[] temp1 = ruleString.split("/");
				String source = temp1[0];
				String[] temp2 = temp1[1].split(",");
				rulesMap.put(source,new Rule(source));
				for (String var : temp2) {
					rulesMap.get(source).addStringRule(var);
				}
			}

		}

		public String toString() {
			StringBuilder ans=new StringBuilder();

			for(String var:variablesList) ans.append(var).append(";");
			ans.deleteCharAt(ans.length()-1);
			ans.append("#");

			for(String var:terminalsList) ans.append(var).append(";");
			ans.deleteCharAt(ans.length()-1);
			ans.append("#");

			for(String key:variablesList) {
				Rule rule=rulesMap.get(key);
				ans.append(rule);
				ans.append(";");
			}
			ans.deleteCharAt(ans.length()-1);

			return ans.toString();
		}

		public void eliminateLeftRecursion(){
			int n=variablesList.size();
			for(int i=0;i<n;i++){
				for(int j=0;j<i;j++){
					rulesMap.get(variablesList.get(i)).subsituiteRule(rulesMap.get(variablesList.get(j)));
				}
				Rule rule=rulesMap.get(variablesList.get(i)).eliminateLeftRecursion();
				if(rule==null) continue;
				variablesList.add(rule.source);
				rulesMap.put(rule.source,rule);
			}
		}
	}
	static class Rule {
		private String source;
		private List<List<String>> rulesList;
		public Rule(String input){
			this.source=input;
			rulesList=new ArrayList<>();
		}
		public void addStringRule(String rule){
			List<String> list=new ArrayList<>();
			for(int i=0;i<rule.length();i++) list.add(""+rule.charAt(i));
			rulesList.add(list);
		}
		public void addListRule(List<String> list){
			rulesList.add(list);
		}

		public Rule eliminateLeftRecursion(){
			Rule rule_dash=new Rule(source+"'");
			List<List<String>> alphaList=getAlphas();
			List<List<String>> betaList=getBetas(alphaList);
			if(alphaList.isEmpty()) return null;
			for(List<String> beta:betaList) beta.add(rule_dash.source);
			for (List<String> alpa:alphaList){
				alpa.remove(0);
				alpa.add(rule_dash.source);
				rule_dash.addListRule(alpa);
			}
			rule_dash.addStringRule("e");
			return rule_dash;
		}

		private List<List<String>> getBetas(List<List<String>> alphaList) {
			rulesList.removeAll(alphaList);
			return rulesList;
		}

		private List<List<String>> getAlphas( ) {
			List<List<String>> alphaList = new ArrayList<>();
			for(List<String> list:rulesList){
				if(list.get(0).equals(source)) {
					alphaList.add(list);
				}
			}
			return alphaList;
		}

		public void subsituiteRule(Rule rule){
			for(int i=0;i< rulesList.size();i++){
				List<String> list=rulesList.get(i);
				if(list.get(0).equals(rule.source)){
					rulesList.remove(list);
					list.remove(0);
					for(int j=rule.rulesList.size()-1;j>=0;j--){
						List<String> temp=new ArrayList<>(rule.rulesList.get(j));
						temp.addAll(list);
						rulesList.add(i,temp);
					}
				}
			}

		}

		public String toString(){
			StringBuilder ans=new StringBuilder(source).append("/");
			for(List<String> ruleList:rulesList){
				for(String s:ruleList) ans.append(s);
				ans.append(",");
			}
			ans.deleteCharAt(ans.length()-1);
			return ans.toString();
		}


	}

}