package string;

// Can sub string be arrange in a way that it is the substring of the base string?
// Reorder "abc" --> "cab" and then "cab" is a substring of "taxicab" so we return TRUE
// Otherwise FALSE
class ReorderSubStringSolution {
    public static void main(String[] args) {
        //taaaaxicab
        String base = "taxicab";
        //aaaabc caaaaab bcaaaa aaaabc
        String sub = "abc";
        for (int i = 0; i < sub.length(); i++) {
            sub = shift(sub);
            System.out.println(shift(sub));
            System.out.println(base.contains(sub));
        }
    }

    public static String shift(String s){
        return s.charAt(s.length()-1)+s.substring(0,s.length()-1);
    }
}