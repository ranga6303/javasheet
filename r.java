class node{
    int data;
    node link;
    public node(int x){
        this.data=x;
        this.link=null;
    }
}

class opration{
    int nc=0;
    node last;
    node addnode(node head,int value){
        node obj=new node(value);
        if(head==null){
            head=obj;
            last=obj;
            ++nc;
            return head;
        }
        last.link=obj;
        last=obj;
        ++nc;
        return head;
    }

    node reverse(node head){
        node move,temp=null;
        int stop=nc-1,pos,shift=0;
        while(shift<nc/2){
            pos=0;
            move=head;
            while(pos<stop-1&&move.link!=null){
                move=move.link;
                pos++;
            }
            temp=move.link;
            if(temp==null)
            break;
            move.link=null;
            temp.link=head;
            head=temp;
            stop--;
            shift++;
        }
        return head;
 }

 void display(node head){
    while(head!=null){
        System.out.print(head.data+"->");
        head=head.link;
    }
    System.out.println("null");
 }
    
}

class r{
    public static void main(String[] args) {
        node head=null;
        opration obj=new opration();
        int i=0;
        while(i++<=4){
            System.err.println("inserting "+i);
            head=obj.addnode(head,i);
        }
        System.out.println("insertion completed \n nodecount is "+obj.nc);
        System.out.println("original linked list");
        obj.display(head);
        head=obj.reverse(head);
        System.out.println("reverse linked list");
        obj.display(head);
    }
}