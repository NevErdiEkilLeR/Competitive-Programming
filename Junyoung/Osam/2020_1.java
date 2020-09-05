import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int M){
        int day = 0;
        while(true){
            N += day%M == 0 ? 0 : -1;
            if(N == 0)  break;
            day++;
        }
        return day;
    }
}