package challenge;

import java.util.Arrays;
import java.util.List;

public class Question2Day23 {


    public static void main(String[] args) {

        List<Integer> elements= Arrays.asList(10,5,20,3,7,15,30,null,4,null,null,null,17,null,null,null,
                null,null,18);
        ValidTree tree=new ValidTree();
        tree.insert(elements);
        Boolean result=tree.validTree(tree.root);
        System.out.println(result);
    }

}
class ValidTree extends BinaryTree{

    public Boolean validTree(Node1 root){
        return helperMeth(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public Boolean helperMeth(Node1 nodeTree,Integer min,Integer max)
    {
        if (nodeTree==null)
            return true;
        Integer value=nodeTree.element;
        if (value<=min || value>=max)
            return false;

        Boolean left=helperMeth(nodeTree.left,min,nodeTree.element);
        Boolean right=helperMeth(nodeTree.right,nodeTree.element,max);
        return left&&right;
    }
}
