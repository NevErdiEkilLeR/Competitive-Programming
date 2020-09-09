import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int solution(String s){
        int len = s.length();
        int ans = len;
        if(ans == 1)    return ans;

        for(int sz = 1; sz <= len/2; sz++){
            int stackCnt = 1;
            String prev = "", now = "";
            StringBuilder res = new StringBuilder();
            for(int i = 0; i <= len; i += sz){
                now = s.substring(i, Math.min(i+sz, len));
                if(prev.equals(now)){
                    stackCnt++;
                } else {
                    res.append(stackCnt > 1 ? stackCnt : "").append(prev);
                    prev = now;
                    stackCnt = 1;
                }
            }
            res.append(stackCnt > 1 ? stackCnt : "").append(now);
            ans = Math.min(ans, res.length());
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        System.out.println(solution(br.readLine()));
    }
}