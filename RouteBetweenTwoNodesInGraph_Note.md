### Route Between Two Nodes in Graph

```
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (graph == null) {
            return false;
        }
        
        Set<DirectedGraphNode> set = new HashSet<>();
        Queue<DirectedGraphNode> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode curr = q.poll();
                if (curr == t) {
                    return true;
                }
                set.add(curr); //????
                for (DirectedGraphNode n : curr.neighbors) {
                    if (!set.contains(n)) {
                        q.offer(n);
                    }
                }
            }
        }
        return false;
    }
```    