package l3homework;
import java.util.*;
import java.io.*;

public class Grid1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int r = readInt(), c = readInt();
		long [][] adj = new long [r+1][c+1];
		adj[1][1] = 1;
		
		for (int i = 1; i <= r; i++) { 
			char [] line = readLine().toCharArray();
			for (int a = 1 ; a < c+1; a++) {
				if (line[a-1] == '#') adj[i][a] = -1;
			}
		}
		
		for (int i = 1; i <= r; i++) {
			for (int a = 1; a <= c; a++) {
				if (adj[i][a] == -1) continue;
				if (i !=  r) {
					if (adj[i+1][a] != -1) adj[i+1][a]+=(adj[i][a]%1000000007);
				}
				if (a !=  c) {
					if (adj[i][a+1]!=-1) adj[i][a+1]+=(adj[i][a]%1000000007);
				}
			}
		}
		System.out.println(adj[r][c]%1000000007);

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
