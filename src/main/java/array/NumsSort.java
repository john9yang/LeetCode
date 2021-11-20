package array;

public class NumsSort {

    public void sortArray(int[] nums){
        int p0 = 0; //指向下一个存0的位置
        int p2 = nums.length - 1; //从右向左,下一个存放2的位置
        int index = p0;

        while(index <= p2){
            if (nums[index] == 1){
                index++;
            }
            else if(nums[index] == 2){
                swap(nums,index,p2--);
            }
            else{
                swap(nums,index++,p0++);
            }
        }
    }

    public void sortArray012(int[] nums){
        int lo = 0;
        int mid = 0;
        int hi = nums.length - 1;
        int temp = 0;

        while (mid <= hi) {
            switch ( nums[mid] ){
                case 0 : {
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    temp = nums[mid];
                    nums[mid] = nums[hi];
                    nums[hi] = temp;
                    break;
                }
            }
        }
    }

    public void swap(int[] nums,int from,int to){
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,2,2,2,2};
        NumsSort ns = new NumsSort();
        ns.sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
