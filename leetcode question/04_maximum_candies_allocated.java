

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = Arrays.stream(candies).max().orElse(0); // Find the maximum candies in a pile

        int i = 1;  // Minimum possible candies each child can get is 1
        int j = maxCandy; // Maximum possible candies each child can get is maxCandy
        int result = 0;

        while (i <= j) {
            int mid = (i + j) / 2;
            long count = find(candies, mid);

            if (count >= k) {
                result = mid; // Update result if mid can be a valid answer
                i = mid + 1;  // Try for a larger number of candies per child
            } else {
                j = mid - 1;  // Try for a smaller number of candies per child
            }
        }

        return result;
    }

    public long find(int[] candies, int n) {
        long s = 0;
        for (int x : candies) {
            s += x / n; // Count how many children can get `n` candies from each pile
        }
        return s;
    }
}
 {
    
}
