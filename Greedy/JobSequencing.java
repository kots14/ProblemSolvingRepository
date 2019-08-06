import java.util.*;
public class JobSequencing {
	static class Job {
		char id;
		int deadline;
		int profit;
		public Job(char i, int d, int p) {
			id = i;
			deadline = d;
			profit = p;
		}
	}
	
	private static Comparator<Job> getComparator() {
		return new Comparator<Job>() {
			public int compare(Job a, Job b) {
                return (a.profit > b.profit) ? -1 : 1;
            }
		};
	}
	//Time complexity : O(n^2)
	private static ArrayList<Job> getJobSequence(ArrayList<Job> aj) {
		int N = aj.size();
		Collections.sort(aj, getComparator());
		
		ArrayList<Job> temp = new ArrayList<>();
		ArrayList<Boolean> slots = new ArrayList<>();
		
		//initializing all slots as free slots
		for(int i = 0; i < N; i++) {
			slots.add(i, false);
			temp.add(i, null);
		}

		for(Job jb : aj) {
			for(int j = 0; j < Math.min(N, jb.deadline); j++) {
				if(!slots.get(j)) {
					temp.add(j, jb);
					slots.add(j, true);
					break;
				}
			}
		} 
	    
	    //preparing the result array
	    ArrayList<Job> result = new ArrayList<>();
	    for(int i = 0; i < N; i++) {
	    	if(slots.get(i))
	    		result.add(temp.get(i));
	    }
	    
	    return result;
	}
	public static void main(String[] args) {
		ArrayList<Job> aj = new ArrayList<>();

		aj.add(new Job('a', 2, 100));
		aj.add(new Job('b', 1, 19));
		aj.add(new Job('c', 2, 27));
		aj.add(new Job('d', 1, 25));
		aj.add(new Job('e', 3, 15));
		
		
		for(Job j : getJobSequence(aj)) {
	    	System.out.println(j.id);
	    }

	}

}
