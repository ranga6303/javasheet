import java.util.*;
class tree{
    int data;
    tree left,right;
    tree(int value){
        data=value;
        right=left=null;
    }
}
class crud{
    int value;
    tree create(int value){
        tree node=new tree(value);
        return node;
    }
    tree insert(tree root){
        if(root==null){
            root=create(value);
        }
         else if(root.data>value){
               root.left= insert(root.left);
            }
            else{
                root.right=insert(root.right);
            }
            return root;
    }

    void inorder(tree node){
    if(node == null) return;
    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
}

void height(tree root){
    if(root==null){
        
    }
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
}

   }




public class avl{
    public static void main(String[] args) {
        System.out.println("helo");
        int[] a={1,2,3,4,5,6,7,8,9};
        tree root=null;
        crud c=new crud();
        for(int i=0;i<a.length;i++){
            c.value=a[i];
            root=c.insert(root);
        }
        c.inorder(root);
    }
}
