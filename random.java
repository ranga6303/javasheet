import java.util.*;
import java.util.Scanner;
public class random{
   public static void main(String[] args){
      Random r=new Random();
      Scanner s=new Scanner(System.in);
      System.out.print("enter size : ");
      int len=s.nextInt();
      System.out.print("[");
      for(int i=0;i<len;++i){
         int num= r.nextInt(len*len);
         if(i==len-1)System.out.print(num+"]");
         else System.out.print(num+",");
      }
      s.close();
   }
}

