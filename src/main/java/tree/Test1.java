package tree;

/**
 * 如何在二叉树中找出与输入整数相等的所有路径
 */

import java.util.Vector;
public class Test1 {
    /**
     * 方法功能：打印出满足所有结点数据的和等于num的所有路径
     * @param root 二叉树根结点
     * @param num 给定的整数
     * @param sum 当前路径上所有结点的和
     * @param v 用来存储从根结点到当前遍历的结点的路径
     */
    public static void findRoad(BiTNode root, int num, int sum, Vector<Integer> v){
        //记录当前遍历的root结点
        sum+=root.data;
        v.add(root.data);
        //当前结点是叶子结点且遍历的路径上所有结点的和等于num
        if( root.lchild == null && root.rchild == null && sum == num ){
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+" ");
            System.out.println();
        }
        //遍历root的左子树
        if(root.lchild!= null){
            findRoad(root.lchild,num,sum,v);
        }

        //遍历root的右子树
        if(root.rchild!=null){
            findRoad(root.rchild,num,sum,v);
        }

        //清除遍历的路径
        sum-=v.get(v.size()-1);
        v.remove(v.size()-1);
    }

    public static BiTNode constructTree(){
        BiTNode root = new BiTNode();
        BiTNode node1 = new BiTNode();
        BiTNode node2 = new BiTNode();
        BiTNode node3 = new BiTNode();
        BiTNode node4 = new BiTNode();

        root.data = 6;
        node1.data = 3;
        node2.data = -7;
        node3.data = -1;
        node4.data = 9;

        root.lchild = node1;
        root.rchild = node2;

        node1.lchild = node3;
        node1.rchild = node4;

        node2.lchild = node2.rchild=node3.lchild=node3.rchild=node4.lchild=node4.rchild = null;

        return root;
    }

    public static void main(String[] args){
        BiTNode root = constructTree();
        Vector<Integer> s = new Vector<>();
        System.out.println("满足路径结点和等于8的路径为:");
        findRoad(root,8,0,s);
    }
}
