import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

class twof{
    public static char[] insertion(char[] str){
        for(int i=0;i<str.length;i++){
            char key=str[i];
            int j=i-1;
             while(j>=0 && key<str[j]){
                str[j+1]=str[j];
                 j--;
                }
               str[j+1]=key;
        }
        return str;
    }
    public static char[] mergesort(char[] str,int low,int high){
        if(low==high){
           char[] bans={str[low]};
           return bans;
        }
        int mid =(low+high)/2;
        char[] left=mergesort(str,low,mid);
        char[] right=mergesort(str,mid+1,high);
        char[] ans=merge(left,right);
        return ans;
    }
    public static char[] merge(char[] left,char[]  right){
        int i=0;
        int j=0;
        int k=0;
        char[] mans=new char[left.length+right.length];
        while(i<left.length && j<right.length){
        char a=left[i];
        char b=right[j];
        if(a<b){
            mans[k]=left[i];
            i++;
            k++;
        }else{
            mans[k]=right[j];
            j++; 
            k++; 
        }
        }
        while(i<left.length){
            mans[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            mans[k]=right[j];
            j++;
            k++; 
        }
        return mans;
    }
    public static void main(String[] args)throws IOException,ParseException{
        FileReader fr=new FileReader("input2.txt");
        int i;
        String ques="";
        while((i=fr.read())!=-1){
          ques+=(char)i;
        }
        char [] mques=new char[ques.length()];
        for(int k=0;k<mques.length;k++){
            mques[k]=ques.charAt(k);
        }
       long startTime = System.currentTimeMillis();
 
        char[] mans=mergesort(mques,0,ques.length()-1);  //Measure execution time for this method
 
        long endTime = System.currentTimeMillis();
       long duration = (endTime - startTime);  //Total execution time in milli seconds
     
        System.out.println("mergesort "+duration);
        String fans="";
        for(int k=0;k<mans.length;k++){
            fans+=mans[k];
        }
        FileWriter fw=new FileWriter("output2.txt");  
        for (int j = 0; j < fans.length(); j++){ 
        fw.write(fans.charAt(j));}
        fw.close(); 
        char [] questr=new char[ques.length()];
        for(int k=0;k<questr.length;k++){
            questr[k]=ques.charAt(k);
        }
        long startTime2 = System.currentTimeMillis();
 
       char[] anstr= insertion(questr); //Measure execution time for this method
 
       long endTime2 = System.currentTimeMillis();
       long duration2 = (endTime2 - startTime2);  //Total execution time in milli seconds
     
        System.out.println("insertion sort "+duration2);
        String ians="";
        for(int k=0;k<anstr.length;k++){
            ians+=anstr[k];
        }
        //System.out.println(ians);
        FileWriter fw2=new FileWriter("output2.txt");  
        for (int j = 0; j < ians.length(); j++){ 
        fw2.write(ians.charAt(j));}
        fw2.close(); 
    }
}