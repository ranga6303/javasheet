import java.util.*;

class node{
    int data;
    node l,r;

    node(int value){
        this.data=value;
        this.l=null;
        this.r=null;
    }

}

class verify{

    node balance(node root){
        if(bf(root)>1){
            if(bf(root.l)==1)root=ll(root);
            else root=lr(root);
        }

        else if(bf(root)<-1){
            if(bf(root.r)==-1)root=rr(root);
            else if(bf(root.r)==1) root=rl(root);
        }
        return root;
    }

    int height(node root){
        if(root==null)return 0;
        return Math.max(height(root.l),height(root.r))+1;
    }

    int bf(node root){
        return height(root.l)-height(root.r);
    }

    node rr(node root){
        node t=root.r;
        root.r=t.l;
        t.l=root;
        return t;
    }

    node ll(node root){
        node t=root.l;
        root.l=t.r;
        t.r=root;
        return t;
    }

    node rl(node root){
        node t1=root.r, t2=t1.l;
        t1.l=t2.r;
        t2.r=t1;
        root.r=t2.l;
        t2.l=root;
        return t2;
    }

    node lr(node root){
        node t1=root.l, t2=t1.r;
        t1.r=t2.l;
        t2.l=t1;
        root.l=t2.r;
        t2.r=root;
        return t2;
    }
}

class crud{
 verify v=new verify();    
 int value;

    node insert(node root){
       
        if(root==null)return new node(value);

        else if(root.data>value){
            root.l=insert(root.l);
            root=v.balance(root);
        }
        else if(root.data<value){
            root.r=insert(root.r);
            root=v.balance(root);
        }

        return root;
    }

    void postorder(node root){
        if(root==null)return ;
        postorder(root.l);
        postorder(root.r);
        System.out.print(root.data+", ");
    }

}

class avl{
    public static void main(String[]args){

        node root=null;
        Scanner s=new Scanner(System.in);
        int len;
        System.out.print("enter size : ");
        len=s.nextInt();
        crud c=new crud();

        for(int i=0;i<len;i++){
            c.value=s.nextInt();
            root=c.insert(root);
        }
        c.postorder(root);
        s.close();
    }
}