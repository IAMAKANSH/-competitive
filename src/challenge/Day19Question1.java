package challenge;

import java.util.Scanner;

public class Day19Question1 {

    public static void main(String[] args) {

        //Binary Search Tree
        //insert
        //remove
        //fina a value
        Scanner sc=new Scanner(System.in);
        BinarySearchTree tree=new BinarySearchTree();
        while (true)
        {
            System.out.println("Enter 1-insert 2-remove 3-find 4-exit");
            int res=sc.nextInt();

            if(res==1)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                tree.insert(ele);
            }
            else if(res==3)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                NodeTree response=tree.find(ele);
                System.out.println(response);
            }
            else
            {
                break;
            }
        }
        System.out.println(tree);
    }

}
class NodeTree
{
    public Integer value;
    public NodeTree left;
    public NodeTree right;

    public NodeTree(Integer value) {
        this.value=value;
        this.left=null;
        this.right=null;
    }

    @Override
    public String toString() {
        return "NodeTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinarySearchTree
{
    public NodeTree root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Integer value)
    {
        NodeTree node=new NodeTree(value);
        if(this.root==null)
        {
            this.root=node;
            return;
        }
        else {
            NodeTree temp = this.root;
            while (true)
            {
                if(temp.value>value)
                {
                    if(temp.left==null)
                    {
                        temp.left=node;
                        return;
                    }
                    temp=temp.left;
                }
                else
                {
                    if(temp.right==null)
                    {
                        temp.right=node;
                        return;
                    }
                    temp=temp.right;
                }
            }
        }
    }
    public NodeTree find(Integer value)
    {
        if(this.root==null)
        {
            return null;
        }
        NodeTree tree=this.root;
        while(tree!=null)
        {
            if(tree.value==value)
            {
                return tree;
            }
            else if(tree.value>value)
            {
                tree=tree.left;
            }
            else
            {
                tree=tree.right;
            }
        }
        return null;
    }

    public void remove(Integer value,NodeTree currentNode,NodeTree parentNode)
    {
        //if we have leaf
        //if we have node with 1 child
        //if we have node with 2 child
        if(this.root==null)
        {
            return;
        }
        else
        {

            while (currentNode!=null)
            {
                if (value<currentNode.value)
                {
                    parentNode=currentNode;
                    currentNode=currentNode.left;
                }
                else if(value>currentNode.value)
                {
                    parentNode=currentNode;
                    currentNode=currentNode.right;
                }
                else
                {
                    //found the node to be deleted
                    //node to be deleted has two children
                    if(currentNode.left!=null && currentNode.right!=null)
                    {
                        currentNode.value=getMinSubTree(currentNode.right);
                        remove(currentNode.value,currentNode.right,currentNode);
                    }
                    //deleting the root node
                    else if(parentNode==null)
                    {
                        if(currentNode.left!=null)
                        {
                            currentNode.value=currentNode.left.value;
                            currentNode.left=currentNode.left.left;
                            currentNode.right=currentNode.left.right;
                        }
                        else if(currentNode.right!=null)
                        {
                            currentNode.value=currentNode.right.value;
                            currentNode.left=currentNode.right.left;
                            currentNode.right=currentNode.right.right;
                        }
                        else
                        {
                            this.root=null;
                        }
                    }

                    //either 0 or 1
                    else if(currentNode==parentNode.left)
                    {
                            parentNode.left=currentNode.left!=null? currentNode.left:currentNode.right;
                    }
                    else if(currentNode==parentNode.right)
                    {
                        parentNode.right=currentNode.left!=null? currentNode.left:currentNode.right;
                    }
                    //break out of while loop
                    break;
                }
            }
        }

    }
    public Integer getMinSubTree(NodeTree node)
    {
        while (node.left!=null)
        {
            node=node.left;
        }
        return node.value;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
