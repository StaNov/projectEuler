/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem18_triangelOfNums;

/**
 *
 * @author Novák Stanislav
 */
public class Node {

    private int index;
    private int value;
    private Node right;
    private Node left;

    public Node(int index, int value) {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

}
