package challenge;

import java.util.Arrays;
import java.util.List;

public class Question1Day23HeightBalanceTree {

    public static void main(String[] args) {

        Question1Day23HeightBalanceTree insert=new Question1Day23HeightBalanceTree();
        List<Integer> elements= Arrays.asList(1,2,3,4,5);
        NodeHBT node=insert.insert(elements);
        System.out.println(node);
    }

    public NodeHBT insert(List<Integer> elements)
    {
        if (elements.isEmpty())
        {
            return null;
        }
        NodeHBT response=recursionInsert(elements,0,elements.size()-1);
        return response;
    }

    private NodeHBT recursionInsert(List<Integer> elements, int start, int end) {

        if (start>end)
            return null;

        int mid=Math.round((start+end)/2);
        NodeHBT node=new NodeHBT(elements.get(mid));
        node.left=recursionInsert(elements,start,mid-1);
        node.right=recursionInsert(elements,mid+1,end);
        return node;
    }
}
class NodeHBT{
    Integer value;
    NodeHBT left;
    NodeHBT right;

    public NodeHBT(Integer value) {
        this.value = value;
        this.left=null;
        this.right=null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}



