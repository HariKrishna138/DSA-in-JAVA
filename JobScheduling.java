import java.util.*;
class Job{
    int id;
    int deadline,profit;
    Job(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobScheduling{
    public static void schedulejobs(Job[] jobs){
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int n=jobs.length;
        boolean[] slots=new boolean[n];
        int[] result=new int[n];
        int totalprofit=0;
        for(Job job:jobs){
            for(int j=job.deadline-1;j>=0;j--){
                if(!slots[j]){
                    slots[j]=true;
                    result[j]=job.id;
                    totalprofit+=job.profit;
                    break;
                }
            }
        }
        System.out.println("Selected jobs: ");
        for(int job:result){
            if(job!=0){
                System.out.println(job+" ");
            }
        }
        System.out.println("Total profit: "+totalprofit);
    }
    public static void main(String[] args) {
        Job[] jobs={
            new Job(1,1,100),
            new Job(2,1,19),
            new Job(3,2,27),
            new Job(4,2,27),
            new Job(5,1,25),
        };
        schedulejobs(jobs);
    }
}