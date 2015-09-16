public class 3Sum {
    /**
     * Time: O(N^2)
     * Space: O(1)
     *
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                if (low > i + 1 && numbers[low] == numbers[low - 1]) {
                    low++;
                    continue;
                }
                if (high < numbers.length - 1 && numbers[high] == numbers[high + 1]) {
                    high--;
                    continue;
                }

                int sum = numbers[i] + numbers[low] + numbers[high];
                if (sum == 0) {
                    ArrayList<Integer> solution = new ArrayList<>(3);
                    solution.add(numbers[i]);
                    solution.add(numbers[low]);
                    solution.add(numbers[high]);
                    result.add(solution);
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
