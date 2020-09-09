import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    public static HashMap<String, Integer> extract(String str){
        HashMap<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        for(int i = 0; i < str.length()-1; i++){
            String token = str.substring(i, i+2);
            String pattern = "^[a-z]*$";
            if(!Pattern.matches(pattern, token))    continue;
            if(map.containsKey(token)){
                map.replace(token, map.get(token)+1);
            } else {
                map.put(token, 1);
            }
        }
        return map;
    }

    public static int solution(String str1, String str2){
        HashMap<String, Integer> map1 = extract(str1);
        HashMap<String, Integer> map2 = extract(str2);
        int U = 0, N = 0;

        if(map1.size()+map2.size() == 0)    return 65536;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)) {
                N += Math.min(map1.get(key), map2.get(key));
                U += Math.max(map1.get(key), map2.get(key));
            } else {
                U += map1.get(key);
            }
        }
        for(String key : map2.keySet()){
            if(!map1.containsKey(key))  U += map2.get(key);
        }
        return 65536*N/U;
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
    }
}