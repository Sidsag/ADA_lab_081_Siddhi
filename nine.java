import java.util.*;
public class nine {
    static class Job  implements Comparable<Job> 
{ 
   int id;      
   int dead;    
   int penalty; 
   Job(int a,int b,int c){
       this.id=a;
       this.dead=b;
       this.penalty=c;
   }  
   @Override
   public int compareTo(Job o) {
       return o.penalty- this.penalty;
   }
}
       
    public static void printJobScheduling(Job arr[], int n) 
    { 
        Arrays.sort(arr); 
       
        int[] result=new int[n];
        boolean[] slot=new boolean[n];
        for (int i=0; i<n; i++){
           System.out.println(arr[i].id+" "+arr[i].dead+" "+arr[i].penalty);}
      
        for (int i=0; i<n; i++){
            slot[i] = false; }
      
        for (int i=0; i<n; i++) 
        { 
           for (int j=; j<n; j++) 
           { 
              if (slot[j]==false) 
              { 
                 result[j] = i;  
                 slot[j] = true;
                 break; 
              } 
           } 
        } 
      
        for (int i=0; i<n; i++){
           if (slot[i]==true) 
             System.out.println(arr[result[i]].id +" "); }
    } 
    public static void main(String[] args) 
    { 
        Job[] arr = new Job[7]; 
        
        arr[0] = new Job(1,4,70); 
        arr[1] = new Job(2,2,60); 
        arr[2] = new Job(3,4,50); 
        arr[3] = new Job(4,3,40); 
        arr[4] = new Job(5,1,30); 
        arr[5] = new Job(6,4,20); 
        arr[6] = new Job(7,6,10); 

        int n = arr.length; 
        System.out.println("Following is sequence of jobs:"); 
        printJobScheduling(arr,n); 
    } 
    
}