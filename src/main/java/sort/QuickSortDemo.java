package sort;

public class QuickSortDemo {

    public void quickSort(int[] nums, int low, int high){
        //从后向前的指针
        int end = high;
        //从前向后的指针
        int start = low;
        //基准值取数组第一个
        int key = nums[low];
        while(start < end){
            //从后向前找比基准值小的交换位置
            while(end > start && nums[end] >= key){
                end--;
            }
            int tmp;
            if(nums[end] < key){
                tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
            }
            //从前向后找比基准值大的交换位置
            while(start < end && nums[start] <= key){
                start++;
            }
            if(nums[start] > key){
                tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
        //递归左半边
        if(start > low){
            quickSort(nums,low,start-1);
        }
        //递归右半边
        if(end < high){
            quickSort(nums,end+1,high);
        }
    }

    public static void main(String[] args) {
        QuickSortDemo demo = new QuickSortDemo();
        int[] nums = {6,9,5,7,8};
        demo.quickSort(nums,0, nums.length-1);
        for(int num : nums){
            System.out.print(num+ " ");
        }
        System.out.println();
    }
}
