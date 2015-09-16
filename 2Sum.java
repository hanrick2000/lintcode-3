public class 2Sum {
    /*
     * Time: O(N)
     * Space: O(N)
     *
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum_hashmap(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int number : numbers) {
            if (map.containsKey(target - number)) {
                result[0] = map.get(number) + 1;
                result[1] = map.get(target - number) + 1;
                if (result[0] > result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                return result;
            }
        }
        throw new IllegalArgumentException();
    }

    /*
     * Time: O(N)
     * Space: O(1)
     */
    public int[] twoSum_twoPointers(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null) {
            return result;
        }
        int[] original = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbers);
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                result[0] = getIndex(original, numbers[low]) + 1;
                result[1] = getIndex(original, numbers[high]) + 1;
                if (result[0] > result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                return result;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

    private int getIndex(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
