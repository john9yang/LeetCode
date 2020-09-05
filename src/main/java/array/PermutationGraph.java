package array;

import java.util.HashSet;

public class PermutationGraph {
    private int numbers[] = {1,2,2,3,4,5};
    private int n = 6;
    //用来标记图中结点是否被遍历过
    private boolean[] visited;
    //图的二维数组表示
    private int[][] graph;
    //数字的组合
    private StringBuffer combinations = new StringBuffer();
    //存放所有的组合
    private HashSet<String> s = new HashSet<>();

    public PermutationGraph(int[] arr){
        numbers = arr;
        visited = new boolean[numbers.length];
        graph = new int[numbers.length][numbers.length];
    }

    /**
     * 对图从结点start位置开始进行深度遍历
     *
     */
    private void depthFirstSearch(int start){
        visited[start] = true;
        combinations.append(numbers[start]);
        if ( combinations.length() == n ){
            if ( combinations.indexOf("4") != 2 ){
                s.add(combinations.toString());
            }
        }

        for (int j = 0; j < n; j++) {
            if (graph[start][j] == 1 && !visited[j] ){
               depthFirstSearch(j);
            }
        }

        combinations.delete(combinations.length()-1,combinations.length());
        visited[start] = false;
    }

    /**
     * 获取1,2,2,3,4,5的所有组合,使得4不能在第三位,3与5不能相邻
     */
    public void getAllCombinations(){
        int i;
        for ( i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == j ){
                    graph[i][j] = 0;
                }
                else{
                    graph[i][j] = 1;
                }
            }
        }


        graph[3][5] = 0;
        graph[5][3] = 0;

        //从不同的结点出发遍历
        for (i = 0; i < n; i++) {
            depthFirstSearch(i);
        }

    }

    public void printAllCombinations(){
        for(String str : s){
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5};
        PermutationGraph graph = new PermutationGraph(arr);
        graph.getAllCombinations();
        graph.printAllCombinations();
    }
}
