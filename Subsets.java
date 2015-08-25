class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(S);
        dfs(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(ArrayList<Integer> S, int index, List<Integer> list, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(list));

        for (int i = index; i < S.size(); i++) {
            list.add(S.get(i));
            dfs(S, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
