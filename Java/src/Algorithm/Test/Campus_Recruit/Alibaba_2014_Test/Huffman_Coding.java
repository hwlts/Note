package Algorithm.Test.Campus_Recruit.Alibaba_2014_Test;

import java.util.*;

public class Huffman_Coding
{
    public static String HuffmanCode(String s)
    {
        if (s.length() <= 1)
            return "0";

        //construct the map
        Map<Character,Integer> m = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); ++i)
        {
            if (!m.containsKey(s.charAt(i)))
            {
                m.put(s.charAt(i),1);
            }
            else
            {
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }
        }

        //tree node
        class Node
        {
            char character;
            int times;
            Node left;
            Node right;
            String ns;

            public Node(char c,int i)
            {
                character = c;
                times = i;
            }
        }

        List<Node> l = new LinkedList<Node>();
        Iterator<Map.Entry<Character,Integer>> iter = m.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<Character,Integer> e = iter.next();
            l.add(new Node(e.getKey(),e.getValue()));
        }

        Collections.sort(l,new Comparator<Node>()
        {
            @Override
            public int compare(Node o1, Node o2)
            {
                return Integer.compare(o1.times, o2.times);  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        Node[] nonLeaf = new Node[l.size()-1];
        int nonLeafIndex = l.size()-2;
        nonLeaf[nonLeafIndex] = new Node('a',l.get(0).times+l.get(1).times);
        nonLeaf[nonLeafIndex].left = l.get(0);
        nonLeaf[nonLeafIndex].right = l.get(1);
        nonLeafIndex--;
        int lIndex = 2;
        while (nonLeafIndex >= 0)
        {
            nonLeaf[nonLeafIndex] = new Node('a',l.get(lIndex).times+nonLeaf[nonLeafIndex+1].times);
            nonLeaf[nonLeafIndex].left = l.get(lIndex);
            nonLeaf[nonLeafIndex].right = nonLeaf[nonLeafIndex+1];
            nonLeafIndex--;
            lIndex++;
        }

        nonLeaf[0].ns = "";
        for (int i = 0; i < nonLeaf.length; ++i)
        {
            nonLeaf[i].left.ns = nonLeaf[i].ns+"0";
            nonLeaf[i].right.ns = nonLeaf[i].ns +"1";
        }

        Map<Character,String> char_To_Str = new HashMap<Character, String>();
        for (Node n : l)
        {
            char_To_Str.put(n.character,n.ns);
        }

        String r = "";
        for (int i = 0; i < s.length(); ++i)
        {
            r += char_To_Str.get(s.charAt(i));
        }
        return r;
    }

    public static void main(String[] args)
    {
        String s = "alibaba";
        System.out.println(HuffmanCode(s));
    }
}
