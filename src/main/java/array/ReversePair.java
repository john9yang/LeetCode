package array;

public class ReversePair {
    public int reversePairs(int[] nums) {
        return totalCount(nums, 0, nums.length-1);
    }

    private int totalCount(int []nums, int start, int end){
        if(start >= end) {
            return 0;
        }
        int count = 0;
        int mid = (start+end)/2;
        count  +=  (totalCount(nums, start, mid) + totalCount(nums, mid+1, end)) ;
        count += findCourrentCount(nums, start, end, mid);
        merge(nums, start,end, mid);
        return count;
    }

    private int findCourrentCount(int [] nums, int start, int end, int mid){
        int index1 =start;
        int index2 = mid+1;
        int result = 0;
        while(index1<=mid && index2 <= end){
            if (nums[index1] > ((long) nums[index2]) * 2) {
                result += (mid - index1+1);
                index2++;
            } else {
                index1++;
            }
        }
        return result;
    }

    private void merge(int [] nums, int start, int end, int mid){
        int [] first = new int [mid - start+1];
        int [] last = new int [end - mid];
        for(int i =start;i<= mid;i++) {
            first[i - start] = nums[i];
        }
        for(int i =(mid+1);i<= end;i++) {
            last[i - mid-1] = nums[i];
        }
        int index1 =0;
        int index2 = 0;
        for(int index = start;index<=end;index++){
            if (index2 != last.length && (index1 >= first.length || first[index1] > last[index2])) {
                nums[index] = last[index2++];
            } else {
                nums[index] = first[index1++];
            }
        }
    }

    public static void main(String[] args) {
        ReversePair pair = new ReversePair();
        System.out.println(pair.reversePairs(new int[]{1,3,2,3,1}));
    }
}
