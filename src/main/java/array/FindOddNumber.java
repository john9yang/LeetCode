package array;

public class FindOddNumber {
    
    public static void get2Num(int[] arr){
        if ( arr == null || arr.length < 1 ){
            System.out.println("参数不合理");
            return;
        }
        
        int result = 0;
        int position = 0;
        //计算数组中所有数字异或的结果
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        //临时保存异或结果
        int tmpResult = result;
        //找出异或结果中其中一个位值为1的位数(如 1100,位值为1的位数为2和3)
        for (int i = result; (i&1) ==0 ; i=i>>1) {
            position++;
        }

        for (int i = 0; i < arr.length; i++) {
            //异或的结果与所有第position位为1的熟异或,结果一定是出现一次的两个数中其中一个
            if ( ((arr[i]>>position) & 1) == 1 ){
                result = result ^ arr[i];
            }
        }

        System.out.println(result);
        //得到另外一个出现一次的数
        System.out.println(result^tmpResult);
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,6,5,7,2,2};
        get2Num(arr);
    }
    
}
