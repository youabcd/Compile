public class Judge {
    public static String[] token={"BEGIN","END","FOR","IF","THEN","ELSE",":","+","*",",","(",")",":="};
    public static String[] out_type={"Begin","End","For","If","Then","Else","Colon","Plus","Star","Comma","LParenthesis","RParenthesis","Assign"};
    public static String check(String x){
        int l=token.length;
        int k=-1,k1=-1;
        for(int i=0;i<l;i++) {
            if (token[i].equalsIgnoreCase(x)) {
                k = i;
                return out_type[k];
            }
        }
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)>'9'||x.charAt(i)<'0'){
                k1=0;
                break;
            }
        }
        if(k1==-1){
            return "Int("+Integer.valueOf(x)+")";
        }
        if(k1==0){
            return "Ident("+x+")";
        }
        return "Unknown";
    }
}