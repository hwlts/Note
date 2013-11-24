package ACM.LeetCode;

import java.util.*;

/**
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node,
 * and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes,
 * and therefore contains three parts as separated by #.
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle.
 */

public class CloneGraph
{
    public static class UndirectedGraphNode
    {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x)
        {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> visitTable)
    {
        if(null == node)
            return null;

        if(visitTable.containsKey(node.label))
            return visitTable.get(node.label);

        UndirectedGraphNode newnode=new UndirectedGraphNode(node.label);
        visitTable.put(node.label,newnode);

        for(int i=0; i<node.neighbors.size(); i++)
        {
            UndirectedGraphNode neighbor = clone(node.neighbors.get(i),visitTable);
            newnode.neighbors.add(neighbor);
        }

        return newnode;
    }

    /**
     * BFS
     */

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        Map<Integer,UndirectedGraphNode> visitTable = new HashMap<Integer,UndirectedGraphNode>();
        return clone(node,visitTable);
    }
}
