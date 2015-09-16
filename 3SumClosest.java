public class 3SumClosest {
    /**
     * Time: O(N^2)
     * Space: O(1)
     *
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);

        int result = 0;
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[i] + numbers[low] + numbers[high];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < difference) {
                    difference = Math.abs(sum - target);
                    result = sum;
                }
                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                }
            }
        }
        return result;
    }
}

