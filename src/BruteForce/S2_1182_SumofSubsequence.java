package BruteForce;

import java.io.*;
import java.util.*;

public class S2_1182_SumofSubsequence {

    static int N, target, count, arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        System.out.println(target == 0 ? count - 1 : count);

    }

    public static void DFS(int index, int sum){
        if(index == N){
            if(sum == target){
                count++;
            }
            return;
        }

        DFS(index + 1, sum + arr[index]);
        DFS(index + 1, sum);
    }

}