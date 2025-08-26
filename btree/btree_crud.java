package btree;

public class btree_crud {


    public int value,order;

    public node insert(node parent,node root){
        if(root==null){
            node newnode=new node(order);
            newnode.key[newnode.nkey++]=value;
            return newnode;
        }
        else if(root.child[0]==null){
            return sort(root,value);
        }

        else{
          for(int i=0;i<order-1;i++){
            if(root.key[i]>value&&root.child[i]!=null){
                root=insert(root,root.child[i]);
            }
            else if(root.key[i]<value&&i==order-1){
                root=insert(parent, root);
            }
        }  
        }
        parent=split(parent,root);
        return parent;

    }


    public node split(node parent,node root){
        if(root.nkey<order-1)return root;
        node n1=new node(order),n2=new node(order);
        int max=root.nkey,mid=max/2,popup=root.key[mid];

        for(int i=0,j=mid+1;i<mid||j<max;i++,j++){
            if(i<mid)n1.key[n1.nkey++]=root.key[i];
            if(j<max)n2.key[n2.nkey++]=root.key[j];
        }

        if(root.child[0]!=null){
            for(int i=0,j=mid+1;i<mid+1||j<order;i++,j++){
            if(i<mid+1)n1.child[n1.nchild++]=root.child[i];
            if(j<order)n2.child[n2.nchild++]=root.child[j];
        }
        }
        if(parent==null){
            parent=new node(order);
            parent=sort(parent,popup);
            parent.child[parent.nchild++]=n1;
            parent.child[parent.nchild++]=n2;
        }
        else{
            parent=sort(parent,popup);
            parent.child[parent.nchild-1]=n1;
            parent.child[parent.nchild++]=n2;
        }
        

        return parent;
    }
    node sort(node root,int value){
        root.key[root.nkey++]=value;
        int[] arr=root.key;
        int i=0,j=0,key;
        for(i=0;i<arr.length;i++){
            j=i-1;
            key=arr[i];
            while(key<arr[j]&&j>=0){
                arr[i]=arr[j--];
            }
            arr[j+1]=key;
        }
        root.key=arr;
        return root;
    }
}
