package csen1002.main.task1;
import java.util.*;


/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

public class RegExToNfa {
    ArrayList<State> statesList;
    String languageAlphabet="";
    Stack<Connection> stack;
    char [] postFixString;
    static HashMap<String,Integer> alphabetOrderMap;

    /**
     * Constructs an NFA corresponding to a regular expression based on Thompson's
     * construction
     *
     * @param input The alphabet and the regular expression in postfix notation for
     *              which the NFA is to be constructed
     */
    public RegExToNfa(String input) {
        statesList=new ArrayList<>();
        stack=new Stack<>();
        processInputString(input);
        convertRegExToNfa();
    }

    private void convertRegExToNfa(){
        for(char c:postFixString){
            switch (c){
                case '|': {applyUnion(); break;}
                case '.': {applyConcatenation(); break;}
                case '*':{applyStar(); break;}
                default: workOnSingleChar(c);
            }
        }
    }
    private void applyUnion(){
        State s1=new State();
        statesList.add(s1);

        State s2=new State();
        statesList.add(s2);

        int source=statesList.size()-2;
        int destination=statesList.size()-1;
        Connection connection=new Connection(source,destination);


        Connection old1=stack.pop();
        Connection old2=stack.pop();

        statesList.get(old1.destination).addConnection(new Connection(old1.destination,destination,"e"));
        statesList.get(old2.destination).addConnection(new Connection(old2.destination,destination,"e"));

        s1.addConnection(new Connection(source,old1.source,"e"));
        s1.addConnection(new Connection(source,old2.source,"e"));

        stack.add(connection);
    }

    private void applyConcatenation(){

        Connection old2=stack.pop();
        Connection old1=stack.pop();

        State oldState=statesList.get(old2.source);

        while (oldState.hasConnections()){
            Connection oldConnection=oldState.pollConnection();
            statesList.get(old1.destination).addConnection(new Connection(old1.destination,oldConnection.destination,oldConnection.transition));
        }

        Connection connection=new Connection(old1.source,old2.destination);
        stack.add(connection);
    }

    private void applyStar(){
        State s1=new State();
        statesList.add(s1);

        State s2=new State();
        statesList.add(s2);

        int source=statesList.size()-2;
        int destination=statesList.size()-1;
        String transition="e";
        Connection connection=new Connection(source,destination,transition);


        Connection old=stack.pop();

        s1.addConnection(new Connection(source,old.source,"e"));
        statesList.get(old.destination).addConnection(new Connection(old.destination,destination,"e"));
        statesList.get(old.destination).addConnection(new Connection(old.destination,old.source,"e"));

        stack.add(connection);
        statesList.get(source).addConnection(connection);
    }

    private void workOnSingleChar(char c){
        State s1=new State();
        statesList.add(s1);

        State s2=new State();
        statesList.add(s2);

        int source=statesList.size()-2;
        int destination=statesList.size()-1;
        String transition=""+c;
        Connection connection=new Connection(source,destination,transition);

        stack.add(connection);
        s1.addConnection(connection);
    }

    private void processInputString(String input){
        String [] inputString=input.split("#");
        languageAlphabet=inputString[0];
        postFixString=inputString[1].toCharArray();
        buildAlphabetOrderMap();
        //System.out.println(inputString[0]+" "+inputString[1]);
    }
    private void buildAlphabetOrderMap(){
        alphabetOrderMap=new HashMap<>();
        int i=0;
        String [] ch=languageAlphabet.split(";");
        for(String s:ch) alphabetOrderMap.put(s,i++);
        alphabetOrderMap.put("e",(int)1e5);
    }


    /**
     * @return Returns a formatted string representation of the NFA. The string
     *         representation follows the one in the task description
     */
    @Override
    public String toString() {
        int initialState=stack.peek().source;
        int lastState=stack.peek().destination;

        StringBuilder connectionsString=new StringBuilder();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<statesList.size();i++){
            State s=statesList.get(i);
            while (s.hasConnections()){
                Connection connection=s.pollConnection();
                set.add(connection.source); set.add(connection.destination);
                connectionsString.append(connection).append(";");
            }
        }
        if(!connectionsString.isEmpty()) connectionsString.deleteCharAt(connectionsString.length()-1);

        StringBuilder ans=new StringBuilder();
        while(!set.isEmpty()) ans.append(set.pollFirst()).append(";");
        if(!ans.isEmpty()) ans.deleteCharAt(ans.length()-1);

        ans.append("#").append(languageAlphabet).append("#").append(connectionsString).append("#").append(initialState).append("#").append(lastState);

        return ans.toString();
    }

    public static void main(String[] args) {
        RegExToNfa regExToNfa=new RegExToNfa("a;b#ab|");
        System.out.println(regExToNfa.toString());
    }


    static class Connection implements Comparable<Connection>{
        int source, destination;
        String transition;
        Connection(int source,int destination,String transition){
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

        @Override
        public int compareTo(Connection o) {
            if(!(o.transition.equals(transition))) return alphabetOrderMap.get(transition)-alphabetOrderMap.get(o.transition);
            return destination-o.destination;
        }
    }

    static class State{
        PriorityQueue<Connection> connectionsQueue;
        public State(){
            connectionsQueue = new PriorityQueue<>();
        }
        public void addConnection(Connection connection){
            connectionsQueue.add(connection);
        }

        public boolean hasConnections(){
            return !connectionsQueue.isEmpty();
        }
        public Connection pollConnection(){
            return connectionsQueue.poll();
        }

        public String toString(){
            StringBuilder sb=new StringBuilder();
            while(connectionsQueue.size()>0){
                sb.append(pollConnection()).append(";");
            }
            return sb.toString();
        }
    }
}
