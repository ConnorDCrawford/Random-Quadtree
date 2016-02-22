package pkg;

import qtvisualizer.QuadTreeViz;

/**
 * Created by connorcrawford on 10/13/15.
 */
public class Main {

    public Main() {
        QuadTree quadTree = new QuadTree();
        for (int i = 1; i <= 100; i++ ) {
            quadTree.insertAtRandomPosition(i);
        }
        QuadTreeViz quadTreeViz = new QuadTreeViz(quadTree.getRoot());
        System.out.println("Sum of nodes: " + quadTree.sum());
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
