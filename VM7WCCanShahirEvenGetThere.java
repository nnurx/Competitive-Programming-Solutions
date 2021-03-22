package l3homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class VM7WCCanShahirEvenGetThere {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt();
		int m = readInt();
		int a = readInt();
		int b = readInt();
		if (a == b) {
			System.out.println("GO SHAHIR!");
			return;
		}
		ArrayList <ArrayList <Integer>> bfs = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean [] visited = new boolean [n+1];
		for (int i = 0; i < 2001; i++) {
			bfs.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m ; i++) {
			int a1 = readInt();
			int a2 = readInt();
			bfs.get(a1).add(a2);
			bfs.get(a2).add(a1);
		}
		
		visited[a] = true;
		queue.add(a);
		while (queue.size()!=0) {
			int cur = queue.get(0);
			visited[cur] = true;
			for (int i = 0; i < bfs.get(cur).size(); i++) {
				if (!visited[bfs.get(cur).get(i)]) {
					if (bfs.get(cur).get(i)==b) {
						System.out.println("GO SHAHIR!");
						return;
					}
					else {
						queue.add(bfs.get(cur).get(i));
					}
				}
			}
			queue.remove(0);
		}
		System.out.println("NO SHAHIR!");
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
