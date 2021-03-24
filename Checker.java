public class Checker {
    
    public static boolean checker(String str){
        int front =0;
        int back = 0;

        for(int x=0; x < str.length(); x++){
            char c = str.charAt(x);
            if(c == '(')
                front += 1;
            else if(c == ')')
                back += 1;

            if(back > front)
                return false;
        }

        if( front == back)
            return true;
        else    
            return false;
        }
    public static void main(String[] args) throws Exception {
        String str = "(8 + 8)";

        boolean val = checker(str);
        System.out.println(val);


    }
}
