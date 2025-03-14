//import java.util.Scanner;

class node{
    int data;
    node r,c,d;
    public node(int x){
        this.data=x;
        this.r=this.c=this.d=null;
    }
}

class opration{
    node vright,vleft,end,lastrow,lastcolum,above,preabove;
    int nc=0;
    node create(node head,int m,int n,int data){
        System.out.println("inserting "+data);
      //  Scanner s=new Scanner(System.in);
        node obj=new node(data);
        if(head==null){
            head=obj;
            lastcolum=obj;
            lastrow=obj;
            ++nc;
            
         //   s.close();
            return head;
        }
        else{
            if(nc<n){
                lastcolum.r=obj;
                lastcolum=obj;
                vright=obj;
                ++nc;
                return head;
            }
            if(nc%n==0){
                above=lastrow;
                System.out.println("in new row");
                lastrow.d=obj;
                lastrow=obj;
                lastcolum=obj;
                vleft=obj;
                ++nc;
                return head;
            }
            preabove=above;
            above=above.r;
            lastcolum.r=obj;
            above.d=obj;
            preabove.c=obj;
            end=obj;
            lastcolum=obj;
            ++nc;
            return head;
        
        }
    } 


void display(node start,int m,int n){
    node colum=start,row;
    while(colum!=null){
        row=colum;
        while(row.r!=null){
        System.out.print(row.data+" --- ");
        row=row.r;
        }
        System.out.print(row.data);
       
        System.out.println();
        row=colum;
        while(row.r!=null&&colum.d!=null){
            System.out.print("|  *  ");
            row=row.r;
            }
            if(colum.d!=null)
            System.out.print("|");
        System.out.println();
        colum=colum.d;
    }
}
}



public class mine {
    public static void main(String[] args) {
        opration obj=new opration();
        int m=3,n=3,i=m*n;
        node head=null;
        System.out.println("inserting into list");
        while(i>0){
           head= obj.create(head,m,n,i);
           i--;
           System.out.println("nodecount "+obj.nc);
        }
        System.out.println("insertion commpleted \n last data"+obj.end.d);
        
        obj.display(head,m,n);
        System.out.println("displlay complleted");
    }
}
    

