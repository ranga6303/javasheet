package samslib;

import java.util.*;

public class RandomGen {
   int[] resultArr;

   public int[] array(int len) {
      Random r = new Random();
      this.resultArr = new int[len];
      for (int i = 0; i < len; ++i) {
         int num = r.nextInt(len * len);
         this.resultArr[i] = num;
      }
      return this.resultArr;
   }
}
