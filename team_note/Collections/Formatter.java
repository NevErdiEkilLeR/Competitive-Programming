import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    final int MAXN = 100+2;

    public void input1() throws IOException {
        // List<Integer> -> int[]

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken());
        }
        int[] array = list.stream().mapToInt(i->i).toArray();
    }
    public void input2() throws IOException {
        // List<int[]> -> int[][]

        List<int[]> list = new ArrayList<>();
        String input;
        while((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }
        int[][] array = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
    }
    public void input3() throws IOException {
        //
    }
    public void input4() throws IOException {
        //
    }
    void input5() throws IOException {
        //
    }
}