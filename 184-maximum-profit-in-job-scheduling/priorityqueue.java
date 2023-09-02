class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });
        int time = arr[n - 1].deadline;
        int profit = 0;
        int ind = n - 1;
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        int count = 0;
        for (int i = time; i >= 1; --i) {
            while (ind >= 0 && arr[ind].deadline == i) {
                pq.add(arr[ind]);
                ind--;
            }
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                profit += job.profit;
                count++;
            }
        }
        // for (Job job: arr)
        // System.out.println(job.id + " " + job.profit + " " + job.deadline);
        return new int[] { count, profit };
    }
}

/*
 * 1 2 100
 * 2 1 19
 * 3 2 27
 * 4 1 25
 * 5 1 15
 * 
 * 
 * 
 * 
 * 
 * class Job {
 * int id, profit, deadline;
 * Job(int x, int y, int z){
 * this.id = x;
 * this.deadline = y;
 * this.profit = z;
 * }
 * }
 */