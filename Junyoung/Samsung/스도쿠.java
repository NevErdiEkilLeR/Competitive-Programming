// https://www.acmicpc.net/problem/2580

import java.io.*;
import java.util.*;

class Pot{
    int r, c;
    public Pot(int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    boolean found = false;
    int [][] board = new int[9][9];
    List<Pot> blank = new ArrayList<>();

    public boolean check(Pot p, int r, int c){
        int val = board[p.r][p.c];
        if(r == p.r && c == p.c)    return true;
        if(board[r][c] == 0)    return true;
        return board[r][c] != val;
    }
    public boolean checkAll(Pot p){
        for(int i = 0; i < 9; i++){
            if(!check(p, i, p.c))   return false;
            if(!check(p, p.r, i))   return false;
        }
        Pot s = new Pot(p.r/3*3, p.c/3*3);
        for(int r = s.r; r < s.r+3; r++){
            for(int c = s.c; c < s.c+3; c++){
                if(!check(p, r, c))   return false;
            }
        }
        return true;
    }
    public void dfs(int idx) throws IOException {
        if(found)   return;
        if(idx == blank.size()){
            for(int r = 0; r < 9; r++){
                for(int c = 0; c < 9; c++){
                    bw.write(board[r][c]+" ");
                }
                bw.newLine();
            }
            bw.close();
            found = true;
            return;
        }
        Pot p = blank.get(idx);
        for(int i = 1; i <= 9; i++){
            board[p.r][p.c] = i;
            if(checkAll(p))    dfs(idx+1);
            board[p.r][p.c] = 0;
        }
    }
    public Solution() throws IOException {
        for(int r = 0; r < 9; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 9; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
                if(board[r][c] == 0)
                    blank.add(new Pot(r, c));
            }
        }
        dfs(0);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}