package challenge;

import java.util.Arrays;
import java.util.List;

public class Day22Question2 {

    public static void main(String[] args) {

        List<Integer> lis3t= Arrays.asList(1,3,2,7,4,null,null,8,null,null,5,9,null,null,6);
        BinarySearchImage binarySearchImage=new BinarySearchImage();
        binarySearchImage.insert(lis3t);
        System.out.println(binarySearchImage);
        int result=binarySearchImage.diameterOfBinaryTree(binarySearchImage.root);
        System.out.println(result);

    }
}
