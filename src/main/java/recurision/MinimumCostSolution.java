package recurision;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostSolution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[365];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);

        return dp(1);
    }

    public int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i+1) + costs[0],
                    dp(i+7) + costs[1]);
            ans = Math.min(ans, dp(i+30) + costs[2]);
        } else {
            ans = dp(i+1);
        }

        memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        MinimumCostSolution solution = new MinimumCostSolution();
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};
        System.out.println(solution.mincostTickets(days,cost));
    }
}
