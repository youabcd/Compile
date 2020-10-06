import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuffer;
import java.io.FileWriter;
import java.util.Scanner;

public class Test {
    public static String str=null;
    public static String out=new String("");
    public static void main(String[] args) {
        /*System.out.println("请输入你需要读取文件的路径：");
        Scanner sc = new Scanner(System.in);
        sc.close();*/
        str=read(args[0]);
        str=str.substring(1,str.length());
        int len=str.length();
        for(int i=0;i<len;i++){
            if(str.charAt(i)==' '||str.charAt(i)=='\n'||str.charAt(i)=='\t'){
                continue;
            }
            else if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
                int j=i;
                StringBuffer k=new StringBuffer("");
                while(str.charAt(j)<='9'&&str.charAt(j)>='0'){
                    k.insert(j-i,str.charAt(j));
                    j++;
                    if(j==len){
                        break;
                    }
                }
                String x=new String(k);
                System.out.println(Judge.check(x));
                out=out+"\n"+Judge.check(x);
                i=j-1;
            }
            else if((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='A'&&str.charAt(i)<='Z')){
                int j=i;
                StringBuffer k=new StringBuffer("");
                while((str.charAt(j)<='9'&&str.charAt(j)>='0')||(str.charAt(j)>='a'&&str.charAt(j)<='z')||(str.charAt(j)>='A'&&str.charAt(j)<='Z')){
                    k.insert(j-i,str.charAt(j));
                    j++;
                    if(j==len){
                        break;
                    }
                }
                String x=new String(k);
                System.out.println(Judge.check(x));
                out=out+"\n"+Judge.check(x);
                i=j-1;
            }
            else if(str.charAt(i)=='*'||str.charAt(i)==','||str.charAt(i)=='('||str.charAt(i)==')'||str.charAt(i)=='+'){
                StringBuffer k=new StringBuffer("");
                k.insert(0,str.charAt(i));
                String x=new String(k);
                System.out.println(Judge.check(x));
                out=out+"\n"+Judge.check(x);
            }
            else if(str.charAt(i)==':'){
                StringBuffer k=new StringBuffer("");
                k.insert(0,str.charAt(i));
                if(str.charAt(i+1)=='='){
                    k.insert(1,'=');
                    i++;
                }
                String x=new String(k);
                System.out.println(Judge.check(x));
                out=out+"\n"+Judge.check(x);
            }
            else{
                System.out.println("Unknown");
                break;
            }
        }
        /*out=out.substring(1,out.length());
        write("C:\\Users\\asus\\Desktop\\out.txt");*/
    }
    private static String read(String file) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader raf = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            raf = new BufferedReader(isr);
            String s = null;
            String ans="";
            while((s = raf.readLine()) != null) {
                ans=ans+"\n"+s;
            }
            return ans;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private static void write(String file){
        try {
            FileWriter fw=new FileWriter(file);
            fw.write(out.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
