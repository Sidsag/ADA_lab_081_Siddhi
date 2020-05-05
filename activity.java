public class activity{
    public static void main(String [] args){
        int [] start={1, 3, 0, 5, 8, 5}; 
        int [] end={2, 4, 6, 7, 9, 9}; 
        maxactivity(start,end,start.length);
    }

    public static void maxactivity( int[] s,int [] f,int l){
        int i=0;
        int j;
        System.out.println("("+s[i]+","+f[i]+")"+"-"+"activity "+i);
        for(j=1;j<l;j++){
            if(s[j]>=f[i]){
                System.out.println("("+s[j]+","+f[j]+")"+"-"+"activity "+j);
                i=j;
            }
        }
    }
}