public class LowestCommonAncesstor {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null){
            if(p.val < root.val && q.val < root. val){
                root = root.left;
            }else if( p.val > root.val && q.val > root. val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
