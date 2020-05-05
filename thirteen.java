
import java.io.*; 
import java.util.*; 


class thirteen

{ 
    static class Graph{
	int V;  
    LinkedList<Integer> adj[]; 
    Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	
    void addEdge(int v, int w) 
	{ 
		adj[v].add(w); // Add w to v's list. 
	} 

	 void DFSUtil(int v,boolean visited[],char[] store) 
	{ 
		 
		visited[v] = true; 
		System.out.print(store[v]+","); 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited,store); 
		} 
	} 

	 
	void DFS(int v,char[] stored) 
	{ 
		
		boolean visited[] = new boolean[7]; 

		 
		DFSUtil(v, visited,stored); 
	} 
  }
	public static void main(String args[]) 
	{ 
        Scanner scn=new Scanner(System.in);
        Graph g = new Graph(6);
        char[] stored=new char[6];
        for(int i=0;i<6;i++){
         char ch=scn.next().charAt(0);
         stored[i]=ch;
        }
		g.addEdge(0,1); 
		g.addEdge(0,2); 
		g.addEdge(1,3); 
		g.addEdge(1,4); 
		g.addEdge(2,5); 
        g.addEdge(3,4); 
        g.addEdge(4,5); 
		g.DFS(0,stored); 
	} 
} 

