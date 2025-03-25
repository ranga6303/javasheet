import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

 interface valid {
    public boolean istrue(String exp);
    public boolean balance(String exp);
    public String postfix(String exp);
    public void caluculate(String exp);
}


class validate implements valid{

    public boolean balance(String exp){
            int c=0,i=0;
            int len=exp.length();
    
            while(i<len){
                if(exp.charAt(i)=='(')
                ++c;
                if(exp.charAt(i)==')')
                --c;
    
                ++i;
                }
                if(c==0){
                    return true;
                }
                else{
                    System.out.println("IN EXPRESSION PARANTHSES ARE NOT BALANCEED");
                    return false;
                }
        }

    public boolean istrue(String exp){
            
            int i=0,len=exp.length();
            boolean check=true;
    
            if(((exp.charAt(i)=='/'||exp.charAt(i)=='*'||exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='(')||exp.charAt(i)=='^'||exp.charAt(i)=='.')&&(exp.charAt(i+1)=='/'||exp.charAt(i+1)=='*'||exp.charAt(i+1)=='+'||exp.charAt(i+1)=='-'||exp.charAt(i+1)==')'||exp.charAt(i+1)=='^')){
                check=false;
            }
            
    
            if(exp.charAt(0)=='.'||exp.charAt(0)=='/'||exp.charAt(0)=='*'||exp.charAt(0)=='+'||exp.charAt(0)=='-'||exp.charAt(0)=='^'||(exp.charAt(len-1)=='/'||exp.charAt(len-1)=='*'||exp.charAt(len-1)=='+'||exp.charAt(len-1)=='-')||exp.charAt(len-1)=='.'||!isValid(exp)){
                check=false;
            }
            while(i<len-1&&check==true){
                char ch=exp.charAt(i);
        if((((exp.charAt(i)=='.'||exp.charAt(i)=='/'||exp.charAt(i)=='*'||exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='(')||exp.charAt(i)=='^')&&(exp.charAt(i+1)=='/'||exp.charAt(i+1)=='*'||exp.charAt(i+1)=='+'||exp.charAt(i+1)=='-'||exp.charAt(i+1)==')'||exp.charAt(i+1)=='^'))||((ch=='.'&&exp.charAt(i+1)=='(')||(ch==')'&&exp.charAt(i+1)=='.')||(ch=='.'&&exp.charAt(i+1)=='.'))){
            check=false;
            break;
        }
    
        ++i;
            }
            if(check==false){
                System.out.println(check+"  "+i);
                return false;

            }
            else
            System.out.println(check);
            return true;
    
        }

        public String postfix(String exp){
            Stack<Character> stack=new Stack<>();
            StringBuilder pexp = new StringBuilder();
            int len=exp.length(),i=0,precedence;
    
            
            while(i<len){
    
                if(isdigit(exp.charAt(i))){
                    while(i<len&&isdigit(exp.charAt(i))){
                        pexp.append(exp.charAt(i));
                        ++i;
                    }
    
                    if(isdigit(pexp.charAt(pexp.length()-1)))
                    pexp.append(' ');
    
    
                    if(i<len&&(exp.charAt(i)=='(')){
                        while(!stack.isEmpty()&&isoprater(stack.peek())>=2){
                            pexp.append(stack.pop());
                        }
                    stack.push('*');
                    }
    
                    if(i==len){
                        break;
    
            
                    }
                }
    
                
                if(exp.charAt(i)==')'){
                    while(!stack.isEmpty()&&stack.peek()!='('){
                        pexp.append(stack.pop());
                    }
                    if(!stack.isEmpty())
                    stack.pop();
    
                    if(i+1<len&&(isdigit(exp.charAt(i+1))||exp.charAt(i+1)=='(')){
                        while(!stack.isEmpty()&&isoprater(stack.peek())>=2){
                            pexp.append(stack.pop());
                        }
                    stack.push('*');
                    }
                    }
    
                
                
                if(exp.charAt(i)=='('){
                    stack.push('(');
                }
                
                if(isoprater(exp.charAt(i))>0){
                    precedence=isoprater(exp.charAt(i));
                    
                    
                        
                        if (exp.charAt(i) == '^') {  
                            while (!stack.isEmpty() && isoprater(stack.peek()) > precedence) {  
                                pexp.append(stack.pop());
                            }
                        }
    
                        else{
                        
                        while(!stack.isEmpty()&&isoprater(stack.peek())>=precedence){
                            pexp.append(stack.pop());
                        }
                    }
                    stack.push(exp.charAt(i));
                }
            
                ++i;
    
                }
                while(!stack.isEmpty()){
                    pexp.append(stack.pop());
                }
                exp=pexp.toString();
            return exp;
            }

