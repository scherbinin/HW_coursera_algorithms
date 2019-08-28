package week4.bst;

import java.util.ArrayDeque;
import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>, V> {
    private Node root;

    public void inorderTraversal() {
        ArrayDeque<Node> queue = new ArrayDeque<>();

        travers(root, queue);

        for (Node node : queue) {
            System.out.println(node.getKey());
        }
    }

    private void travers(Node node, ArrayDeque<Node> queue) {
        if(node.getLeft() != null)
            travers(node.getLeft(), queue);
        if(node.getRight() != null)
            travers(node.getRight(), queue);

        queue.add(node);
    }

    public void push(T key, V value) {
        if (Objects.isNull(root)) {
            root = new Node(key, value);
            return;
        }

        Node curr = root;
        Node parent = root;

        while (Objects.nonNull(curr)) {
            parent = curr;

            if (less(key, curr.getKey())) {
                curr = curr.getLeft();
            } else if (bigger(key, curr.getKey())) {
                curr = curr.getRight();
            } else /* They are equals */ {
                curr.setValue(value);
                return;
            }
        }

        if(less(key, parent.getKey())) {
            parent.setLeft(new Node(key, value));
        }
        if (bigger(key, parent.getKey())) {
            parent.setRight(new Node(key, value));
        }

    }

    public int delete(T key) {
        Node curr = root;
        Node parent = root;

        while (Objects.nonNull(curr)) {
            parent = curr;

            if (less(key, curr.getKey())) {
                curr = curr.getLeft();
            } else if (bigger(key, curr.getKey())) {
                curr = curr.getRight();
            } else /* They are equals */ {
//                if(Objects.isNull(curr.getLeft()) && Objects.isNull(curr.getRight()))
            }
        }

        if (Objects.isNull(curr))
            throw new IllegalArgumentException("The key doesn't exist");

        // delete algorithm if there is no children - Just delete it and put null link from parent
        if(Objects.isNull(curr.getLeft()) && Objects.isNull(curr.getRight())) {

        } else // If it has only 1 child - Just delete it, put in parent's link the on child of current
        if(Objects.isNull(curr.getLeft()) || Objects.isNull(curr.getRight())) {

        } else { //It has 2 children
            // Find next max for current: go 1 step to right and all rest way go to left until approach leave,
            // replace the curr node by that leave, delete that leave
        }


        return 0;//return deleted key
    }

    public V getValue(T key) {
        Node node = search(key, root);

        if (Objects.isNull(node))
            return null;

        return node.getValue();
    }

    public boolean contains(T key) {
        return search(key, root) != null;
    }

    private Node search(T key, Node currNode) {
        if (Objects.isNull(currNode))
            return null;

        if (less(key, currNode.getKey())) {
            currNode = search(key, currNode.getLeft());
        } else if (bigger(key, currNode.getKey())) {
            currNode = search(key, currNode.getRight());
        }

        return currNode;// They should be equal
    }

    private boolean less(T key1, T key2) {
        return key1.compareTo(key2) < 0;
    }

    private boolean bigger(T key1, T key2) {
        return key1.compareTo(key2) > 0;
    }

    private class Node {
        private T key;
        private V value;
        private Node left;
        private Node right;

        public Node(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void push(int key, String value) {

        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
