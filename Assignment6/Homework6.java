// Homework6.java

public class Homework6 {
    private static class TestVisitor implements Visitor<Integer> {
        private SinglyLinkedList<Integer> visitedData = new SinglyLinkedList<Integer>();
        public SinglyLinkedList<Integer> getVisitedData() {
            return visitedData;
        }
        public void visit(Integer data) {
            visitedData.insertTail(data);
        }
    }

    // a
    private static int doCountLeaves(BinaryTree<Integer>.Node node) {
        if (node == null) {
            return 0;
        }
        int counter = 0;
        if (node.isLeaf()) {
            counter++;
        }
        counter += doCountLeaves(node.getLeft());
        counter += doCountLeaves(node.getRight());

        return counter;
    }

    public static int countLeaves(BinaryTree tree) {
        return doCountLeaves(tree.getRoot());
    }

    // b
    public static int countNonLeaves(BinaryTree tree) {
        return (tree.getSize() - countLeaves(tree));
    }

    // c
    private static int doGetHeight(BinaryTree<Integer>.Node node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = doGetHeight(node.getLeft());
        int maxRight = doGetHeight(node.getRight());
        return Math.max(maxLeft, maxRight) + 1;
    }

    public static int getHeight(BinaryTree tree) {
        return doGetHeight(tree.getRoot());
    }

    // d
    public static void printPreOrder(BinaryTree tree) {
        TestVisitor visitor = new TestVisitor();
        TreeAlgorithms.traversePreOrder(tree, visitor);
        while (!visitor.getVisitedData().isEmpty()) {
            System.out.format("%d ", visitor.getVisitedData().removeHead());
        }
        System.out.println();
    }

    // e
    public static void printInOrder(BinaryTree tree) {
        TestVisitor visitor = new TestVisitor();
        TreeAlgorithms.traverseInOrder(tree, visitor);
        while (!visitor.getVisitedData().isEmpty()) {
            System.out.format("%d ", visitor.getVisitedData().removeHead());
        }
        System.out.println();
    }

    // f
    public static void printPostOrder(BinaryTree tree) {
        TestVisitor visitor = new TestVisitor();
        TreeAlgorithms.traversePostOrder(tree, visitor);
        while (!visitor.getVisitedData().isEmpty()) {
            System.out.format("%d ", visitor.getVisitedData().removeHead());
        }
        System.out.println();
    }

    // g
    private static BinaryTree<Integer>.Node doRemoveLeaves(
        BinaryTree<Integer>.Node node) {
        if (node == null) {
            return null;
        }
        if (node.isLeaf()) {
            return null;
        }

        // recursively call func
        node.left = doRemoveLeaves(node.left);
        node.right = doRemoveLeaves(node.right);
        return node;
    }

    // remove all leaf nodes from the tree
    public static void removeLeaves(BinaryTree tree) {
        doRemoveLeaves(tree.getRoot());
    }

    public static void main(String args[]) {
        // make the test trees
        
        // tree1
        BinaryTree<Integer> tree1 = new BinaryTree<Integer>();
        // left branch
        tree1.insertRoot(1);
        tree1.getRoot().insertLeft(2);
        tree1.getRoot().getLeft().insertLeft(4);
        tree1.getRoot().getLeft().getLeft().insertLeft(7);
        // right branch
        tree1.getRoot().insertRight(3);
        tree1.getRoot().getRight().insertLeft(5);
        tree1.getRoot().getRight().insertRight(6);
        tree1.getRoot().getRight().getRight().insertRight(8);
        tree1.getRoot().getRight().getRight().getRight().insertRight(9);

        // tree2
        BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
        tree2 = new BinaryTree<Integer>();
        tree2.insertRoot(6);
        // left branch
        tree2.getRoot().insertLeft(4);
        tree2.getRoot().getLeft().insertLeft(2);
        tree2.getRoot().getLeft().insertRight(5);
        tree2.getRoot().getLeft().getLeft().insertLeft(1);
        tree2.getRoot().getLeft().getLeft().insertRight(3);
        // right branch
        tree2.getRoot().insertRight(8);
        tree2.getRoot().getRight().insertLeft(7);
        tree2.getRoot().getRight().insertRight(9);

        // questions
        // a
        System.out.format("tree1 countLeaves: %d%n", countLeaves(tree1));
        System.out.format("tree2 countLeaves: %d%n", countLeaves(tree2));
        // b
        System.out.format("tree1 countNonLeaves: %d%n", countNonLeaves(tree1));
         System.out.format("tree2 countNonLeaves: %d%n", countNonLeaves(tree2));
        // c
        System.out.format("tree1 getHeight: %d%n", getHeight(tree1));
        System.out.format("tree2 getHeight: %d%n", getHeight(tree2));
        // d
        System.out.print("tree1 PreOrder: ");
        printPreOrder(tree1);
        System.out.print("tree2 PreOrder: ");
        printPreOrder(tree2);
        // e
        System.out.print("tree1 InOrder: ");
        printInOrder(tree1);
        System.out.print("tree2 InOrder: ");
        printInOrder(tree2);
        // f
        System.out.print("tree1 PostOrder: ");
        printPostOrder(tree1);
        System.out.print("tree2 PostOrder: ");
        printPostOrder(tree2);
        // g
        System.out.print("Remove tree1 Leaf Nodes: ");
        removeLeaves(tree1);
        printPreOrder(tree1);
        System.out.print("Remove tree2 Leaf Nodes: ");
        removeLeaves(tree2);
        printPreOrder(tree2);
    }
}
