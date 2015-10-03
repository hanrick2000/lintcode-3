public class SubarraySum {
    /**
     * Time: O(N^2)
     * Space: O(1)
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum_bruteForce(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (nums == null) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public ArrayList<Integer> subarraySum_hashMap(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        sums.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sums.containsKey(sum)) {
                result.add(sums.get(sum));
                result.add(i);
                return result;
            } else {
                sums.put(sum, i + 1);
            }
        }
        return result;
    }
}
