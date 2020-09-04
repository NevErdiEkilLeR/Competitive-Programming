import java.io.*;
import java.util.*;

class Solution{

    List<HashSet<Integer>> expCnt = new ArrayList<>();

    public int solution(int N, int number){
        if(N == number) return 1;

        int NN = N;
        expCnt.add(new HashSet<>());    expCnt.add(new HashSet<>());
        expCnt.get(1).add(N);
        for(int cnt = 2; cnt <= 8; cnt++){
            expCnt.add(new HashSet<>());
            NN = NN*10 + N;
            expCnt.get(cnt).add(NN);
            for(int l = 1; l <= cnt/2; l++){
                for(int lNum : expCnt.get(l)){
                    for(int rNum : expCnt.get(cnt-l)){
                        expCnt.get(cnt).add(lNum+rNum);
                        if(lNum != rNum){
                            expCnt.get(cnt).add(lNum-rNum);
                            expCnt.get(cnt).add(rNum-lNum);
                        }
                        if(lNum != 0 && rNum != 0){
                            expCnt.get(cnt).add(lNum*rNum);
                            expCnt.get(cnt).add(Math.max(lNum,rNum)/Math.min(lNum,rNum));
                        }
                    }
                }
            }
            if(expCnt.get(cnt).contains(number)){
                return cnt;
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        System.out.println(new Solution().solution(N, num));
    }
}