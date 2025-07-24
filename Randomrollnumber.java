import java.util.*;
public class random {
    public static void main(String[]args){
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        char[] alpha={'J','K','L','M','N','O','P','Q'};
        String[] repted=new String[67];
        String str;
        int num=0,index=0,i=0;
        boolean check=false;
        System.out.println("AT ANY TIME PRESS FOR\n1.RANDOM ROLLNUMER\n2.EXIT");
        while(i<66){
            check=false;
            index=r.nextInt(8);
            num=r.nextInt(10);
            if(index==0&&(num!=7&&num!=8&&num!=9))continue;
            if(index==7&&(num!=0&&num!=1&&num!=2))continue;
            str=Character.toString(alpha[index])+num;
            if(i>0){
                for(int j=0;j<65;j++){
                    if(str.equals(repted[j])){
                        check=true;
                        break;
                    }
                }
            }
            if(check==true)continue;   
            if(s.nextInt()==2)break;
            System.out.println(str);
            repted[i++]=str;
        }
    s.close();
    }
          
