package ds;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(20, null, null, null);

        BinarySearchTree.insert(tree, 15);
        BinarySearchTree.insert(tree, 10);
        BinarySearchTree.insert(tree, 9);
        BinarySearchTree.insert(tree, 12);
        BinarySearchTree.insert(tree, 18);
        BinarySearchTree.insert(tree, 17);
        BinarySearchTree.insert(tree, 19);

        BinarySearchTree.printout(tree);

        System.out.println();
        BinarySearchTree.invert(tree);
        BinarySearchTree.printout(tree);

    }

    private int value;
    private BinarySearchTree parent;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int value, BinarySearchTree left, BinarySearchTree right, BinarySearchTree parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static void insert(BinarySearchTree tree, int value) {
        if (tree.value >= value) {
            if (tree.left == null) {
                tree.left = new BinarySearchTree(value, null, null, tree);
                return;
            }
            insert(tree.left, value);
        }
        else {
            if (tree.right == null) {
                tree.right = new BinarySearchTree(value, null, null, tree);
                return;
            }
            insert(tree.right, value);
        }
    }

    public static void delete(BinarySearchTree tree, int value) {
        BinarySearchTree reference = find(tree, value);

        if (reference == null)
            return;

        boolean right = reference.parent.value < value;

        if (reference.left == null && reference.right == null) {
            if (right) {
                reference.parent.right = null;
            } else {
                reference.parent.left = null;
            }

            return;
        }

        if (reference.right == null) {
            if (right) {
                reference.parent.right = reference.left;
            } else {
                reference.parent.left = reference.left;
            }

            return;
        }

        BinarySearchTree smallest = findSmallest(reference.right);
        reference.value = smallest.value;
        smallest.parent.left = null;
    }

    public static void invert(BinarySearchTree tree) {
        if (tree == null)
            return;

        BinarySearchTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invert(tree.left);
        invert(tree.right);
    }

    private static BinarySearchTree find(BinarySearchTree tree, int value) {
        if (tree == null)
            return null;

        if (tree.value == value)
            return tree;

        if (tree.value >= value)
            return find(tree.left, value);
        else
            return find(tree.right, value);
    }

    private static BinarySearchTree findSmallest(BinarySearchTree tree) {
        if (tree.left == null)
            return tree;

        return findSmallest(tree.left);
    }

    public static void printout(BinarySearchTree tree) {
        if (tree == null) return;

        System.out.println(tree.value);
        printout(tree.left);
        printout(tree.right);
    }
}
