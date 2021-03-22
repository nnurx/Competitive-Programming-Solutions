package l3homework;
import java.util.*;
import java.io.*;
public class CCCRobothieves {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static ArrayList<node> conveyors;
    static ArrayList<node> cameras;
    static ArrayList<node> check;
    static boolean [][] unsafe;
    static char [][] adj;
    static int n;static int m;
    static boolean [][] vis;
    static int [][] reached;
    static LinkedList<node> queue;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		n = readInt(); m = readInt();
		
		adj = new char [n][m];
		conveyors = new ArrayList<node>();
		cameras = new ArrayList<node>();
		check = new ArrayList<node>();
		node starting = new node (0,0);
		for (int i = 0; i < n; i++) {
			char [] bruh = readLine().toCharArray();
			for (int a = 0; a < m; a++) {
				adj[i][a] =  bruh[a];
				if (bruh [a] == '.') {
					check.add(new node (i,a));
				}
				else if (bruh [a] == 'C') {
					cameras.add(new node (i,a));
				}
				else if (bruh[a] == 'L' || bruh[a] == 'R' ||bruh[a] == 'U' ||bruh[a] == 'D') {
					conveyors.add(new node (i,a));
				}
				else if (bruh [a] == 'S') {
					starting = new node (i,a);
				}
			}
		}
		
		unsafe = new boolean[n][m];
		camdaddy();
		
		if (unsafe[starting.x][starting.y]) {
			for (int i = 0; i < check.size(); i++) {
				System.out.println(-1);
			}
		}
		else {
			vis= new boolean [n][m];
			queue = new LinkedList<node>();
			reached = new int [n][m];
			for (int [] arr: reached) Arrays.fill(arr, -1);
			queue.add(new node (starting.y, starting.x));
			vis[starting.x][starting.y] =  true;
			reached[starting.x][starting.y] = 0;
			
			while (!queue.isEmpty()) {
				node cur = queue.poll();
				int x1 = cur.x, y1 = cur.y;
				if (x1< m-1) {
					moveRight(x1,y1);
					
				}
				if (x1 > 0) {
					moveLeft(x1,y1);
					
				}
				if (y1 > 0) {
					moveUp(x1,y1);
					
				}
				if (y1 < n-1) {
					moveDown(x1,y1);
					
				}
			}
			
			for (node a : check) {
				int x1 = a.x; int y1 = a.y;
				if (vis[x1][y1]) {
					System.out.println(reached[x1][y1]);
				}
				else {
					System.out.println(-1);
				}
			}
		}
		
	}
	static void camdaddy() {
		for (node a: cameras) {
			unsafe[a.x][a.y] = true;
			int xr = a.y;
			int yu = a.x;
			int xl = a.y;
			int yd = a.x;
			while (adj[a.x][xr] != 'W' && xr < m-1) {
				xr++;
				if (adj[a.x][xr] == '.' || adj[a.x][xr] == 'S') {
					unsafe[a.x][xr] =  true;
				}
			}
			while (adj[a.x][xl] != 'W' && xl > 0) {
				xl--;
				if (adj[a.x][xl] == '.'|| adj[a.x][xl] == 'S') {
					unsafe[a.x][xl] =  true;
				}
			}
			while (adj[yu][a.y] != 'W' && yu > 0) {
				yu--;
				if (adj[yu][a.y] == '.'|| adj[yu][a.y] == 'S') {
					unsafe[yu][a.y] =  true;
				}
			}
			while (adj[yd][a.y] != 'W' && yd < n-1) {
				yd++;
				if (adj[yd][a.y] == '.'|| adj[yd][a.y] == 'S') {
					unsafe[yd][a.y] =  true;
				}
			}
		}
	}
	
	static void moveRight(int x, int y) {
		if (!vis[y][x+1]) {
			if (adj[y][x+1] == '.' && !unsafe[y][x+1]) {
				reached[y][x+1] =  reached[y][x]+1;
				queue.add(new node (x+1,y));
				vis[y][x+1] =  true; 
			}
			else if (adj[y][x+1] == 'R') {
				reached[y][x+1] =  reached[y][x];
				vis[y][x+1] =  true; 
				moveRight(x+1, y);
			}
			else if (adj[y][x+1]  == 'U') {
				reached[y][x+1] =  reached[y][x];
				vis[y][x+1] =  true; 
				moveUp(x+1, y);
			}
			else if (adj[y][x+1]  == 'D') {
				reached[y][x+1] =  reached[y][x];
				vis[y][x+1] =  true; 
				moveDown(x+1, y);
			}
		}
		
		
	}
	
	static void moveLeft(int x, int y) {
		if (!vis[y][x-1]) {
			if (adj[y][x-1] == '.' && !unsafe[y][x-1]) {
				reached[y][x-1] =  reached[y][x]+1;
				queue.add(new node (x-1,y));
				vis[y][x-1] =  true; 
			}
			else if (adj[y][x-1] == 'L') {
				reached[y][x-1] =  reached[y][x];
				vis[y][x-1] =  true; 
				moveLeft(x-1, y);
			}
			else if (adj[y][x-1]  == 'U') {
				reached[y][x-1] =  reached[y][x];
				vis[y][x-1] =  true; 
				moveUp(x-1, y);
			}
			else if (adj[y][x-1] == 'D') {
				reached[y][x-1] =  reached[y][x];
				vis[y][x-1] =  true; 
				moveDown(x-1, y);
			}
		}
		
	}
	
	static void moveUp(int x, int y) {
		if (!vis[y-1][x]) {
			if (adj[y-1][x] == '.' && !unsafe[y-1][x]) {
				reached[y-1][x] =  reached[y][x]+1;
				queue.add(new node (x,y-1));
				vis[y-1][x] =  true; 
			}
			else if (adj[y-1][x] == 'R') {
				reached[y-1][x] =  reached[y][x];
				vis[y-1][x] =  true; 
				moveRight(x, y-1);
			}
			else if (adj[y-1][x] == 'L') {
				reached[y-1][x] =  reached[y][x];
				vis[y-1][x] =  true; 
				moveLeft(x, y-1);
			}
			else if (adj[y-1][x]  == 'U') {
				reached[y-1][x] =  reached[y][x];
				vis[y-1][x] =  true; 
				moveUp(x, y-1);
			}
		}
		
	}
	
	static void moveDown (int x, int y) {
		if (!vis[y+1][x]) {
			if (adj[y+1][x] == '.' && !unsafe[y+1][x]) {
				reached[y+1][x] =  reached[y][x]+1;
				queue.add(new node (x,y+1));
				vis[y+1][x] =  true; 
			}
			else if (adj[y+1][x] == 'R') {
				reached[y+1][x] =  reached[y][x];
				vis[y+1][x] =  true; 
				moveRight(x, y+1);
			}
			else if (adj[y+1][x] == 'L') {
				reached[y+1][x] =  reached[y][x];
				vis[y+1][x] =  true; 
				moveLeft(x, y+1);
			}
			else if (adj[y+1][x] == 'D') {
				reached[y+1][x] =  reached[y][x];
				vis[y+1][x] =  true; 
				moveDown(x, y+1);
			}
		}
		
	}
	
	
	static class node{
		private int x;
		private int y;
		public node (int x, int y) {
			this.x = x;
			this.y = y;
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
