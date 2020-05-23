package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Max5Solution {

    public static void main(String[] args) {
        Max5Solution solution = new Max5Solution();
        System.out.println(solution.insert5Max(763));
        System.out.println(solution.insert5Max(268));
        System.out.println(solution.insert5Max(-836));
    }

    public int insert5Max(int num){
        List<Integer> list = new ArrayList<>();
        int result = Integer.MIN_VALUE;
        boolean isNegative = false;
        if ( num < 0 ){
            num = -num;
            isNegative = true;
        }

        while( (num/10)!= 0 ){
            list.add(num%10);
            num=num/10;
        }
        list.add(num);
        Collections.reverse(list);

        for(int i = 0;i<list.size();i++){
           list.add(i,5);
           int tmp = list2Number(list);
           if ( isNegative ){
               tmp = - tmp;
           }
           if ( tmp > result ){
               result = tmp;
           }
           list.remove(i);
        }

        return result;
    }

    private int list2Number(List<Integer> list) {
        int result = 0;
        int base = 1;
        for (int j = list.size()-1; j > -1 ; j--) {
            result += list.get(j)*base;
            base *= 10;
        }
        return result;
    }
}
