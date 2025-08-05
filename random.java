import java.util.Random;
import java.util.Scanner;

public class random {
   public random() {
   }

   public static void main(String[] var0) {
      Random r = new Random();
      Scanner s = new Scanner(System.in);
      System.out.print("enter size : ");
      int len= s.nextInt();

      for(int i = 0; i < len; ++i) {
         int num = r.nextInt(100);
         System.out.print("" +num+ " , ");
      }

   }
}
