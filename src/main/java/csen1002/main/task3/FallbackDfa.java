package csen1002.main.task3;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class FallbackDfa {
	HashMap<Integer, ArrayList<Edge>> statesMap;
	HashSet<String> alphabetSet;
	int startState;
	ArrayList<Integer> acceptStatesList;

	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	public FallbackDfa(String fdfa) {
		StringTokenizer st=new StringTokenizer(fdfa,"#");

		parseFDFAStateNums(st);
		parseFDFALanguageAlphabet(st);
		parseFDFAEdges(st);
		parseFDFAStartState(st);
		parseFDFAAcceptStates(st);
	}
	private void parseFDFAStateNums(StringTokenizer st){
		String[] states=st.nextToken().split(";");
		statesMap=new HashMap<>();
		for(String state:states){
			statesMap.put(Integer.parseInt(state),new ArrayList<>());
		}
	}

	private void parseFDFALanguageAlphabet(StringTokenizer st){
		String [] chars=st.nextToken().split(";");
		alphabetSet=new HashSet<>();
		for(String ch:chars) alphabetSet.add(ch);
	}

	private void parseFDFAEdges(StringTokenizer st){
		String [] edges=st.nextToken().split(";");
		for(String e:edges){
			Edge edge=new Edge(e);
			List<Edge> list=statesMap.get(edge.source);
			list.add(edge);
		}
	}

	private void parseFDFAStartState(StringTokenizer st){
		startState=Integer.parseInt(st.nextToken());
	}

	private void parseFDFAAcceptStates(StringTokenizer st){
		String [] states=st.nextToken().split(";");
		acceptStatesList=new ArrayList<>();
		for(String state:states) acceptStatesList.add(Integer.parseInt(state));
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 *
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	public String run(String input) {
		StringBuilder ans=new StringBuilder();
		while (input.length()>0){
			String firstAcceptableString=getFirstAcceptableString(input);
			input=input.substring(firstAcceptableString.split(",")[0].length(),input.length());
			ans.append(firstAcceptableString).append(";");
		}
		return ans.deleteCharAt(ans.length()-1).toString();
	}

	private String getFirstAcceptableString(String input){

		String ans="";
		Stack<Node> stack=new Stack<>();
		for (Edge edge:statesMap.get(startState)){
			if(edge.transition.equals(""+input.charAt(0))){
				Node node=new Node(acceptStatesList.contains((Integer) edge.destination),edge.destination,1);
				stack.push(node);
			}
		}



		Node ansNode=null,temp=null;
		while (!stack.isEmpty()){

			Node current=stack.pop();

			if(current.isAcceptable){
				if(ansNode==null || current.pointer>ansNode.pointer) ansNode=current;
			}

			if(temp==null || current.pointer>temp.pointer) temp=current;
			if(current.pointer==input.length()) continue;

			for (Edge edge:statesMap.get(current.currentState)){
				if(edge.transition.equals(""+input.charAt(current.pointer))){
					Node node=new Node(acceptStatesList.contains((Integer) edge.destination),edge.destination,current.pointer+1);
					stack.push(node);
				}
			}

		}
		if(ansNode==null) ansNode=temp;
		return input.substring(0,ansNode.pointer)+","+ansNode.currentState;
	}
	private boolean isStackHasAcceptableState(Stack<Node> stack){
		for(int i=0;i<stack.size();i++)
			if(stack.get(i).isAcceptable) return true;
		return false;
	}


	static class Node{
		boolean isAcceptable;
		int currentState;
		int pointer;
		public Node(boolean isAcceptable, int currentState, int pointer) {
			this.isAcceptable = isAcceptable;
			this.currentState = currentState;
			this.pointer = pointer;
		}

		@Override
		public String toString() {
			return "Node{" +
					"isAcceptable=" + isAcceptable +
					", currentState=" + currentState +
					", pointer=" + pointer +
					'}';
		}
	}

	static class Edge{
		int source, destination;
		String transition;
		public Edge(String input){
			String [] edgeString=input.split(",");
			source=Integer.parseInt(edgeString[0]);
			transition=edgeString[1];
			destination=Integer.parseInt(edgeString[2]);
		}
		public Edge(int source,int destination,String transition){
			this.source=source;
			this.destination=destination;
			this.transition=transition;
		}

	}

	public static void main(String[] args) {
		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11;12;13#r;t;x#0,r,3;0,t,10;0,x,1;1,r,8;1,t,12;1,x,6;2,r,0;2,t,4;2,x,9;3,r,2;3,t,2;3,x,4;4,r,6;4,t,11;4,x,11;5,r,4;5,t,6;5,x,5;6,r,5;6,t,13;6,x,5;7,r,11;7,t,9;7,x,3;8,r,6;8,t,0;8,x,8;9,r,4;9,t,9;9,x,4;10,r,13;10,t,0;10,x,6;11,r,8;11,t,6;11,x,2;12,r,7;12,t,6;12,x,0;13,r,8;13,t,6;13,x,2#12#3;9");
		System.out.println(fallbackDfa.run("rxtrrrtrtrttrrrx"));
	}
}
