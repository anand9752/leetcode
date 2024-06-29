class Solution {
    public int change(int amount, int[] coins) {
        int prev[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = 1;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            int curr[] = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int nottake = prev[target];
                int take = 0;
                if (target >= coins[i]) {
                    take = curr[target - coins[i]];
                }
                curr[target] = nottake + take;
            }
            prev = curr.clone();
        }
        return prev[amount];
    }
}
