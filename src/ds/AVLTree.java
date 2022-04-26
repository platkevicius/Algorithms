package ds;

public class AVLTree {

    public static class Node {

        // balance factor
        public int bf;

        public int value;

        public int height;

        public Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    private int nodeCount;

    public int height() {
        if (root == null) return 0;

        return root.height;
    }

    public int size() {
        return nodeCount;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null) return false;

        int cmp = root.value - value;

        if (cmp < 0) return contains(root.right, value);

        if (cmp > 0) return contains(root.left, value);

        return true;
    }

    public boolean insert(int value) {
        if (!contains(root, value)) {
            root = insert(root, value);
            nodeCount++;
            return true;
        }

        return false;
    }

    public Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        int cmp = root.value - value;

        if (cmp < 0) {
            root.right = insert(root.right, value);
        }
        else {
            root.left = insert(root.left, value);
        }

        // update balance factor and height
        update(root);

        // rebalance tree
        return balance(root);
    }

    private void update(Node root) {
        int leftNodeHeight = (root.left == null) ? -1 : root.left.height;
        int rightNodeHeight = (root.right == null) ? -1 : root.right.height;

        root.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        root.bf = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node root) {
        if (root.bf == -2) {

            if (root.left.bf <= 0) {
                return leftLeftCase(root);
            }
            else {
                return leftRightCase(root);
            }
        }
        else if (root.bf == 2) {

            if (root.right.bf >= 0) {
                return rightRightCase(root);
            }
            else {
                return rightLeftCase(root);
            }
        }

        return root;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node rightRotation(Node root) {
        Node child = root.left;
        root.left = child.right;
        child.right = root;
        update(root);
        update(child);
        return child;
    }

    private Node leftRotation(Node root) {
        Node child = root.right;
        root.right = child.left;
        child.left = root;
        update(root);
        update(child);
        return child;
    }

    public boolean remove(int value) {
        if (contains(root, value)) {
            root = remove(root, value);
            nodeCount--;
            return true;
        }

        return false;
    }

    private Node remove(Node root, int value) {
        int cmp = root.value - value;

        if (cmp < 0) {
            root.right = remove(root.right, value);
        } else if (cmp > 0) {
            root.left = remove(root.left, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.left.height > root.right.height) {
                    int suc = findMax(root.left);
                    root.value = suc;

                    root.left = remove(root.left, suc);
                } else {
                    int suc = findMin(root.right);
                    root.value = suc;
                    root.right = remove(root.right, suc);
                }
            }
        }

        update(root);
        return balance(root);
    }

    private int findMin(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    private int findMax(Node node) {
        while (node.right != null) node = node.right;
        return node.value;
    }
}
