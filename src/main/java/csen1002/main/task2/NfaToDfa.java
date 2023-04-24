package csen1002.main.task2;
import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class NfaToDfa {

	String [] alphabet;
	int start,end;

    HashSet<String> endSet;

	ArrayList<Connection> [] connectionsList;
	ArrayList<Integer> [] eClosureList;
    HashMap<String,State> visitedMap;

    ArrayList<State> statesList,startState,endState;

	/**
	 * Constructs a DFA corresponding to an NFA
	 * 
	 * @param input A formatted string representation of the NFA for which an
	 *              equivalent DFA is to be constructed. The string representation
	 *              follows the one in the task description
	 */
	public NfaToDfa(String input) {
        endSet =new HashSet<>();
        parseInput(input);
		formEClosureList();
        visitedMap =new HashMap<>();


        statesList=new ArrayList<>();
        startState=new ArrayList<>();
        endState=new ArrayList<>();

        traverse();
	}
    private void traverse(){
        Queue<ArrayList<Integer>> queue=new LinkedList<>();
        queue.add(eClosureList[start]);
        while(!queue.isEmpty()){
            ArrayList<Integer> source=queue.poll();
            State s=new State(source);
            if(startState.isEmpty()) startState.add(s);
            if(visitedMap.containsKey(s.getStateString())) continue;
            visitedMap.put(s.getStateString(),s);

            for(String c:alphabet){
                ArrayList<Integer> temp=getReachables(s.source,c);
                State d=new State(temp);
                queue.add(d.source);
                s.addTransition(c,d.getStateString());
            }
            for(int i: s.source){
                if(endSet.contains(""+i)) s.isAcceptable=true;
            }
        }
    }

    public  ArrayList<Integer> getReachables(ArrayList<Integer> sourcesList,String transition){
        ArrayList<Integer> destenationList=new ArrayList<>();
        for(int source:sourcesList){
            if(source==-1) continue;
            ArrayList<Connection> connectionList=connectionsList[source];
            for(Connection connection:connectionList){
                if(connection.transition.equals(transition)){
                    ArrayList<Integer> list=eClosureList[connection.destination];
                    for(Integer i:list){
                        if(!destenationList.contains(i)) destenationList.add(i);
                    }
                }
            }
        }
        if(destenationList.isEmpty()) destenationList.add(-1);
        return destenationList;
    }


	/**
	 * @return Returns a formatted string representation of the DFA. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {

        StringBuilder ans=new StringBuilder();
        formStateList();

        for(State s: statesList){
            ans.append(s.getStateString()).append(";");
        }
        ans.deleteCharAt(ans.length()-1);

        ans.append("#");
        for(String s:alphabet) ans.append(s).append(";");
        ans.deleteCharAt(ans.length()-1);

        ans.append("#");
        for(State s:statesList){
            ans.append(s);
        }
        ans.deleteCharAt(ans.length()-1);

        ans.append("#");

        //System.out.println(startState.get(0).getStateString());
        ans.append(startState.get(0).getStateString());
        //ans.deleteCharAt(ans.length()-1);

        ans.append("#");

        for(State s:endState){
            ans.append(s.getStateString()).append(";");
        }
        ans.deleteCharAt(ans.length()-1);




        return ans.toString();
	}

    private void formStateList(){
        for(String s:visitedMap.keySet()){
            statesList.add(visitedMap.get(s));
        }
        Collections.sort(statesList);
        for(State s:statesList)
            if(s.isAcceptable) endState.add(s);
    }



    private static class State implements Comparable<State>{
        ArrayList<Integer> source;
        TreeMap<String,String> destenationsMap;
        boolean isAcceptable;
        public State(ArrayList<Integer> source){
            Collections.sort(source);
            this.source=source;
            destenationsMap=new TreeMap<>();
        }
        public String getStateString(){
            StringBuilder sb=new StringBuilder();
            for(int i:source) sb.append(i).append("/");
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
        public void addTransition(String transition,String destenation){
            destenationsMap.put(transition,destenation);
        }
        public String toString(){
            StringBuilder sb=new StringBuilder();
            for(String s:destenationsMap.keySet()){
                sb.append(getStateString()).append(",").append(s).append(",").append(destenationsMap.get(s)).append(";");
            }
            return sb.toString();
        }

        @Override
        public int compareTo(State o) {
            int i=0,j=0;
            while(i<source.size() || j<o.source.size()){
                int a=i<source.size()? source.get(i++): -(int)(1e5);
                int b=j<o.source.size()? o.source.get(j++): -(int)(1e5);
                if(a==b) continue;
                return a-b;
            }
            return 0;
        }
    }



    private void parseInput(String string){
        String [] inputs=string.split("#");

        start=Integer.parseInt(inputs[3]);

        String [] endString=inputs[4].split(";");

        for(String s:endString) {
            endSet.add(s);

        }

        end=1000;
        alphabet=inputs[1].split(";");

        connectionsList=new ArrayList[end+1];
        for (int i=0;i<connectionsList.length;i++) connectionsList[i]=new ArrayList<>();
        String [] transitions=inputs[2].split(";");
        for(String transition:transitions){
            String [] s=transition.split(",");
            Connection connection=new Connection(Integer.parseInt(s[0]),s[1],Integer.parseInt(s[2]));
            connectionsList[connection.source].add(connection);
        }
    }

    private void formEClosureList(){
        eClosureList=new ArrayList[end +1];
        for(int i = 0; i<= end; i++) {
            eClosureList[i]=new ArrayList<>();
            eClosureList[i].add(i);
            for(Connection connection:connectionsList[i]){
                if(connection.transition.equals("e")) eClosureList[i].add(connection.destination);
            }
        }
        while (updateEClosureList()!=0);
    }

    private int updateEClosureList(){
        int chnages=0;

        for(int i = end; i>=0; i--){
            ArrayList<Integer> temp=new ArrayList<>();
            int oldSize=eClosureList[i].size();
            for(int j:eClosureList[i]) temp.addAll(eClosureList[j]);
            for(int j:temp) if(!eClosureList[i].contains((Integer) j)) eClosureList[i].add(j);
            chnages+=(eClosureList[i].size()-oldSize);
        }

        return chnages;
    }
	private static class Connection {
		int source, destination;
		String transition;
		Connection(int source,String transition,int destination){
			this.source=source;
			this.transition = transition;
			this.destination =destination;
		}

		Connection(int source,int destination){
			this.source=source;
			this.destination =destination;
		}

		public String toString(){
			return source+","+ transition +","+ destination;
		}

	}

	public static void main(String[] args) {
        NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8#m;z#0,m,4;0,m,1;0,m,6;0,m,3;0,z,2;0,z,4;0,z,6;0,z,8;1,m,5;1,m,0;1,m,1;1,m,6;1,z,3;1,z,5;1,z,0;1,z,4;1,z,6;1,z,2;1,z,1;2,m,3;2,m,5;2,m,1;2,m,6;2,z,3;2,z,1;2,z,0;2,z,6;3,m,6;3,m,8;3,m,0;3,m,1;3,z,4;3,z,6;3,z,7;3,z,1;4,m,2;4,m,4;4,m,8;4,m,5;4,m,6;4,z,0;4,z,7;4,z,4;4,z,2;4,z,1;4,z,5;4,z,3;5,m,0;5,m,6;5,m,8;5,m,4;5,m,7;5,m,5;5,m,3;5,z,2;5,z,1;5,z,4;5,z,0;5,z,5;6,m,4;6,m,0;6,m,8;6,m,2;6,m,6;6,m,3;6,z,1;6,z,5;6,z,0;6,z,3;7,m,3;7,m,2;7,m,0;7,m,7;7,z,5;7,z,7;7,z,1;7,z,3;8,m,7;8,m,1;8,m,4;8,m,0;8,z,7;8,z,4;8,z,8;8,z,5;8,z,6;8,z,2#3#2;4;7;8");
        System.out.println(nfaToDfa);
//        System.out.println(nfaToDfa.visitedMap.size());

    }

}
