import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] grade, int maxDiff){
        Arrays.sort(grade);
        int l = 0, r = 0, max = 0;
        while(l < grade.length && r < grade.length){
            if(grade[r]-grade[l] > maxDiff){
                l++;
                continue;
            }
            max = Math.max(max, (r++)-l);
        }
        return max+1;
    }
}