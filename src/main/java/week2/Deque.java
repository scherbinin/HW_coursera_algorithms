package week2;

import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node root;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node newNode = new Node(item, root, null);

        if (isEmpty()) {
            root = newNode;
            last = newNode;
        } else {
            root.setPrev(newNode);
            root = newNode;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node newLast = new Node(item, null, last);

        if (isEmpty()) {
            root = newLast;
            last = newLast;
        }

        last.setNext(newLast);
        last = newLast;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item value = root.getValue();
        root = root.getNext();

        if (root != null)
            root.setPrev(null);

        size--;

        return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item value = last.getValue();
        last = last.getPrev();

        if (last != null)
            last.setNext(null);

        size--;

        return value;
    }

    // return an iterator over items in order from front to back
    public java.util.Iterator<Item> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<Item> {
        Node node = root;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            if (node == null)
                throw new NoSuchElementException();

            Item value = node.getValue();
            node = node.getNext();

            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        Item value;
        Node next;
        Node prev;

        private Node(Item value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private Item getValue() {
            return value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Node getPrev() {
            return prev;
        }

        private void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }
}