import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Vector;
import java.util.* ;

class twelve 
{ 
	
	static int minEdgeBFS(Vector <Integer> edges[], int u, 
								int v, int n) 
	{ 
		
		Vector<Boolean> visited = new Vector<Boolean>(n); 
		
		for (int i = 0; i < n; i++) { 
			visited.addElement(false); 
		} 
	
		
		Vector<Integer> distance = new Vector<Integer>(n); 
		
		for (int i = 0; i < n; i++) { 
			distance.addElement(0); 
		} 
	
		
		Queue<Integer> Q = new LinkedList<>(); 
		distance.setElementAt(0, u); 
	
		Q.add(u); 
		visited.setElementAt(true, u); 
		while (!Q.isEmpty()) 
		{ 
			int x = Q.peek(); 
			Q.poll(); 
	
			for (int i=0; i<edges[x].size(); i++) 
			{ 
				if (visited.elementAt(edges[x].get(i))) 
					continue; 
	
				
				distance.setElementAt(distance.get(x) + 1,edges[x].get(i)); 
				Q.add(edges[x].get(i)); 
				visited.setElementAt(true,edges[x].get(i)); 
			} 
		} 
		return distance.get(v); 
	} 
	
	
	static void addEdge(Vector <Integer> edges[], int u, int v) 
	{ 
	edges[u].add(v); 
	edges[v].add(u); 
	} 

	
	public static void main(String args[]) 
	{ 
		Scanner scn=new Scanner(System.in);
		// To store adjacency list of graph 
		int n = scn.nextInt(); 
		Vector <Integer> edges[] = new Vector[n]; 
		
		for (int i = 0; i < edges.length; i++) { 
			edges[i] = new Vector<>(); 
		} 
		char stored[]=new char[n];
		for(int i=0;i<n;i++){
			stored[i]=scn.next().charAt(0);
		}
		addEdge(edges,0,1);
		addEdge(edges,1,3); 
		addEdge(edges,1,4); 
		addEdge(edges,2,0); 
		addEdge(edges,2,3); 
		addEdge(edges,2,4); 
		int u =scn.nextInt();
		
		for (int i=0; i<stored.length; i++){	
		int  v=i;
		System.out.println("Vertex "+ stored[v]+" is at a distance "+minEdgeBFS(edges, u, v, n)+" from  "+stored[u]); }
	} 
} 

