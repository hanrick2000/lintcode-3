/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * }
 */
public class FindConnectedComponentInUndirectedGraph {
    public List<List<Integer>> connectedSet_bfs(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>(nodes.size());
        for (UndirectedGraphNode node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            Queue<UndirectedGraphNode> q = new LinkedList<>();
            q.offer(node);
            visited.add(node);
            while (!q.isEmpty()) {
                UndirectedGraphNode curr = q.poll();
                list.add(curr.label);
                for (UndirectedGraphNode neighbor : curr.neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            // Collections.sort(list);  // for online assessment
            result.add(list);
        }
        return result;
    }

/*============================================================================*/

    public List<List<Integer>> connectedSet_unionFind(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }

        // initialization
        Map<Integer, Integer> parents = new HashMap<>();
        for (UndirectedGraphNode node : nodes) {
            parents.put(node.label, node.label);
        }

        // union
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                int nodeParent = find(parents, node.label); // or change it to compressFind
                int neighborParent = find(parents, neighbor.label); // compressFind
                if (nodeParent != neighborParent) {
                    parents.put(neighborParent, nodeParent);
                }
            }
        }

        // sort out result
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for (UndirectedGraphNode node : nodes) {
            if (visited.contains(node.label)) {
                continue;
            }
            int parent = find(parents, node.label);
            if (resultMap.containsKey(parent)) {
                resultMap.get(parent).add(node.label);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.label);
                resultMap.put(parent, list);
            }
            visited.add(node.label);
        }

        for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private int find(Map<Integer, Integer> parents, int curr) {
        while (curr != parents.get(curr)) {
            curr = parents.get(curr);
        }
        return curr;
    }

    // compress find
    private int compressFind(Map<Integer, Integer> parents, int curr) {
        int parent = find(parents, curr);
        while (curr != parent) {
            int next = parents.get(curr);
            parents.put(curr, parent);
            curr = next;
        }
        return parent;
    }
}
