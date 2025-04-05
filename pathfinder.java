import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

class node{
    int data;
    node r=null,c=null,d=null;
    int check[]={-1,-1,-1},sum=0;

            public node(int x){
                this.data=x;
            }
        }

interface agent{
    public void diksuchi(node start,int m,int n);
    public node mine(node start);
        }
        
        class opration implements agent{
            LinkedList<Integer> collection=new LinkedList<>();
            Stack<node> stak=new Stack<>();
            node vright,vleft,end,lastrow,lastcolum,above,preabove,top2=null;
            int nc=0,sum=0,pathcount=0;
            node create(node head,int m,int n,int data){
                node obj=new node(data);
                if(head==null){
                    head=obj;
                    stak.push(obj);
                    lastcolum=obj;
                    lastrow=obj;
                    ++nc;
                    return head;
                }
                else{
                    if(nc<n){
                        lastcolum.r=obj;
                        ++lastcolum.check[0];
                    lastcolum=obj;
                    vright=obj;
                ++nc;
                return head;
            }
            if(nc%n==0){
                above=lastrow;
                lastrow.d=obj;
                ++lastrow.check[2];
                lastrow=obj;
                lastcolum=obj;
                vleft=obj;
                ++nc;
                return head;
            }
            preabove=above;
            above=above.r;
            lastcolum.r=obj;
            ++lastcolum.check[0];
            above.d=obj;
            ++above.check[2];
            preabove.c=obj;
            ++preabove.check[1];
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

public void diksuchi(node start,int m,int n){
    node colum=start,row;
    int count;
    while(colum!=null){
        row=colum;
        while(row.r!=null){
            count=0;
            count=row.check[0]+row.check[1]+row.check[2]+3;
        System.out.print(count+" --- ");
        row=row.r;
        }
        count=0;
            count=row.check[0]+row.check[1]+row.check[2]+3;
        System.out.print(count);
       
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

public node mine(node start){
    if (start == null)
    return null;

    if(start==end){
        sum+=start.data;
        pathcount++;
        collection.add(sum);
        sum-=start.data;
        return null;
    }
          for (int dir=0;dir<3;dir++){
        if(start.check[dir]==0){
            start.check[dir]=1;    
            node next=null;

            if(dir==0)
            next=start.r;

            else if(dir==1)
            next=start.c;

            else if(dir==2)
            next=start.d;

            if(next!=null){
                sum+=start.data;
                stak.push(next);
                mine(next);
                sum-=start.data;
                stak.pop();
                start.check[dir]=0;
            }
       }
    }
    return null;
}
}

public class pathfinder {
    public static void main(String[] args) {
        opration obj=new opration();
        int m=3,n=3,i=1,max,path=1;
        node head=null;
        Scanner s=new Scanner(System.in);
        System.out.println("ENTER NO.OF ROWS : ");
        m=s.nextInt();
        System.out.println("ENTER NO.OF COLUMS : ");
        n=s.nextInt();
        while(i<=m*n){
           head= obj.create(head,m,n,s.nextInt());
           ++i;
        }
       
        System.out.println("---UNDER GROUND MAP OF ISLAND---");
        obj.display(head,m,n);
        System.out.println("TOTAL "+obj.nc+" MINES ARE IN THE MAP");
        System.out.println("---USING DIKSUCHI TO FIND DIRECTIONS AT EACH MINE----");
        agent DO=new opration();
        DO.diksuchi(head, m, n);
        obj.mine(head);
        s.close();
        System.out.println("WITH THE HELP OF MAP AND DIKSUCHI \nWE CALUCULATED EACH PATH HAVE NO.OF GOLLD COINS");
        System.out.println("PATHNUMBER->COLLECTION");
        max=obj.collection.get(0);
        for (int j = 0; j <obj.collection.size(); j++) {
            System.out.println(j+1+" -> "+obj.collection.get(j));
            if(max<obj.collection.get(j)){
                max=obj.collection.get(j);
                path=j+1;
            }
        }
        System.out.println("BEST PATH IS "+path+" HAVE "+max+" GOLD COINS");

}
    }



