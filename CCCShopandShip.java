import java.util.*;
import java.io.*;

public class CCCShopandShip {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), t = readInt();
		int [][]  adj = new int [n+1][n+1];
		for (int [] a: adj) Arrays.fill(a, (int)1e9);
		for (int i = 1; i <=t; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u][v] =  adj[v][u] =  w;
		}
		int k = readInt(), store [] = new int [k];
		int[] cost = new int [k];
		for (int i = 0; i < k;i++) {
			store[i] = readInt(); cost[i] =  readInt();
		}
		int dest = readInt(), dis []= new int [n+1]; boolean vis[] =  new boolean[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE/2); dis[dest] = 0;
		for (int i = 1; i <=n; i++) {
			int min = Integer.MAX_VALUE, u = -1;
			for (int a = 1; a <=n; a++) {
				if(!vis[a]&&dis[a] <min) {
					min = dis[a];
					u = a;
				}
				
			}
			if (u == -1) break;
			vis[u] = true;
			for (int v = 1; v<=n; v++) {
				if(dis[v] > dis[u] + adj[u][v]) dis [v] = dis[u] + adj[u][v];
			}
		}
		int sol = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			sol = Math.min(sol, dis[store[i]]+cost[i]);
		}
		System.out.println(sol);
	}
	
	static class pair implements Comparable<pair>{
		private int node;
		private int weight;
		public pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		public int compareTo(pair x) { return Integer.compare(weight, x.weight); }
		
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
