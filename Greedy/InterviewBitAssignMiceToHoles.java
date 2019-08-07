import java.util.ArrayList;
import java.util.Collections;

//Problem : https://www.interviewbit.com/problems/assign-mice-to-holes/

public class InterviewBitAssignMiceToHoles {

	public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        
        int answer = 0;
        for(int i = 0; i < A.size(); i++) {
            answer = Math.max(answer, Math.abs(A.get(i) - B.get(i)));
        }
        
        return answer;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(4);
		A.add(-4);
		A.add(2);
		ArrayList<Integer> B = new ArrayList<>();
		B.add(4);
		B.add(0);
		B.add(5);
		System.out.println(mice(A, B));
	}

}
