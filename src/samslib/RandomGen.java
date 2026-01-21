package samslib;

import java.util.*;

public class RandomGen {

public void help(){
        System.out.println(".array(int lenght) \nit returns an array with length and random elements filled i array");
    }

   int[] arr1D;
   int[][] arr2D;


   public int[] array(int len) {
      Random r = new Random();
      this.arr1D = new int[len];
      for (int i = 0; i < len; ++i) {
         int num = r.nextInt(len * len);
         this.arr1D[i] = num;
      }
      return this.arr1D;
   }

   public int[][] array(int rowLen,int columnLen) {
      Random r = new Random();
      this.arr2D = new int[rowLen][columnLen];
      for (int i = 0; i < rowLen; ++i) {

         for(int j=0;j<columnLen;j++){

            this.arr2D[i][j] = r.nextInt((rowLen * columnLen) * (rowLen * columnLen));
;
            
         }
      }
      
      return this.arr2D;
   }

   public int[][] array(int rowLen,int columnLen,int Lrange,int Rrange) {
      Random r = new Random();
      this.arr2D = new int[rowLen][columnLen];
      int max=(rowLen * columnLen) * (rowLen * columnLen),num;
      for (int i = 0; i < rowLen; ++i) {

         for(int j=0;j<columnLen;j++){
            num=r.nextInt(max);
            while(num>Rrange||num<Lrange){
               num=r.nextInt(max);
            }
            this.arr2D[i][j] = num;
;
            
         }
      }
      
      return this.arr2D;
   }
}
