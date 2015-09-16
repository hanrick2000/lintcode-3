public class 4Sum {
    /**
     * Time: O(N^3)
     * Space: O(1)
     *
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = numbers.length - 1;
                while (low < high) {
                    if (low > j + 1 && numbers[low] == numbers[low - 1]) {
                        low++;
                        continue;
                    }
                    if (high < numbers.length - 1 && numbers[high] == numbers[high + 1]) {
                        high--;
                        continue;
                    }

                    int sum = numbers[i] + numbers[j] + numbers[low] + numbers[high];
                    if (sum == target) {
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.add(numbers[i]);
                        solution.add(numbers[j]);
                        solution.add(numbers[low]);
                        solution.add(numbers[high]);
                        result.add(solution);

                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}

