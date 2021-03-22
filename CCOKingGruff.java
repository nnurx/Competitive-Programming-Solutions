package l3homework;
import java.util.*;
import java.io.*;

public class CCOKingGruff {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, q, a, b, inf=0x3f3f3f3f; static List<edge> adj[], rev[];
	public static void main(String[] args) throws IOException{
		n = readInt(); m = readInt(); a = readInt(); b = readInt();
		adj = new ArrayList[n+1]; rev = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList(); rev[i] = new ArrayList();
		}
		for(int i=1; i<=m; i++) {
			int u = readInt(), v = readInt(), w = readInt(), cost = readInt();
			adj[u].add(new edge(v, w, cost)); rev[v].add(new edge(u, w, cost));
		}
		int [] d1 = new int[n+1], d2 = new int[n+1];
		spfa(a, adj, d1); spfa(b, rev, d2);
		ArrayList<pair> path = new ArrayList<pair>();
		for(int u=1; u<=n; u++) {
			for(edge e: adj[u]) path.add(new pair(d1[u] + e.w + d2[e.v], e.cost));
		}
		Collections.sort(path);
		for(int i=1; i<path.size(); i++)
			path.get(i).v += path.get(i-1).v;
		q = readInt();  List<pair> query = new ArrayList();  int [] ans = new int[q];
		for(int i=0; i<q; i++) {
			int d = readInt(); query.add(new pair(d, i));
		}
		Collections.sort(query);
		for(int i=0, j=0; i<q; i++) {
			while(j < path.size() && query.get(i).d >= path.get(j).d){ j++; }
			if(j > 0) ans[query.get(i).v] = path.get(j-1).v;
		}
		for(int i=0; i<q; i++) System.out.println(ans[i]);
	}
	static void spfa(int st, List<edge> adj[], int dis[]) {
		boolean inq [] = new boolean[n+1]; LinkedList<Integer> q = new LinkedList<Integer>();
		Arrays.fill(dis, inf);  dis[st]=0; q.add(st); inq[st] = true;
		while(!q.isEmpty()) {
			int u = q.poll(); inq[u] = false;
			for(edge e: adj[u]) {
				if(dis[e.v] > dis[u] + e.w) {
					dis[e.v] = dis[u] + e.w;
					if(!inq[e.v]) { q.add(e.v); inq[e.v]=true; }
				}
			}
		}
	}
	static class pair implements Comparable<pair>{
		int d, v;
		pair(int d0, int v0) { d = d0; v = v0; }
		public int compareTo(pair x) {
			if(d != x.d) return Integer.compare(d, x.d);
			return Integer.compare(v, x.v);
		}
	}
	static class edge {
		int v, w, cost;
		edge(int v0, int w0, int cost0) { v=v0; w=w0; cost=cost0; }
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
