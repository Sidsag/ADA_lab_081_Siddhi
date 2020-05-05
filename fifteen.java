 import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 
class fifteen{
static class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 

	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v, int w) { adj[v].add(w); } 

	void DFSUtil(int v,boolean visited[],char[] store) 
	{  
		visited[v] = true; 
		System.out.print(store[v] + " "); 

		int n; 
 
		Iterator<Integer> i =adj[v].iterator(); 
		while (i.hasNext()) 
		{ 
			n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n,visited,store); 
		} 
	} 

	Graph getTranspose() 
	{ 
		Graph g = new Graph(V); 
		for (int v = 0; v < V; v++) 
		{ 
			Iterator<Integer> i =adj[v].listIterator(); 
			while(i.hasNext()) 
				g.adj[i.next()].add(v); 
		} 
		return g; 
	} 

	void fillOrder(int v, boolean visited[], Stack stack) 
	{ 
		visited[v] = true; 
		Iterator<Integer> i = adj[v].iterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if(!visited[n]) 
				fillOrder(n, visited, stack); 
		} 
		stack.push(new Integer(v)); 
	} 
	void printSCCs(char[] stored) 
	{ 
		Stack stack = new Stack(); 

		boolean visited[] = new boolean[V]; 
		for(int i = 0; i < V; i++) 
			visited[i] = false; 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				fillOrder(i, visited, stack); 
		Graph gr = getTranspose(); 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 
		while (stack.empty() == false) 
		{ 
			int v = (int)stack.pop();  
			if (visited[v] == false) 
			{ 
				gr.DFSUtil(v, visited,stored); 
				System.out.println(); 
			} 
		} 
	} 
}
	public static void main(String args[]) 
	{ 
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        Graph g = new Graph(n); 
        char[] stored=new char[n];
        for(int i=0;i<n;i++){
         char ch=scn.next().charAt(0);
         stored[i]=ch;}
		g.addEdge(0,1); 
		g.addEdge(1,2); 
		g.addEdge(1,4); 
		g.addEdge(1,5); 
        g.addEdge(2,6);
        g.addEdge(2,3); 
        g.addEdge(3,2); 
		g.addEdge(3,7); 
		g.addEdge(4,0); 
		g.addEdge(4,5); 
        g.addEdge(5,6);
        g.addEdge(6,5);
        g.addEdge(6,7);
        g.addEdge(7,7);

		System.out.println("Following are strongly connected components "+ 
						"in given graph "); 
		g.printSCCs(stored); 
	} 
} 
