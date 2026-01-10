package btree;

public class node {
    int[] key;
    node[] child;
    int nkey,nchild;
    node(int order){
        this.child=new node[order+1];
        this.key=new int[order];
    }
}
