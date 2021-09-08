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
