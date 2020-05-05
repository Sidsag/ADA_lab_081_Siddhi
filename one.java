import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.*;
class one{
   public static String[]  partition(String[] arr,int low,int high){
     if(low>=high){
       String [] bans={""+arr[low]};
       return bans;
     }
     int mid=(high+low)/2;
     String [] left=partition(arr,low,mid);
     String [] right=partition(arr,mid+1,high);
     String[] ans=merge(left ,right);
     return ans;
   }

   public static String[] merge(String [] left,String[] right){
     int i=0;
     int j=0;
     int k=0;
     int size=(left.length+right.length);
     String [] sorted=new String[size];
     while(i<left.length && j<right.length){
       int a=Integer.parseInt(left[i]);
       int b=Integer.parseInt(right[j]);
       if(a<b){
         sorted[k]=""+left[i];
         k++;
         i++;
        }else{
        sorted[k]=""+right[j];
        k++;
        j++;
       }
     }
     while(i<left.length ){
       sorted[k]=""+left[i];
       k++;
       i++;
     }
     while(j<right.length){
       sorted[k]=""+right[j];
       k++;
       j++;
     }
     return sorted;
   }
     public static void main(String[] args)throws IOException{
     FileReader fr = new FileReader("input.txt");
     int size=fr.read()-48; 
      String seq="";
      int w;
      while ((w=fr.read()) != -1){
        seq+=(char)w;
      }
      int s=0;
      String [] arr=new String[size];
      for(int i=0;i<size;i++){
       arr[i]=seq.substring(s,s+2);
       s+=2;
     }
     long startTime = System.nanoTime() ;
     String [] fans= partition(arr, 0,arr.length-1); //Measure execution time for this method

      long endTime = System.nanoTime(); 
      long duration = (endTime - startTime); 
      System.out.println(duration);
      String num="";
      for(int i=0;i<size;i++){
       num+=fans[i];
     }
     FileWriter fw=new FileWriter("output.txt"); 
  
     // read character wise from string and write  
     // into FileWriter  
     for (int i = 0; i < num.length(); i++) 
         fw.write(num.charAt(i)); 

     System.out.println("Writing successful"); 
     //close the file  
     fw.close(); 

      System.out.println(num);
    }
}