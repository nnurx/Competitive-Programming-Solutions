package l3homework;
import java.util.*;
import java.io.*;

public class CCOGeeseandHawks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int [] record1;
    static int [] record2;
    static int [] goals1;
    static int [] goals2;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt();
		record1 = new int [n+1];
		record1[0] =  -1;
		char [] check = readLine().toCharArray();
		for (int i = 1; i <= n; i++) {
			if (check[i-1] == 'L') record1[i] = 0;
			if (check[i-1] == 'W') record1[i] = 1;
		}

		goals1 = new int [n+1];
		for (int i = 1; i <= n; i++) goals1[i] =  readInt();
		record2 = new int [n+1];
		record2[0] = -1;
		char [] check1 = readLine().toCharArray();
		for (int i = 1; i <= n; i++) {
			if (check1[i-1] == 'L') record2[i] = 0;
			if (check1[i-1] == 'W') record2[i] = 1;
		}
		goals2 = new int [n+1];
		for (int i = 1; i <= n; i++) goals2[i] =  readInt();
		
		int [][] dp = new int [n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int a = 1; a <= n; a++) {
				if (record1[i] == record2[a]) {
					dp[i][a] = Math.max(dp[i-1][a], dp[i][a-1]);
				}
				else {
					if (goals1[i] > goals2[a] && record1[i] > record2[a]) {
						dp[i][a] = Math.max(dp[i-1][a], goals1[i]+goals2[a] +dp[i-1][a-1]);
					}
					else if (goals1[i] < goals2[a] && record1[i] < record2[a]) {
						dp[i][a] = Math.max(dp[i-1][a], goals1[i]+goals2[a] +dp[i-1][a-1]);
					}
					else {
						dp[i][a] = Math.max(Math.max(dp[i-1][a], dp[i][a-1]), dp[i-1][a-1]);

					}
				}
			}
		}
		System.out.println(dp[n][n]);
		

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
