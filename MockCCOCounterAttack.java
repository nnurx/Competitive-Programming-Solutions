package l3homework;
import java.util.*;
import java.io.*;

public class MockCCOCounterAttack {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), m = readInt();
		ArrayList<ArrayList<node>> adj = new ArrayList<ArrayList<node>>();
		for (int i = 0; i < n+1 ;i++) {
			adj.add(new ArrayList<node>());
		}
		int [] tos = new int [m];
		int [] froms = new int [m];
		int [] weights = new int [m];
		for (int i = 0; i < m; i++) {
			int n1 = readInt(), n2 = readInt(), w = readInt();
			adj.get(n1).add(new node(n2,w));
			adj.get(n2).add(new node(n1,w));
			tos[i] =  n1; froms[i] =  n2; weights[i] =  w;
		}
		LinkedList<node> q1 = new LinkedList<node>();
		int []dis1 = new int [n+1];
		int []dis2 = new int [n+1];
		Arrays.fill(dis2, (int) 1e9);
		Arrays.fill(dis1, (int) 1e9);
		dis1[1] =  0;
		
		boolean inq[] = new boolean [n+1];
		q1.add(new node(1,0));
		inq[1] = true;
		while(!q1.isEmpty()) {
			node cur = q1.poll();
			int u = cur.to; 
			inq[u] = false;
			for(node e: adj.get(u)) {
				int v = e.to, w = e.weight;
				if(dis1[v] > dis1[u] + w) {
					dis2[v] = dis1[v]; dis1[v] = dis1[u] + w;
					if(!inq[v]) { 
						inq[v] = true; 
						q1.add(new node (v,w)); 
					}
				} else if(dis1[v] != dis1[u] + w && dis2[v] > dis1[u] + w) {
					dis2[v] = dis1[u] + w;
					if(!inq[v]) { 
						inq[v] = true; 
						q1.add(new node (v,w)); 
					}				
				}
				if (dis1[v] != dis2[u] + w && dis2[v] > dis2[u] + w) {
					dis2[v] = dis2[u] + w;
					if(!inq[v]) { 
						inq[v] = true; 
						q1.add(new node (v,w)); 
					}
				}
			}
		}
		
		System.out.println(dis2[n]);
		
		

	}
	static class node implements Comparable<node>{
		private int to;
		private int weight;
		public node (int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(node x) { return Integer.compare(weight, x.weight); }

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
