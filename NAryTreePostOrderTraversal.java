//LeeCode: 590. N-ary Tree Postorder Traversal
public class NAryTreePostOrderTraversal {
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