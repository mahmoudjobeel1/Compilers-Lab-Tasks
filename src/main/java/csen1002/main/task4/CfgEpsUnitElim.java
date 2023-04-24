package csen1002.main.task4;
import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class CfgEpsUnitElim {
	String cfg;
	Language language;

	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	public CfgEpsUnitElim(String cfg) {
		this.cfg=cfg;
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
	 * Eliminates Epsilon Rules from the grammar
	 */
	public void eliminateEpsilonRules() {
		Rule rule;
		while ((rule=searchForEpsilonRule())!=null){
			language.eliminateEpsilon(rule);
		}
	}
	private Rule searchForEpsilonRule(){
		for(int i=language.variablesList.size()-1;i>=0;i--){
			for(Rule rule:language.rulesMap.get(language.variablesList.get(i))){
				if(rule.isEpsilon) return rule;
			}
		}
		return null;
	}
	private Rule searchForUnitRule(){
		for(int i=0;i<language.variablesList.size();i++){
			for(Rule rule:language.rulesMap.get(language.variablesList.get(i))){
				if(rule.isUnit) return rule;
			}
		}
		return null;
	}

	/**
	 * Eliminates Unit Rules from the grammar
	 */
	public void eliminateUnitRules() {
		Rule rule;
		while ((rule=searchForUnitRule())!=null){
			language.eliminateUnit(rule);
		}
	}


	static class Rule implements Comparable<Rule>{
		String ruleString,source;
		boolean isEpsilon,isUnit;
		public Rule(String input){
			String [] st=input.split("/");
			source=st[0];
			ruleString=st[1];
			isEpsilon=ruleString.equals("e");
			isUnit=ruleString.length()==1 && Character.isUpperCase(ruleString.charAt(0));
		}
		public List<Rule> eliminateEpsilon(String eliminatedVariable){
			List<Rule> ruleList=new ArrayList<>();
			Queue<String> queue=new LinkedList<>();
			Queue<Integer> indexQueue=new LinkedList<>();
			queue.add("");
			indexQueue.add(0);

			while(!queue.isEmpty()){
				String root=queue.poll();
				int idx=indexQueue.poll();

				if(idx==ruleString.length()){
					ruleList.add(new Rule(source+"/"+(root.length()==0 ? "e":root)));
					continue;
				}

				if(ruleString.charAt(idx)==eliminatedVariable.charAt(0)){
					queue.add(root);
					indexQueue.add(idx+1);
				}

				queue.add(root + ruleString.charAt(idx));
				indexQueue.add(idx + 1);

			}

			return ruleList;
		}


		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Rule rule = (Rule) o;
			return Objects.equals(ruleString, rule.ruleString) && Objects.equals(source, rule.source);
		}

		@Override
		public String toString() {
			return source+"/"+ruleString;
		}

		@Override
		public int compareTo(Rule o) {
			return ruleString.compareTo(o.ruleString);
		}
	}

	static class Language{
		String input;
		List<String> terminalsList,variablesList;
		HashMap<String,List<Rule>> rulesMap;

		List<Rule> allRulesList;
		public Language(String input){
			this.input=input;
			allRulesList=new ArrayList<>();
			parseInput();
		}
		private void parseInput(){
			StringTokenizer st=new StringTokenizer(input,"#");
			parseVariables(st);
			parseTerminals(st);
			parseRules(st);
		}
		private void parseVariables(StringTokenizer st){
			String [] stringArray=st.nextToken().split(";");
			variablesList=new ArrayList<>();
			variablesList.addAll(List.of(stringArray));
		}
		private void parseTerminals(StringTokenizer st){
			String [] stringArray=st.nextToken().split(";");
			terminalsList=new ArrayList<>();
			terminalsList.addAll(List.of(stringArray));
		}
		private void parseRules(StringTokenizer st){
			rulesMap=new HashMap<>();
			for(String var:variablesList) rulesMap.put(var,new ArrayList<>());
			String [] rulesStringArray=st.nextToken().split(";");
			for(String ruleString:rulesStringArray){
				String [] temp1=ruleString.split("/");
				String source=temp1[0];
				String [] temp2=temp1[1].split(",");
				for(String var:temp2) {
					Rule rule = new Rule(source+"/"+var);
					allRulesList.add(rule);
					rulesMap.get(rule.source).add(rule);
				}
			}

		}

		public String toString(){
			StringBuilder ans=new StringBuilder();

			for(String var:variablesList) ans.append(var).append(";");
			ans.deleteCharAt(ans.length()-1);
			ans.append("#");

			for(String var:terminalsList) ans.append(var).append(";");
			ans.deleteCharAt(ans.length()-1);
			ans.append("#");

			for(String key:variablesList) {
				List<Rule> temp=rulesMap.get(key);
				if(temp.isEmpty()) continue;
				Collections.sort(temp);
				ans.append(key).append("/");
				for(Rule rule:temp){
					ans.append(rule.ruleString).append(",");
				}
				ans.deleteCharAt(ans.length()-1);
				ans.append(";");
			}
			ans.deleteCharAt(ans.length()-1);

			return ans.toString();
		}
		public void addRule(Rule rule){
			if(allRulesList.contains(rule)) return;
			rulesMap.get(rule.source).add(rule);
			allRulesList.add(rule);
		}
		public void removeRule(Rule rule){
			rulesMap.get(rule.source).remove(rule);
		}
		public void eliminateEpsilon(Rule rule){
			removeRule(rule);
			for(String var:variablesList){
				List<Rule> newRules=new ArrayList<>();
				for(Rule oldRule:rulesMap.get(var)){
					newRules.addAll(oldRule.eliminateEpsilon(rule.source));
				}
				for (Rule newRule:newRules) addRule(newRule);
			}
		}

		public void eliminateUnit(Rule rule){
			removeRule(rule);
			List<Rule> oldRules=rulesMap.get(rule.ruleString);
			for (Rule oldRule:oldRules){
				Rule newRule=new Rule(rule.source+"/"+oldRule.ruleString);
				addRule(newRule);
			}
		}
	}

}
