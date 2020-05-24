package array;

public class TaskSchedule {

    public static void main(String[] args) {
        int t[] = {7,10};
        int n = 6;
        int proTime[] = caculate_process_time(t,n);
        if ( proTime == null ){
            System.out.println("分配失败");
            return;
        }
        int totalTime = proTime[0];
        for (int i = 0; i < proTime.length; i++) {
            System.out.println("第"+(i+1)+"台服务器有"+proTime[i]/t[i]+"个任务,执行总时间为:"+proTime[i]);
            if ( proTime[i] > totalTime ){
                totalTime = proTime[i];
            }
        }
        System.out.println("执行完所有任务所需的时间为"+totalTime);
    }

    /**
     *
     * @param t 每个服务器处理的时间
     * @param n 任务的个数
     * @return  各个服务器执行完任务所需的时间
     */
    private static int[] caculate_process_time(int[] t,int n){
        if ( t==null || n <= 0 ){
            return null;
        }

        int m = t.length;
        int minIndex;
        int minTime;
        int[] proTime = new int[m];
        for(int i=0;i<n;i++){
            //把任务给第j个机器上后这个机器的执行时间
            minTime = proTime[0]+t[0];
            minIndex = 0;
            for (int j = 0; j < m; j++) {
                //分配到第j台机器上后执行时间更短
                if ( minTime > proTime[j]+t[j] ){
                    minTime = proTime[j]+t[j];
                    minIndex = j;
                }
            }
            proTime[minIndex]+=t[minIndex];
        }
        return proTime;
    }
}
