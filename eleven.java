// Java program to check if there is exist a path between two vertices 
// of a graph. 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 


class eleven
{ 
    static class Graph{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 
	Graph(int v){ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i){
			adj[i] = new LinkedList();} 
    } 


	
	void addEdge(int v,int w) { adj[v].add(w); } 

	
	Boolean isReachable(int s, int d) 
	{ 
		LinkedList<Integer>temp; 

		 
		boolean visited[] = new boolean[V]; 

		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		
		visited[s]=true; 
		queue.add(s); 

		
		Iterator<Integer> i; 
		while (queue.size()!=0) 
		{ 
			
			s = queue.poll(); 

			int n; 
			i = adj[s].listIterator(); 

			
			while (i.hasNext()) 
			{ 
				n = i.next(); 

				
				if (n==d) 
					return true; 

			
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 

		
		return false; 
	} 
	}
	
	public static void main(String args[]) 
	{ 
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
		Graph g = new Graph((n+2)); 
		g.addEdge(1,2); 
		g.addEdge(2,3); 
		g.addEdge(1,4); 
		g.addEdge(4,3); 
		
        int s1 = scn.nextInt(); 
        int s2 = scn.nextInt(); 
		int s3= scn.nextInt();
		System.out.println("to check there is path b/w "+s1+" ,"+s2+", "+s2+":");
		if (g.isReachable(s1, s2)){
			if (g.isReachable(s2, s3))
            System.out.println("1");
            else 
            System.out.println("0");
        }
		else
			System.out.println("0"); 
	} 
} 

