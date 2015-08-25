public class RouteBetweenTwoNodesInGraph {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (graph == null) {
            return false;
        }

        Set<DirectedGraphNode> set = new HashSet<>();
        Queue<DirectedGraphNode> q = new LinkedList<>();
        q.offer(s);
        set.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode curr = q.poll();
                if (curr == t) {
                    return true;
                }
                for (DirectedGraphNode n : curr.neighbors) {
                    if (!set.contains(n)) {
                        q.offer(n);
                        set.add(n); // add nodes to set when offer them to queue
                    }
                }
            }
        }
        return false;
    }
}
