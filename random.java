import java.util.*;
public class random {
    public static void main(String[]args){
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        System.out.print("enter no:of numbers : ");
        int len=s.nextInt(),i=0;
        int[] arr = new int[len];
        while(i<len){
            arr[i++]=r.nextInt(len*2);
        }
        i=0;
        while(i<len){
            System.out.print(arr[i++]+" , ");
        }       
    s.close();
    }
}

