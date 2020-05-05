import java.util.Scanner;

class ten
{ 
	
	static class Graph 
	{ 
		 
		int v, e; 
		int[][] dir; 

		
		Graph(int v, int e) { 
			this.v = v; 
			this.e = e; 
			dir = new int[v][]; 
			for (int i = 0; i < v; i++) 
				dir[i] = new int[v]; 
		} 
	} 
	static Graph createGraph(int v, int e) 
	{ 
		Graph G = new Graph(v, e); 

		//direction from a 
		G.dir[0][1] = 1; 
		G.dir[0][2] = 1; 

		//direction from b 
        G.dir[1][4] = 1; 
        G.dir[1][3] = 1; 
        G.dir[1][5] = 1; 

		//direction from c
        G.dir[2][0] = 1; 
        G.dir[2][3] = 1; 

		//direction from d 
        G.dir[3][1] = 1;
        G.dir[3][2] = 1;
        G.dir[3][5] = 1;
        
        //direction from e
        G.dir[4][1] = 1;
        G.dir[4][2] = 1;

        //direction from f
        G.dir[5][2] = 1;
		return G; 
	} 

	static int findDegree(Graph G, int ver) 
	{ 
		int degree = 0; 
		for (int i = 0; i < G.v; i++) { 
			if (G.dir[ver][i] == 1) 
				degree++; 
		} 
		return degree; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
        Scanner scn=new Scanner(System.in);

        int vertices =scn.nextInt(); 
        char[] store=new char[vertices];
        for(int i=0;i<vertices;i++){
         char ch=scn.next().charAt(0);
         store[i]=ch;
        }
		int edges=scn.nextInt();
		Graph G = createGraph(vertices, edges); 
        // Function calling 
        int degree=0;
        System.out.println("vertices"+"   " + "degree");
        for(int i=0;i<vertices;i++){
		degree = findDegree(G,i);  
		System.out.println(store[i]+"           " + degree);}
	   } 
} 
