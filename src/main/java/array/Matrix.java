package array;

public class Matrix {

    public int bestMatrixChainOrder(int p[],int i,int j){
        if ( i == j ){
            return 0;
        }

        int k;
        int min = Integer.MAX_VALUE;
        int count;

        //通过把括号放在第一个不同的地方来获取最小的代价
        //每个括号内可以递归地使用相同的方法来计算
        for(k=i; i<j; k++){
            count = bestMatrixChainOrder(p,i,k)+
                    bestMatrixChainOrder(p,k+1,j)+
                    p[i-1]*p[k]*p[j];

            if ( count < min ){
                min = count;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int arr[] = {1,5,2,4,6};
        int n = arr.length;
        System.out.println("最少的乘法次数:"+ matrix.bestMatrixChainOrder(arr,1,n-1));
    }
}
