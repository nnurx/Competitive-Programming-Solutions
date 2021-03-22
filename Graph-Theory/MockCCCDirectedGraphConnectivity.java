package l3homework;
import java.util.*;
import java.io.*;

public class MockCCCDirectedGraphConnectivity {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int v;
    static boolean bigd = false;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		v = readInt(); int e = readInt();
		int [][] adj1 = new int [v+1][v+1];
	
		int [][] nodeOrder = new int [e][2];
		for (int i = 0; i < e; i++) {
			int v1= readInt(); int v2 = readInt();
			nodeOrder[i][0] = v1;
			nodeOrder[i][1] = v2;
			adj1[v1][v2] = 1;
		}
		for (int i = 0; i < e; i++) {
				adj1[nodeOrder[i][0]][nodeOrder[i][1]] = 0;
			
				if (bfs(adj1)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
				adj1[nodeOrder[i][0]][nodeOrder[i][1]] = 1;

				
		}
		
	}
	static boolean bfs(int [][] adj) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean [] vis = new boolean [v+1];
		queue.add(1);
		vis[1] = true;
		while(!queue.isEmpty()) {
			int cur = queue.get(0);
			for (int i = 0; i < v+1; i++) {
				if (adj[cur][i]==1) {
					if(!vis[i]) {
						vis[i] = true;
						queue.add(i);
					}
				}
			}
			queue.poll();
		}
		
		if (vis[v] == true) {
			return true;
		}
		else {
			return false;
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
