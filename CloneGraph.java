/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        // copy nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            if (map.containsKey(curr)) {
                continue;
            }
            map.put(curr, new UndirectedGraphNode(curr.label));
            for (UndirectedGraphNode n : curr.neighbors) {
                queue.offer(n);
            }
        }

        // add neighbors
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
            for (UndirectedGraphNode n : entry.getKey().neighbors) {
                entry.getValue().neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}
