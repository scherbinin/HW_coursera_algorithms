package week4.bst;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>, V> {
    private Node root;

    public void push(T key, V value) {

    }

    public int delete(T key) {

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
            search(key, currNode.getLeft());
        } else if (bigger(key, currNode.getKey())) {
            search(key, currNode.getRight());
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

        public Node(T key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
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
