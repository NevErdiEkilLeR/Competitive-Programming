import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int[] tshirts){
        int pi = 0, ti = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        while(pi < people.length && ti < tshirts.length){
            if(people[pi] > tshirts[ti++])  continue;
            pi++;
        }
        return pi;
    }
}