            public void caluculate(String exp){
            String num;
        Stack<BigDecimal> value=new Stack<>();
        StringBuilder str=new  StringBuilder();
        int size=exp.length(),i=0;
        char ch;

        while(i<size){
            ch=exp.charAt(i);
            
            if(((int)ch>=48&&(int)ch<=57)||ch=='.'){
                while(((int)ch>=48&&(int)ch<=57)||(ch=='.')){
                    str.append(ch);
                    ++i;
                    if(i==size){
                        break;
                    }
                    ch=exp.charAt(i);
                }
                num=str.toString();
                int j=0,dcount=0;

                while(j<num.length()){
                    if(num.charAt(j)=='.')
                    ++dcount;

                    ++j;
                }

                if(dcount>1){
                    System.err.println("invalid");
                    System.exit(0);
                }
                
                value.push(new BigDecimal(num));
                
                
                str.setLength(0);
            }

            else if((int)ch==32){
                ++i;
                continue;
            }

            else{
                
                switch(ch){

                    case '^':
                    double v1=value.pop().doubleValue(),v2=value.pop().doubleValue();
                    double res=(Math.pow(v2,v1));
                    if(Double.isInfinite(res)){
                        System.out.println("infinity");
                        System.exit(0);
                    }
                    value.push(BigDecimal.valueOf(res));
                    break;

                    case '/':
                    BigDecimal b=value.pop();  
                    BigDecimal a=value.pop();  
                    if(b.compareTo(BigDecimal.ZERO)==0){
                        System.out.println("infinity");
                        System.exit(0);
                    }
                    value.push(a.divide(b, 10, RoundingMode.HALF_UP));
                    break;

                    case '*':
                    value.push(value.pop().multiply(value.pop()));
                    break;

                    case '+':
                    value.push(value.pop().add(value.pop()));
                    break;

                    case '-':
                    BigDecimal d=value.pop();  
                    BigDecimal c=value.pop();  

                    value.push(c.subtract(d));
                    break;
                
                    default:
                        break;
                }
            }
            ++i;
            
        }

       System.out.println("result is "+value.pop());
            }
    
            public static  int isoprater(char ch){
                if(ch=='^')
                return 3;
    
                else if(ch=='/'||ch=='*')
                return 2;
    
                else if(ch=='+'||ch=='-')
                return 1;
    
                else if(ch=='(')
                return 0;
    
                else
                return -1; 
            }
    
            public static boolean isdigit(char ch) {
                return (ch >= '0' && ch <= '9')||(ch=='.'); 
            }
        

    boolean isValid(String exp) {
        String sample="0123456789/*+-()=^. ";
        for (char ch : exp.toCharArray()) {  
            if (sample.indexOf(ch) == -1) {  
                return false;
            }
        }
        return true;
    }
    }




class caluculator{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter expression");
        String exp=s.nextLine();
        String pexp;
        exp=exp.replaceAll("\\s+","");
        
        valid obj=new validate();
        if(obj.balance(exp)&&obj.istrue(exp)){
            pexp=obj.postfix(exp);
           System.out.println("postfix expression is "+pexp);
            obj.caluculate(pexp);
        }
        else{
            System.out.println("invalid");
        }
        s.close();        
    }
}

