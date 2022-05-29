package challenge;

import java.util.*;
import java.util.Queue;

public class Day20Question1 {

    public static void main(String[] args) {
        //Level Order Traversal
        //insert

        List<Integer> list= Arrays.asList(7,11,1,null,7,2,8,null,null,null,3,null,null,5,null);
        BinaryTree tree=new BinaryTree();
        tree.insert(list);
//        System.out.println(tree);
//        List<Integer> list2=Arrays.asList(6,7,8);
//        tree.insert(list2);
        System.out.println(tree);

//
//        List<Integer> lis3t= Arrays.asList(7,11,1,null,7,2,8,null,null,null,3,null,null,5,null);
//        BinaryTree tree1=new BinaryTree();
//        tree1.insert(lis3t);
//        System.out.println(tree1);

        System.out.println(tree.bfs());

    }
}
class Node1{

    Integer element;
    Node1 left;
    Node1 right;

    public Node1(Integer value) {
        this.left=null;
        this.right=null;
        this.element=value;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "element=" + element +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinaryTree{

    Node1 root;

    public BinaryTree() {
        this.root=null;
    }


    public void insert(List<Integer> list)
    {
        if (list.isEmpty())
        {
            return;
        }
        Integer i=0;
        //condition for the root element
        if(this.root==null)
        {
            if(list.get(0)==null)
            {
                return;
            }
            Node1 node=new Node1(list.get(0));
            this.root=node;
            i++;
            if (i==list.size())
            {
                return;
            }
        }
        //condition for the rest of the element
        Queue<Node1> queue=new LinkedList<>();
        queue.add(this.root);

        while (queue.size()>0)
        {
            Node1 node=queue.remove();
            if(node.left==null)
            {
                if(list.get(i)!=null)
                {
                    Node1 node1=new Node1(list.get(i));
                    node.left=node1;
                }
                i++;
                if(i==list.size())
                    return;
            }
            if(node.left!=null)
            {
                queue.add(node.left);
            }

            //right

            if(node.right==null)
            {
                if(list.get(i)!=null)
                {
                    Node1 node1=new Node1(list.get(i));
                    node.right=node1;
                }
                i++;
                if(i==list.size())
                    return;
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }

    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public List<List<Integer>> bfs(){
        List<List<Integer>> response=new ArrayList<>();
        if(this.root==null)
        {
            return Collections.emptyList();
        }
        Queue<Node1> queue=new LinkedList<>();
        Node1 node=this.root;
        queue.add(node);
        while (!queue.isEmpty())
        {
            int currSize=queue.size();
            List<Integer> height=new ArrayList<>();
            for (int i=0;i<currSize;i++) {
                Node1 current = queue.remove();
                height.add(current.element);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            response.add(height);
        }
        return response;
    }
}
