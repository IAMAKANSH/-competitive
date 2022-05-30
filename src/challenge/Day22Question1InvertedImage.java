package challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day22Question1InvertedImage {

    public static void main(String[] args) {
        List<Integer> lis3t= Arrays.asList(1,2,3,4,null,null,5,6,null);
        BinarySearchImage binarySearchImage=new BinarySearchImage();
        binarySearchImage.insert(lis3t);
        System.out.println(binarySearchImage);
//        binarySearchImage.getTreeMirrorImage();
//        System.out.println(binarySearchImage);

        binarySearchImage.getTreeMirrorImageRecursively(binarySearchImage.root);
        System.out.println(binarySearchImage);
    }
}
class NodeImg{

    Integer element;
    NodeImg right;
    NodeImg left;

    public NodeImg(Integer element) {
        this.element = element;
        this.right =null;
        this.left =null;
    }

    @Override
    public String toString() {
        return "NodeImg{" +
                "element=" + element +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}
class BinarySearchImage{

     NodeImg root;

    public BinarySearchImage() {
        this.root=null;
    }
    //BFS
    public void insert(List<Integer> elements)
    {

        if(elements.isEmpty())
            return;
        //first element and even iteration over elements
        int i=0;
        //condition for root node
        if(this.root==null)
        {
            if(elements.get(i)==null)
            {
                return;
            }
            NodeImg node=new NodeImg(elements.get(0));
            this.root=node;
            i++;
            if(i==elements.size())
                return;
        }
        //condition for the rest of the element
        Queue<NodeImg> queue=new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty())
        {
            NodeImg currentNode=queue.remove();
            if(currentNode.left==null)
            {
                if (elements.get(i)!=null)
                {
                    NodeImg node=new NodeImg(elements.get(i)) ;
                    currentNode.left=node;
                }
                i++;
                if(i==elements.size())
                    return;
            }
            if(currentNode.left!=null)
            {
                queue.add(currentNode.left);
            }
            if(currentNode.right==null)
            {
                if (elements.get(i)!=null)
                {
                    NodeImg node=new NodeImg(elements.get(i)) ;
                    currentNode.right=node;
                }
                i++;
                if(i==elements.size())
                    return;
            }
            if(currentNode.right!=null)
            {
                queue.add(currentNode.right);
            }
        }

    }
    /**
     *      1
     *    2   3
     *   4 5  6 7
     */
    public void getTreeMirrorImage()
    {
        if (this.root==null)
        {
            return;
        }
        Queue<NodeImg> queue=new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty())
        {

            NodeImg currentNode=queue.remove();
            NodeImg left=currentNode.left;
            NodeImg right=currentNode.right;
            currentNode.right=left;
            currentNode.left=right;
            if (currentNode.left!=null)
            {
                queue.add(currentNode.left);
            }
            if (currentNode.right!=null)
            {
                queue.add(currentNode.right);
            }
        }
    }

    public void getTreeMirrorImageRecursively(NodeImg node)
    {
        if(node==null) {
            return;
        }
        NodeImg temp=node.left;
        node.left=node.right;
        node.right=temp;

        getTreeMirrorImageRecursively(node.left);
        getTreeMirrorImageRecursively(node.right);
        return;
    }


    @Override
    public String toString() {
        return "BinarySearchImage{" +
                "root=" + root +
                '}';
    }
}
