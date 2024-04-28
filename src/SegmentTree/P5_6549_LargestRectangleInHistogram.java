package SegmentTree;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/6549
// (1) 범위 오류 : int -> long
public class P5_6549_LargestRectangleInHistogram {

    static int N;
    static long graph[], ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            ans = 0;
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            if(N==0) break;

            graph = new long[N+2];

            for(int i=1; i<=N; i++) graph[i] = Long.parseLong(st.nextToken());

            Stack<Integer> stack = new Stack<>();
            stack.add(0);

            for(int i=1; i<=N+1; i++){
                while (!stack.isEmpty()){
                    int now = stack.peek();
                    if(graph[now] <= graph[i]) break;
                    stack.pop();
                    ans = Math.max(ans, graph[now]*(i-stack.peek()-1));
                }
                stack.push(i);
            }

            sb.append(ans).append("\n");

        }

        System.out.println(sb);

    }
}
