package l3homework;
import java.util.*;
import java.io.*;

public class JoeyAndBiology {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int n;
    static int m;
    static char [] w1;
    static char [] w2;
    static int [] a;
    static int [] b;
    static int [][] memo;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		n = readInt(); m = readInt();
		w1 = readLine().toCharArray();
		w2 = readLine().toCharArray();
		memo = new int [n+1][m+1];
		a = new int [Math.max(n, m)+1];
		b = new int [Math.max(n, m)+1];
		for (int i = 0 ; i < n; i++)a[i] = w1[i];
		for (int i = 0 ; i < m; i++)b[i] = w2[i];
		a[n] = -69;
		b[m] = -69;
		for (int [] a: memo)Arrays.fill(a, -69420);
		int sol = fun (0,0);
		System.out.println(sol);
	}
	static int fun(int i, int j) {
		if (i == n && j == m) return 0;
		if (i > n || j > m) return (int) 1e9;
		if (a[i] == b[j]) {
			return fun(i+1,j+1);
		}
		if (memo[i][j] != -69420) {
			return memo[i][j];
		}
		int sol = Math.min(fun(i+1,j+1)+1, (int) 1e9);
		int sol1 = Math.min(fun(i+1,j), fun(i,j+1))+1;
		int sol2 = Math.min(fun(i,j+2), fun(i+2,j))+1;
		int sol3 = Math.min(fun(i+3,j), fun(i,j+3))+1;
		memo[i][j] = Math.min(Math.min(sol1, sol2), Math.min(sol3, sol));
		return memo[i][j];
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
