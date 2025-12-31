import java.util.*;
import java.util.Scanner;
public class random {
   public static void main(String[] var0) {
      Random r=new Random();
      Scanner s=new Scanner(System.in);
      System.out.print("enter size : ");
      int len=s.nextInt();
      for(int i=0;i<len;++i) {
         int num= r.nextInt(len*len);
         System.out.print("" +num+ " , ");
      }
      s.close();
   }
}

