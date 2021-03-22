package l3homework;
import java.util.*;
import java.io.*;

public class DirectedAcylicGraph {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static boolean cyclepossible = false;
    static ArrayList<String> cycles = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int n = readInt();
		int [] [] adj = new int [n+1][n+1];
		for (int i = 1; i < n+1;i++) {
			for (int a = 1; a < n+1; a ++) {
				adj[i][a] = readInt();
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			int [] vis = new int [n+1];
			vis [0] = -1;
			int [] reach = new int [n+1];
			
			dfs(n+1, i, adj,vis,0, reach);
			
		}
		if (cyclepossible) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
		
		
	}
	static void dfs (int n, int v, int adj [][], int [] vis, int prev, int [] reach) {
		int cur = v; vis[cur] = 1; reach[cur] = reach[prev]+1;
		for (int i = 1; i < n; i++) {
			if (adj[cur][i]== 1) {
				if (vis[i]==0) {
					dfs(n,i,adj,vis, cur, reach);
				}
				else if (vis[prev]==1&& vis[i]==1) {
					cyclepossible = true;
				}
			}
		}
		vis[cur] = 2;
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
