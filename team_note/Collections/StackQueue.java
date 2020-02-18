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

class PriorityQueueTest {
    public PriorityQueueTest(){

    }
}