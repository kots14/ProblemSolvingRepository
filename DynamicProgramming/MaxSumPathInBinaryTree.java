//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
public class MaxSumPathInBinaryTree {
	static class Node {
        int data = Integer.MIN_VALUE;
        Node left = null;
        Node right = null;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
	private static int result = Integer.MIN_VALUE;	
	private static int maxSumPath(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		int leftSubTreeSum = maxSumPath(root.left);
		int rightSubTreeSum = maxSumPath(root.right);
		
		int current = Math.max(root.data, Math.max(root.data + leftSubTreeSum, root.data + rightSubTreeSum));
		result = Math.max(result, Math.max(current, leftSubTreeSum + root.data + rightSubTreeSum));
        return result;
	}
	public static void main(String[] args) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        System.out.println(maxSumPath(root));
        System.out.println(result);
	}

}
