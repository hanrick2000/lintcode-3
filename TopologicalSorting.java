/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class TopologicalSorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> count = new HashMap<>(graph.size());
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (count.containsKey(neighbor)) {
                    count.put(neighbor, count.get(neighbor) + 1);
                } else {
                    count.put(neighbor, 1);
                }
            }
        }

        ArrayList<DirectedGraphNode> result = new ArrayList<>(graph.size());
        Queue<DirectedGraphNode> q = new LinkedList<>();
        // add start keys to q.
        for (DirectedGraphNode node : graph) {
            if (!count.containsKey(node)) {
                q.offer(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            result.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                int c = count.get(neighbor);
                if (c == 1) {
                    q.offer(neighbor);
                } else {
                    count.put(neighbor, c - 1);
                }
            }
        }
        return result;
    }
}
