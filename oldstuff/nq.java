public class nq {

    static void dis(int[][] arr){
    
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    
    }   
    public static void main(String[] args) {
        int board[][]=new int[4][4];
        dis(board);

        System.out.println("after");
        for(int i=0;i<4;i++){
            board[0][i]=1;
            dis(board);
        }
    }
}
























// class tree{
//     int[][] arr=new int[4][4];
//     tree[] nodes=new tree[4];
//     int nodeindex=0;

//     tree(){

//     }

//     tree(int[][] arr){
//         for(int i=0;i<4;i++){
//             for(int j=0;j<4;j++){
//                 this.arr[i][j]=arr[i][j];
//             }
//         }
//     }
// }

// public class nq {
//     static tree root=new tree();

//     static void dis(tree obj){
//     if(obj!=null){
//         for(int i=0;i<4;i++){
//             for(int j=0;j<4;j++){
//                 System.out.print(obj.arr[i][j]+" ");
//             }
//             System.out.println();
//         }
//     }   
// }

// // static  check_queen_saftey(tree node)

// // static tree create_node(int[][] arr){
// //     tree newnode=new tree(arr);
// //     // check()

// // }

// static void queenize(){
//     while(root.nodeindex<4){
//         for(int i=0;i<4;i++){
//             for(int j=0;j<4;j++){
                
//             }
//         }
//     }
// }
//     public static void main(String[] args) {
//         dis(root);
//     }
// }

