package pkg;

import qtvisualizer.QuadTreeNode;

/**
 * Created by connorcrawford on 10/13/15.
 */
public class QNode implements QuadTreeNode {

    private double value;

    private QNode[] children = new QNode[4];

    public QNode(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /*
     * Scope:       public - accessed from QuadTree
     * Parameters:  QNode - The current root of a QuadTree
     *              int - the index at which the child is to be set
     * Sets the root's child at the specified index
     */
    public void setChild(QNode child, int index) {
        if (index < 0 || index > 3)
            return;
        this.children[index] = child;
    }

    /*
     * Scope:       public - Accessed from QuadTree
     * Parameters:  int - The index of the root's desired child
     * Returns:     QNode - The child at the specified index
     */
    public QNode getChild(int index) {
        if (index < 0 || index > 3)
            return null;
        return this.children[index];
    }

    @Override
    public QuadTreeNode[] getChildren() {
        return this.children;
    }
}
