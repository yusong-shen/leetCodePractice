package tripAdvisor;

import java.util.*;

class Job {
	public String name;
	public int numTasks;
	public int neededTime;
	public int startTime;
	public int priority;
	
	public Job(String _name, int _numTasks, int _neededTime, int _startTime, int _priority) {
		this.name = _name;
		this.numTasks = _numTasks;
		this.neededTime = _neededTime;
		this.startTime = _startTime;
		this.priority = _priority;
	}
	
	public String toString() {
		return "name : " + name +
				" numTasks : " + numTasks +
				" neededTime : " + neededTime + 
				" startTime : " + startTime + 
				" priority : " + priority;
				
	}
}

// sort with priority and startTime
class PriorityFirstComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		if (o1.priority < o2.priority) {
			return -1;
		} else if (o1.priority > o2.priority) {
			return 1;
		} else {
			return Integer.compare(o1.startTime, o2.startTime);
		}
	}
	
}

class TimeFirstComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		if (o1.startTime < o2.startTime) {
			return -1;
		} else if (o1.startTime > o2.startTime) {
			return 1;
		} else {
			return Integer.compare(o1.priority, o2.priority);
		}
	}
	
}

public class ScheduleAndroid {

	public ScheduleAndroid() {
		// TODO Auto-generated constructor stub
	}
	
	public static void schedule(ArrayList<String> workers, ArrayList<Job> jobs) {
		int numWorkers = workers.size();
		int numJobs = jobs.size();
		Collections.sort(jobs, new TimeFirstComparator());
		int time = 0;
		for (Job job : jobs) {
//			System.out.println(job);
			int round = (int) Math.ceil(job.numTasks / (numWorkers + 0.0));
			int complete = round * job.neededTime;
//			System.out.format("round : %d, complete time : %d\n", round, complete);
			// if the job can't be started yet, then wait
			int start = (time > job.startTime) ? time : job.startTime; 
			// start working at the same time
			for (String worker : workers) {
				System.out.println(start + " " + worker
						+ " " + job.name);
			}
			time += complete + 1;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		the name of the job, 
//		the number of tasks in the job, 
//		how long each task takes to complete, 
//		the earliest time the job can be started, 
//		and the job priority.
//		job job_0 79 25 15 2
//		job job_1 56 15 9 8
//		job job_2 97 7 5 6
//		job job_3 56 33 12 2
//		job job_4 8 25 4 1
//		job job_5 71 1 0 7
//		job job_6 77 10 5 6
//		job job_7 60 27 5 2
//		job job_8 3 32 15 7
//		job job_9 96 31 10 6
//		job job_10 61 27 30 3
//		worker android_0
//		worker android_1
//		worker android_2
//		worker android_3
//		worker android_4
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			ArrayList<String> workers = new ArrayList<>();
			ArrayList<Job> jobs = new ArrayList<>();
			while (scan.hasNextLine()) {
//				System.out.println(scan.nextLine());
				String line = scan.nextLine();
				String[] strs = line.split(" "); 
				if (line.startsWith("job")) {
					String name = strs[1];
					int numTasks = Integer.parseInt(strs[2]);
					int neededTime = Integer.parseInt(strs[3]);
					int startTime = Integer.parseInt(strs[4]);
					int priority = Integer.parseInt(strs[5]);
					Job job = new Job(name, numTasks, neededTime, startTime, priority);
					jobs.add(job);
				} else if (line.startsWith("worker")) {
					workers.add(strs[1]);
				}
			}
			schedule(workers, jobs);
		}
		finally {
			if (scan != null) {
				scan.close();
			}
		}		
	}

}
