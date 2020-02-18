class ArrayListTest {
    List<Integer> ob = new ArrayList<Integer>();
    List<Integer> nb;

    public ArrayListTest() {
        // init and add
        nb = new ArrayList<Integer>(            // O(n), same as clone()
                Arrays.asList(5, 4, 3, 2));
        ob.add(2);                              // O(1)
        ob.add(0, 2);                           // *O(n)
        ob.addAll(nb);                          // O(n)
        Collections.sort(ob);

        // check status
        int idx = ob.indexOf(2);                // *O(n), first meet else -1
        System.out.println(ob.get(idx));        // O(1)
        ob.set(idx, 9);                         // O(1)
        System.out.println(ob.contains(9));     // *O(n)

        System.out.println(ob.size());          // O(1)
        ob.clear();                             // O(n), replacement : re-initialize
    }
    public void graphTest(){
        // Graph by 2-D ArrayList
        int[][] input = {{1, 3}, {2, 5}, {3, 4}, {4, 6}};
        Graph graph = new Graph(6);
        for (int[] edge : input) {
            graph.add(edge[0], edge[1]);
        }

        System.out.print("1 connect to ");
        for (int node : graph.getNode(1)) {
            System.out.print(node + " ");
        }
    }
}

class Graph {
    List<List<Integer>> graph;  // 2-D ArrayList

    public Graph(int N){
        // adjacency list
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
    }
    public void add(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    public List<Integer> getNode(int x){
        return this.graph.get(x);
    }
}