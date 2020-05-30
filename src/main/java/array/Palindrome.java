package array;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main (String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("aba",0,2));
        System.out.println(palindrome.isPalindrome("abba",0,3));
        System.out.println(palindrome.isPalindrome("abc",0,2));
        System.out.println(palindrome.isPalindrome("",0,0));
        System.out.println(palindrome.partition("aab"));
    }

    public boolean isPalindrome(String s,int low,int high) {
        if ( s == null || s.length() == 0) {
            return false;
        }

        while( low <= high ){
            if (s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0){
            return result;
        }
        helper(result,new ArrayList<>(),s,0);
        return result;
    }

    private void helper(List<List<String>> result,List<String> cur,String s,int lo){
        if (lo==s.length()){
            result.add(new ArrayList<>(cur));
            return;
        }

        int n = s.length();
        for (int hi = lo; hi < n; hi++) {
            if (isPalindrome(s,lo,hi)){
                cur.add(s.substring(lo,hi+1));
                helper(result,cur,s,hi+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
