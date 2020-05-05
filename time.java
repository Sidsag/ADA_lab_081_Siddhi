import java.text.ParseException;
import java.util.concurrent.TimeUnit;
 
public class time
{  public static void methodtotime(){
    int count=1;
    for(int i=0;i<Integer.MAX_VALUE;i++){
        count++;
    }
}
  public static void main(String[] args) throws ParseException 
  {
    long startTime = System.currentTimeMillis();
 
    methodtotime();   //Measure execution time for this method
 
    long endTime = System.currentTimeMillis();
 
    long duration = (endTime - startTime);  //Total execution time in milli seconds
     
    System.out.println(duration);
  }
}