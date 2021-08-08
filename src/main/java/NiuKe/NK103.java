package NiuKe;

public class NK103 {
    public String solve (String str) {
        // write code here
        StringBuilder res = new StringBuilder();
        
        char[] ch = str.toCharArray();
        
        for (int i = str.length() - 1; i >= 0; i--){
            res.append(ch[i]);
        }
        
        return res.toString();
    }
}
