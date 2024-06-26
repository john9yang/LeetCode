package recurision;

public class MinimumCostSolution2 {
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k])
                j++;
            ans = Math.min(ans, dp(j) + costs[k]);
        }

        memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        MinimumCostSolution2 solution = new MinimumCostSolution2();
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};
        System.out.println(solution.mincostTickets(days,cost));
    }
}
