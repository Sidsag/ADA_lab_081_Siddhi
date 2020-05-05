import java.io.*; 
import java.util.*; 
public class fourteen{
static class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; // Adjacency List 

	//Constructor 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	
	void addEdge(int v,int w) { adj[v].add(w); } 

	void topologicalSortUtil(int v, boolean visited[], 
							Stack stack) 
	{ 
		visited[v] = true; 
		Integer i; 

		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			i = it.next(); 
			if (!visited[i]) 
				topologicalSortUtil(i, visited, stack); 
		}  
		stack.push(new Integer(v)); 
	} 
	void topologicalSort(char[] store) 
	{ 
		Stack stack = new Stack(); 

		boolean visited[] = new boolean[V]; 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				topologicalSortUtil(i, visited, stack); 

		while (stack.empty()==false){
            int r=(int)stack.pop();
			System.out.print(store[r]+ ","); }
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
            stored[i]=ch;
           }
        g.addEdge(0, 2);
        g.addEdge(0, 3);  
		g.addEdge(1, 0); 
		g.addEdge(1, 3); 
		g.addEdge(2, 3); 

		System.out.println("Following is a Topological " + 
						"sort of the given graph"); 
		g.topologicalSort(stored); 
	} 
} 
