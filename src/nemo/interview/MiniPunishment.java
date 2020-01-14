package nemo.interview;

import cn.hutool.core.lang.Console;

import java.util.*;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName MiniPunishment.java
 * @Description 最小惩罚
 * 给定⼀一个 ⽆无向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。图中⼀一条
 * 路路径的惩罚是指对该路路径上所有边的代价 Ci 执⾏行行位运算或（bitwise OR）操
 * 作得到的。假如⼀一条路路径上包含了了边 M1， M2， M3 … … ， Mk，那么对应的惩
 * 罚就是 C1 OR C2 OR C3 OR ... OR Ck。（OR代表位运算或，即 “|” ）
 * 问题： 给定图上两个节点 start 和 end，找到从 start 到 end 的所有路路径中惩罚
 * 值最⼩小的路路径，对应的最⼩小惩罚值作为结果返回。如果路路径不不存在就返回 -1。
 * 注意： 任意两个节点之间最多存在⼀一条边，图中可能存在有环路路。
 * 需要实现的⽅方法原型:
 * int minPath(int n, int[][] edges, int start, int end)
 * 参数含义：
 * n： 节点总数；节点编号从 1 开始，⼀一直到 n，共有 n 个；
 * edges： ⽆无向图的边； edges[i] 表示边Mi，其中 edges[i][0] 和
 * edges[i][1] 是Mi的两个节点的编号， edges[i][2] 是Mi对应的代价 Ci；
 * start 和 end： 路路径的开始和结束节点编号
 * 限制条件: 1 <= n <=1000
 * 1 <= edges.length <= 10000
 * 1 <= Ci <=1024
 * 例例： edges = [ [1， 2， 1]， [2， 3， 3]， [1， 3， 100] ]，对应的图如下：
 * 当 start = 1， end = 3 时，其最⼩小惩罚路路径是 1->2->3, C(1,2)=1并且C(2,3)=3,
 * 对应的惩罚值为 1 | 3 = 3。
 * @createTime 2020年01月15日 00:51:00
 */
class Node
{
    public int name;
    public List<Node> relationNodes = new ArrayList<Node>();
    public Map<Integer,Integer> map=new HashMap<Integer, Integer>();
}

public class MiniPunishment {


    public Stack<Node> stack = new Stack<Node>();
    public List<Object[]> list = new ArrayList<Object[]>();

    public boolean isNodeInStack(Node node){
        Iterator<Node> it = stack.iterator();
        while (it.hasNext()) {
            Node node1 = (Node) it.next();
            if (node == node1) {
                return true;
            }
        }
        return false;
    }

    public boolean getPaths(Node cNode, Node pNode, Node sNode, Node eNode) {
        Node nNode = null;
        if (cNode != null && pNode != null && cNode == pNode) {
            return false;
        }
        if (cNode != null) {
            int i = 0;
            stack.push(cNode);
            if (cNode == eNode)
            {
                Object[] o = stack.toArray();
                list.add(o);
                return true;
            }else{
                nNode = cNode.relationNodes.get(i);
                while (nNode != null) {
                    if (pNode != null && (nNode == sNode || nNode == pNode || isNodeInStack(nNode))) {
                        i++;
                        if (i >= cNode.relationNodes.size()) {
                            nNode = null;
                        } else {
                            nNode = cNode.relationNodes.get(i);
                        }
                        continue;
                    }
                    if (getPaths(nNode, cNode, sNode, eNode)){
                        stack.pop();
                    }
                    i++;
                    if (i >= cNode.relationNodes.size()) {
                        nNode = null;
                    } else {
                        nNode = cNode.relationNodes.get(i);
                    }
                }
                stack.pop();
                return false;
            }
        } else {
            return false;
        }
    }

    int minPath(int n, int[][] edges, int start, int end){
        if(n==1){
            return edges[0][2];
        }
        start--;
        end--;
        Node[] node = new Node[n+1];
        for(int i=0;i<n;i++){
            node[i]=new Node();
            node[i].name=i;
        }

        for(int i=0;i<edges.length;i++) {
            node[edges[i][0]-1].relationNodes.add(node[edges[i][1]-1]);
            node[edges[i][1]-1].relationNodes.add(node[edges[i][0]-1]);
            node[edges[i][0]-1].map.put(edges[i][1]-1,edges[i][2]);
            node[edges[i][1]-1].map.put(edges[i][0]-1,edges[i][2]);
        }

        getPaths(node[0], null, node[start], node[end]);

        if(list.size()==0) {
            return -1;
        }
        List<Integer> integerList=new ArrayList<Integer>();
        for(Object[] o: list){
            int count=0;
            for(int i=1;i<o.length;i++){
                if(count==0){
                    count=((Node)o[start]).map.get(((Node)o[i]).name);
                }else {
                    count=(count|((Node)o[i-1]).map.get(((Node)o[i]).name));
                }
            }
            integerList.add(count);
        }
        integerList.sort((Integer h1, Integer h2) -> h1>h1?h1:h2);
        return integerList.get(0);
    }

    public static void main(String[] args) {
        MiniPunishment miniPunishment=new MiniPunishment();
//        int[][] edges=new int[][]{
//                {1,2,1},
//                {2,3,3},
//                {1,3,100}
//        };
//        int n=3;
//        int start=1;
//        int end=3;
        int[][] edges=new int[][]{
                {1,2,1},
                {2,3,3},
                {1,5,1},
                {1,3,100}
        };
        int n=5;
        int start=1;
        int end=3;
        Console.log(miniPunishment.minPath(n,edges,start,end));
    }
}
