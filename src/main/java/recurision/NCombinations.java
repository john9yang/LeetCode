package recurision;

public class NCombinations {

    /**
     * 求和为n的所有整数组合
     */
    private static void getAllCombination(int sum,int[] result,int count){
        if (sum < 0)
            return;

        int i;

        if (sum == 0){
            System.out.println("满足条件的组合：");
            for (i = 0; i < count; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        i = 1;
        for(;i <= sum;){
            result[count++] = i;
            getAllCombination(sum-i,result,count);
            count--;
            i++;
        }
    }

    public static void showAllCombinations(int n){
        if (n < 1){
            System.out.println("参数不满足要求");
            return;
        }
        int[] result = new int[n];
        getAllCombination(n,result,0);
    }

    public static void main(String[] args) {
        showAllCombinations(4);
    }
}
