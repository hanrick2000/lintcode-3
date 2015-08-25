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

    public ArrayList<ArrayList<Integer>> permute_iteration(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int n : nums) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(n);
            q.offer(list);
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> curr = q.poll();
                ArrayList<Integer> remain = new ArrayList<Integer>(nums);
                remain.removeAll(curr);
                for (int n : remain) {
                    ArrayList<Integer> list = new ArrayList<>(curr);
                    list.add(n);
                    q.offer(list);
                }
            }
        }
        result.addAll(q);
        return result;
    }
}

