package l3homework;
import java.util.*;
import java.io.*;

public class Knapsack1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), v= readInt();
		long [] knapsack = new long [v+1];
		knapsack[1] = 0;
		for (int i = 1; i <=n; i++) {
			int weight = readInt();
			int value = readInt();
			for (int a = v; a >= weight; a--) {
				knapsack[a] = Math.max(knapsack[a], knapsack[a-weight] + value);
			}
		}
		System.out.println(knapsack[v]);
	}

	static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
