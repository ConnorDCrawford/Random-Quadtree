package pkg;

import java.util.Random;

/**
 * Created by connorcrawford on 10/13/15.
 */
public class QuadTree {

    private QNode root;

    public QNode getRoot() {
        return root;
    }

    /*
     * Parameters:  int - The minimum value of the range (inclusive)
     *              int - The maximum value of the range (inclusive)
     * Returns:     int - A random int within the specified range
     */
    private int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /*
     * Parameters:  double - The value to be inserted into the QuadTree
     * Inserts a specified value into a randomly positioned QNode in the QuadTree
     */
    public void insertAtRandomPosition(double v) {
        if (root == null) {
            root = new QNode(v);
            return;
        }
        int POS = randInt(0, 3);
        QNode currentNode = root;
        while (currentNode.getChild(POS) != null) {
            currentNode = currentNode.getChild(POS);
            POS = randInt(0, 3);
        }
        currentNode.setChild(new QNode(v), POS);
    }

    /* Scope:       public - accessed from Main
     * Returns:     double - the sum of all of the values contained within the QuadTree
     * Calls the recursive function to sum all QNodes in QuadTree
     */
    public double sum() {
        return recursiveSum(this.root);
    }

    /*
     * Parameters:  QNode - The current root of a QuadTree
     * Returns:     double - The sum of all QNodes that have been reached thus far
     * Recursively sums all of the numbers in the QuadTree
     */
    private double recursiveSum(QNode root) {
        if (root == null)
            return 0;
        else
            return root.getValue() + recursiveSum(root.getChild(0)) + recursiveSum(root.getChild(1))
                    + recursiveSum(root.getChild(2)) + recursiveSum(root.getChild(3));
    }
}
