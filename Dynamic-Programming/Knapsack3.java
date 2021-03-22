package l3homework;
import java.util.*;
import java.io.*;

public class Knapsack3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), m = readInt(), maxW = 5000;
		long dp[] = new long [maxW+1];
		for (int i = 1; i <=n; i++) {
			int num = readInt(), w = readInt(), p = readInt();
			for (int a = 1; a <+ num; a*=2) {
				long cost = (long)a*w, value = (long)a*p;
				for (int j = maxW; j >= cost; j--) {
					dp[j] =  Math.max(dp[j], dp[(int)(j-cost)]+value);
				}
				num-=a;
			}
			if (num > 0) {
				long cost = (long)num*w, value = (long)num*p;
				for (int j = maxW; j >= cost; j--) {
					dp[j] =  Math.max(dp[j], dp[(int)(j-cost)]+value);
				}
			}
		}
		
		long ans = Long.MIN_VALUE;
		for (int i = 1; i <=m; i++) {
			int cap = readInt(), fuel = readInt();
			ans = Math.max(ans, dp[cap]-fuel);
			
		}
		System.out.println(ans);

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
