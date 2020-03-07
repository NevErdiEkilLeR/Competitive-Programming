class StackTest {
    public StackTest(){
        int top = -1;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 5; i++){
            st.push(i);         // O(1)
        }
        if(!st.empty()){
            top = st.pop();     // O(1), remove and returns value
        }
        System.out.println(top);
    }
}

class QueueTest {
    public QueueTest(){
        int front = -1;
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < 5; i++){
            q.offer(i);         // O(1)
        }
        if(!q.isEmpty()){
            front = q.poll();   // O(1), remove and return value
        }
        System.out.println(front);
    }
}

class Prisoner implements Comparable<Prisoner>{
    String name;
    int weight;

    public Prisoner(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    @Override
    public int compareTo(Prisoner o) {
        return this.weight >= o.weight ? 1 : -1;
    }
}

class PriorityQueueTest {
    public PriorityQueueTest(){
        PriorityQueue<Prisoner> pq = new PriorityQueue<>();
        pq.offer(new Prisoner("junyoung", 5));
        pq.offer(new Prisoner("cupjoo", 15));
        pq.offer(new Prisoner("Pacquiao", 10));

        if(!pq.isEmpty()){
            Prisoner p = pq.poll();
            System.out.println(p.name);
        }
    }
}