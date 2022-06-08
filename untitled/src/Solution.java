import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();
            String s=String.valueOf(n);
            System.out.println(n+""+s);
            int sum=0;
            for(int i=0;i<s.length();i++){
                sum+=(s.charAt(i)-'0');
            }
            int diff=0;
            if(sum%9!=0){
                diff=9-(sum%9);
            }
            String s2="";
            boolean flag=false;
            int m=s.length();
            for(int i=0;i<m;i++){
                if(flag)
                    break;
                if((s.charAt(i)-'0')>diff){
                    if(i==0 && diff==0){
                        continue;
                    }
                    else{
                        s2=s.substring(0,i)+String.valueOf(diff)+s.substring(i,m);
//                        System.out.println(s.substring(0,i)+" "+s.substring(i,m));
                        flag=true;
                }
            }
        }
            if(!flag){
                s2=s+String.valueOf(diff);
            }
            System.out.println("Case #"+(t+1)+": "+s2);
    }
}
}
