/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class FindConnectedComponentInUndirectedGraph {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            if (!map.containsKey(n)) {
                map.put(n, n);
                Queue<UndirectedGraphNode> q = new LinkedList<>();
                q.offer(n);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        UndirectedGraphNode p = q.poll();
                        for (UndirectedGraphNode c : p.neighbors) {
                            if (!map.containsKey(c)) {
                                map.put(c, p);
                                q.offer(c);
                            }
                        }
                    }
                }
            }
        }

        for (UndirectedGraphNode n : map.keySet()) {
            // find
            UndirectedGraphNode parent = map.get(n);
            while (map.get(parent) != parent) {
                parent = map.get(parent);
            }
            // union
            UndirectedGraphNode next = map.get(n);
            while (next != parent) {
                map.put(n, parent);
                n = next;
                next = map.get(n);
            }
        }

        // reset key-value pair
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        for (UndirectedGraphNode n : map.keySet()) {
            int key = map.get(n).label;
            if (!parentMap.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                list.add(n.label);
                parentMap.put(key, list);
            } else {
                parentMap.get(key).add(n.label);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : parentMap.values()) {
            Collections.sort(l); // =。=
            result.add(l);
        }
        return result;
    }
}



/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, UndirectedGraphNode> parentMap = makeSets(nodes);
        Set<UndirectedGraphNode> visited = new HashSet<>(nodes.size());
        for (for i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode curr = nodes.get(i);
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (visited.contains(neighbor) {
                    continue;
                }
                union(parentMap, curr, neighbor);
            }
            /*
            Queue<UndirectedGraphNode> q = new LinkedList<>();
            q.offer(curr);
            while (!q.isEmpty()) {
                UndirectedGraphNode p = q.poll();
                for (UndirectedGraphNode neighbor : p.neighbors) {
                    if (visited.contains(neighbor) {
                        continue;
                    }
                    union(parentMap, p, neighbor);
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }
            */
        }


    }

    private Map<UndirectedGraphNode, UndirectedGraphNode> makeSets(ArrayList<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, UndirectedGraphNode> parentMap = new HashMap<>(nodes.size());
        for (UndirectedGraphNode node : nodes) {
            map.put(node, node);
        }
    }

    private void union(Map<UndirectedGraphNode, UndirectedGraphNode> parentMap, UndirectedGraphNode p, UndirectedGraphNode n) {
        UndirectedGraphNode pRoot = find(parentMap, p);
        UndirectedGraphNode nRoot = find(parentMap, n);
        parentMap.put(nRoot, pRoot);
    }

    private UndirectedGraphNode find(Map<UndirectedGraphNode, UndirectedGraphNode> parentMap, UndirectedGraphNode node) {
        while (parentMap.get(node) != node) {
            node = parentMap.get(node);
        }
        return node;
    }
}
