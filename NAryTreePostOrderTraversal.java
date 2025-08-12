import java.util.*;

//LeeCode: 590. N-ary Tree Postorder Traversal
public class NAryTreePostOrderTraversal {
    // Definition for a Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            result.add(0, current.val);
            for(Node child : current.children){
                stack.push(child);
            }
        }
        return result;
    }
}
