import java.io.*;
import java.util.*;

class Truck {
    int t, w;
    public Truck(int t, int w){
        this.t = t; this.w = w;
    }
}

public class Main {

    public static int solution(int bridge_length, int weight, int[] truck_weights){
        int sum = 0, time = 0;
        Queue<Truck> q = new ArrayDeque<>();
        for(int w : truck_weights){
            time++;
            while(!q.isEmpty()){
                Truck f = q.peek();
                if(q.size() >= bridge_length || sum+w > weight){
                    q.poll();
                    sum -= f.w;
                    time = (time-f.t < bridge_length) ? bridge_length+f.t : time;
                    continue;
                }
                break;
            }
            q.offer(new Truck(time, w));
            sum += w;
        }
        while(!q.isEmpty()){
            Truck f = q.poll();
            time = (time-f.t < bridge_length) ? bridge_length+f.t : time;
        }
        return time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        int bridge_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int i = 0;
        int[] array = new int[(int)1e4];
        while(st.hasMoreTokens()){
            array[i++] = Integer.parseInt(st.nextToken());
        }
        int[] truck_weights = Arrays.copyOf(array, i);
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}