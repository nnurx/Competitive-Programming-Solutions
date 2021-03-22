package l3homework;
import java.util.*;
import java.io.*;

public class CCCBowlingForNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int t = readInt();
		
		for (int b = 0; b < t; b++) {
			int n = readInt(), k = readInt(), w = readInt();
			int [] pins = new int [n];
			
			for (int i = 0; i < n; i++) pins[i] =  readInt();
			
			int [] strike = new int [n];
			for (int i = 0; i < n; i++) {
				for (int a = i; a < Math.min(i+w, n); a++) {
					strike[i] += pins[a];
				}
			}
			int [][] dp = new int [k+1][n];
			
			for (int [] a: dp) Arrays.fill(a, -1);
			Arrays.fill(dp[0], 0);
			
			for (int i = 1; i <= k; i++) {
				for (int a = n-1; a >= 0; a--) {
					if (a >= n-w) {
						dp[i][a] = strike[a];
					}
					else {
						dp[i][a]= Math.max(dp[i-1][a+w]+strike[a], dp[i][a+1]);
					}
				}
			}
			
			System.out.println(dp[k][0]);
			
		}
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
