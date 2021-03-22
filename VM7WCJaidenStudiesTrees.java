package l3homework;
import java.util.*;
import java.io.*;

public class VM7WCJaidenStudiesTrees {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static boolean cyclepossible = false;
    static int dlong1 = 0;
    static int longv = 0;
    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10001; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int n = readInt();
		for (int i = 0; i < n-1; i++) {
			int c1 = readInt(), c2 = readInt();
			adj.get(c1).add(c2);
			adj.get(c2).add(c1);
		}
		int [] vis = new int [10001];
		int [] reach = new int [10001];
		reach[0] = -1;
		dfs(1, adj, vis, 0, reach);
		int dlongl = dlong1;
		int longvl = longv;
		dlong1 = 0;
		longv = 0;
		int [] vis1 = new int [10001];
		int [] reach1 = new int [10001];
		reach1[0] = -1;
		dfs(longvl, adj,vis1, 0, reach1);
		System.out.println(dlong1);
		
		
	}
	static void dfs (int v, ArrayList<ArrayList<Integer>> ex, int [] vis, int prev, int [] reach) {
		int cur = v; vis[cur] = 1; reach[cur] = reach[prev]+1;
		for (int i = 0; i < ex.get(cur).size(); i++) {
			dlong1 = Math.max(dlong1, reach[cur]);
			if (dlong1 == reach[cur]) {
				longv = v;
			}
			if (vis[ex.get(cur).get(i)]==0) {
				dfs(ex.get(cur).get(i),ex,vis, cur, reach);
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
