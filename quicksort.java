public class q {

    static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    static void sort(int a[],int i,int j){
        if(i<j&&j-i>0){
            int p=i;
            for(int k=i+1;k<a.length;k++){
                if(a[p]>a[k]){
                    swap(a,p,k);
                    p=k;
                }
            }
            sort(a, i, p-1);
            sort(a, p+1, j);
        }
    }

    static void display(int[]arr){
        for(int i:arr)System.out.print(i+",");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={21,2,1,4,3,10,11};
        System.out.println("original array");
        display(arr);
        sort(arr,0,arr.length-1);
        System.out.println("after aplying quick sort");
        display(arr);
    }
}
