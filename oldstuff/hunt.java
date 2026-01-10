import java.util.Scanner;

class node{
    int data;
    node r,c,d;
    public node(int x){
        this.data=x;
        this.r=this.c=this.d=null;
    }
}

class opration{
    node vright,vleft,end;
    node create(node head,int m,int n,int data){
        int i=1,j=1;
        Scanner s=new Scanner(System.in);
        node obj=new node(s.nextInt(data));
        if(head==null){
            head=obj;
            System.out.println("first completed");
            s.close();
            return head;
        }
        else{
            node move=head,pre=null,in=head,temp=head;
            if(j<=n&&move.d==null){
            while(move.r!=null){
                move=move.r;
                ++j;
            }
            move.r=obj;
            ++j;
            if(j==3)
            vright=obj;
            System.out.println("at 1");
            }
            else{
                j=1;
                while(temp.d!=null){
                    pre=temp;
                    temp=temp.d;
                    ++i;
                }
                move=temp;
                while(move.r!=null){
                    move=move.r;
                    ++j;
                }
                if(j==n){
                    temp.d=obj;
                    ++i;
                    if(i==m&&j==1){
                        vleft=obj;
                    }
                    s.close();
                    return head;
                }
                in=pre;
                pre=null;
                move=temp;
            if(i<=m&&j<n){
                while(j<=n&&move.r!=null){
                    move=move.r;
                    pre=in;
                    in=in.r;
                }
                move.r=obj;
                ++j;
                System.out.println("at 2");
            } 
                if(i<m){
                    in.d=obj;
                    if(pre!=null)
                    pre.c=obj;
            }
            if(i==m&&j==n){
                end=obj;
            }
        }
        System.out.println("at 3");
        s.close();
        return head;
    }
}

void display(node start,int m,int n){
    while(start.d!=null){
    while(start.r!=null){
        System.out.print(start.data+"   ");
    }
    System.err.print("null\n\n");
    start=start.d;
}
}
}

public class hunt {
    public static void main(String[] args) {
        opration obj=new opration();
        int m=3,n=3,i=m*n;
        node head=null;
        System.out.println("inserting into list");
        while(i>0){
           head= obj.create(head,m,n,i);
           i--;
        }
        System.out.println("insertion commpleted");
        obj.display(head,m,n);
    }
    
}
