    import java.util.*;

    
    class node {
    int[] key;
    node[] child;
    int nkey,nchild;
    node(int order){
        this.child=new node[order+1];
        this.key=new int[order];
    }
}

  class btree_crud {
    Queue<node> q=new LinkedList<>();

    public int value,order;

     node insert(node parent,node root){
        if(root==null){
            root=new node(order);
            root.key[root.nkey++]=value;
            return root;
        }
        else if(root.child[0]==null){
            root=sort(root,value);
            if(root.nkey<order){
                if(parent==null)return root;
                return parent;
            }
        }

        else{
          for(int i=0;i<root.nkey;i++){
            if(root.key[i]>value){
                root=insert(root,root.child[i]);
                break;
            }
            else if(root.key[i]<value&&i+1==root.nkey){
                root=insert(root, root.child[i+1]);
                break;
            }
        }  
        }
        if(root.nkey<order){
                return root;
            }
        return split(parent,root);

    }


    public node split(node parent,node root){ 
         
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
         else {
        // Step 4: Find position to insert popup key
        int pos = findInsertPosition(parent, popup);
        sort(parent, popup);

        // Step 5: Shift children to make room for new child n2
        for (int i = parent.nchild; i > pos + 1; i--)
            parent.child[i] = parent.child[i - 1];

        // Step 6: Replace the old child (root) with n1 and n2
        parent.child[pos] = n1;
        parent.child[pos + 1] = n2;
        parent.nchild++;
    }
        

        return parent;
    }

    int findInsertPosition(node parent, int value) {
    int i = 0;
    while (i < parent.nkey && parent.key[i] < value) i++;
    return i;
} 


    node sort(node root,int value){
        root.key[root.nkey++]=value;
        int[] arr=root.key;
        int i=0,j=0,key;
        for(i=0;i<root.nkey;i++){
            j=i-1;
            key=arr[i];
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j--];
            }
            arr[j+1]=key;
        }
        root.key=arr;
        return root;
    }

    public void display(node root) {
        if (root == null)
            return;
        
        Queue<node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        
        while (!levelQueue.isEmpty()) {
            int levelSize = levelQueue.size();
            for (int i = 0; i < levelSize; i++) {
                node current = levelQueue.poll();
                
                for (int j = 0; j < current.nkey; j++) {
                    System.out.print(current.key[j] + ", ");
                }
                System.out.print(" | ");
                
                for (int j = 0; j < current.nchild; j++) {
                    if (current.child[j] != null) {
                        levelQueue.add(current.child[j]);
                    }
                }
            }
            System.out.println();
        }
    }
    }

    

public class hello {
    public static void main(String[]args){
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int len=arr.length;
        System.out.println(len);
        node root=null, parent=null;
        btree_crud c = new btree_crud();
        c.order=3;
        for(int i=0;i<len;i++){
            c.value=arr[i];
            root=c.insert(parent,root);
            System.out.println();
            System.out.print(arr[i]+"==> ");
            c.display(root);
            
        }
        
    }
}


