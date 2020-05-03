package array;

public class Matrix2 {

    int bestMatrixChainOrder(int p[],int n){
        //申请数组保存中间结果,为了简单m[0][0]没有用
        //cost[i,j]=计算A[i]*A[i+1]....*A[j]所需的标量乘法的最小数量
        //其中A[i]的维数是p[i-1]*p[i]
        int[][] cost = new int[n][n];
        int i,j,k,cLen,q;
        for (i = 1; i < n; i++) {
            cost[i][i] = 0;
        }

        //cLen表示矩阵链的长度
        for (cLen = 2; cLen < n; cLen++) {
            for (i = 1; i < n-cLen; i++) {
                j = i+cLen-1;
                cost[i][j] = Integer.MAX_VALUE;
                for(k=i; k<=j-1 ;k++){
                    //计算乘法运算的代价
                    q = cost[i][k]+cost[k+1][j]+p[i-1]*p[k]*p[j];
                    if ( q < cost[i][j] ){
                        cost[i][j] = q;
                    }
                }
            }
        }
        return cost[1][n-1];
    }

    public static void main(String[] args) {
        Matrix2 matrix2 = new Matrix2();
        int arr[] = {1,5,2,4,6};
        int n = arr.length;
        System.out.println("最少的乘法次数为:"+matrix2.bestMatrixChainOrder(arr,n));
    }
}
