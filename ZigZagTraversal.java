import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. 
 */
class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        /* Pseudo:
        at each level -> 
        if flag = true -> L to R
        else           -> R to L
        at each lvl -> keep adding to the list,
        maintain two lists -> one result list and another that gets refreshed at each lvl
        */
        if(root == null)
            return result;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean LtoR = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            LtoR = !LtoR;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(LtoR)
                    list.add(curr.val);
                else
                    list.add(0,curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            result.add(list);
        }
        return result;
    }
}

/* Performance: 
Runtime: 1 ms, faster than 73.87% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 38.4 MB, less than 5.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/