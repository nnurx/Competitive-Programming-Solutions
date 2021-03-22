package l3homework;
import java.util.*;
import java.io.*;

public class CCCEscapeRoom {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int m = readInt();
		int n = readInt();
		int [][] grid = new int[1000][1000];
		boolean [] marked = new boolean [1000001];
		LinkedList <Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < m;i++) {
			for (int a = 0; a<n; a++) {
				grid[i][a] = readInt();
			}
		}
		queue.add(grid[0][0]);
		marked[grid[0][0]] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= (int)Math.sqrt(cur); i++){
				if (cur%i == 0 && cur/i<=1000 ) {
					if (grid[i-1][cur/i-1] != 0 && !marked[grid[i-1][cur/i-1]]) {
						queue.add(grid[i-1][cur/i-1]);
						marked[grid[i-1][cur/i-1]]=true;
					}
					if (grid[cur/i-1][i-1] != 0 && !marked[grid[cur/i-1][i-1]]) {
						queue.add(grid[cur/i-1][i-1]);
						marked[grid[cur/i-1][i-1]]=true;
					}
				}
			}
			if (marked[m*n]) {
				System.out.println("yes");
				return;
			}
		}
		
		System.out.println("no");
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
