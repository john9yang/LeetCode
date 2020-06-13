package string;

public class CFG {

    public static void check(char c){
        if ( c >= 'A' && c <= 'Z' ){
            System.out.println("c is capital character");
        }

        if( c >='a' && c <='z' ){
            System.out.println("c is lower case character");
        }

        if( c>='0' && c <='9' ){
            System.out.println("c is a number");
        }
    }

    public static void main(String[] args) {
        check('F');
        check('c');
        check('8');
    }
}