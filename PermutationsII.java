class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Collections.sort(nums);
        dfs(nums, new ArrayList<Integer>(), new boolean[nums.size()], result);
        return result;
    }

    private void dfs(ArrayList<Integer> nums, List<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> result) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        int prev = -1; // first duplicate index
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] || (prev != -1 && nums.get(i) == nums.get(prev))) {
                continue;
            }

            list.add(nums.get(i));
            visited[i] = true;
            dfs(nums, list, visited, result);
            list.remove(list.size() - 1);
            visited[i] = false;
            prev = i;
        }
    }
}

