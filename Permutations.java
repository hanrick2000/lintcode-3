class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Collections.sort(nums);
        dfs(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(ArrayList<Integer> nums, List<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            dfs(nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}

