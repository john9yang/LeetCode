package array;

public class ArrayCycleDetect {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,4,-1,3,2};
        System.out.println(countCycles(array1));

        int[] array2 = new int[]{1,0};
        System.out.println(countCycles(array2));

        int[] array3 = new int[]{1,2,1};
        System.out.println(countCycles(array3));

        int[] array4 = new int[]{1,3,0,4,1};
        System.out.println(countCycles(array4));
    }

    public static int countCycles(int[] data){
       int[] counters = new int[data.length];
       int index = 0;
       int count = 0;

       while(index >= 0 && index < data.length && counters[index] == 0){
           counters[index] = count++;
           index = data[index];
       }

       return count;
    }
}
