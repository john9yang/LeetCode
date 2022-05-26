package dp;

public class MinCoinNumSolution2 {

    public int minCoinNums(int[] coins, int target){
        int len = coins.length;
        int[][] dp = new int[2][target+1];

        if (target == 0){
            return 0;
        }

        for(int i = 0; i < 2;i++)
            dp[i][0] = 0;

        for(int j = 0; j < dp[0].length ;j++)
            dp[0][j] = target+1;

        for(int i = 1; i < len + 1 ; i++)
            for(int j = 1; j < target + 1; j++)
                for(int k = 0; k * coins[i-1] <= j; k++){
                    dp[i % 2][j] = Math.min(dp[(i-1) % 2][j], dp[(i-1) % 2][j - k*coins[i-1]] + k);
                }

        return dp[len % 2][target] > target ? -1 : dp[len % 2][target];
    }

    public static void main(String[] args) {
        MinCoinNumSolution2 solution = new MinCoinNumSolution2();
        int[] coins = new int[]{1,3,9,10};
        int target = 15;
        int result = solution.minCoinNums(coins, target);
        System.out.println("result:"+result);
    }
}
