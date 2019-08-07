import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//Problem : https://www.geeksforgeeks.org/job-sequencing-problem-loss-minimization/
public class JobSequencingLossMinimization {
	static class Job {
		int days;
		int loss;
		int jobIndex;
		public Job(int i, int d, int l) {
			jobIndex = i;
			days = d;
			loss = l;
		}
	}
	
	private static Comparator<Job> getComparator() {
		return new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return ((a.loss * b.days) < (b.loss * a.days)) ? 1 : -1;
			}
			
		};
	}
	
	private static ArrayList<Job> getJobSequence(int[] L, int[] T, int n) {
		ArrayList<Job> jobs = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			jobs.add(new Job((i + 1), T[i], L[i]));
		}
		
		Collections.sort(jobs, getComparator());
		
		return jobs;
	}
	public static void main(String[] args) {
		int[] L = {3, 1, 2, 4};
		int[] T = {4, 1000, 2, 5};
		
		ArrayList<Job> jb = getJobSequence(L, T, L.length);
		for(Job j : jb) {
			System.out.println(j.jobIndex+" ");
		}
	}
}
