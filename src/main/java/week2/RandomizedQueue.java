package week2;


import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by scher on 04.08.2019.
 * <p>
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure
 */
public class RandomizedQueue<T> {
    private Node<T> root;
    private Node<T> last;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(T item) {
        if(item == null)
            throw new IllegalArgumentException();

        Node newNode = new Node(item, root, null);

        if(isEmpty()) {
            root = newNode;
            last = newNode;
        } else {
            root.setPrev(newNode);
            root = newNode;
        }

        size++;
    }

    // remove and return a random item
    public T dequeue() {
        Node<T> randomNode = selectRandomNode();

        if(randomNode.getPrev() != null) {
            Node<T> prevNode = randomNode.getPrev();
            prevNode.setNext(randomNode.getNext());
        }

        if(randomNode.getNext() != null) {
            Node<T> nextNode = randomNode.getNext();
            nextNode.setPrev(randomNode.getPrev());
        }

        return randomNode.getValue();
    }

    // return a random item (but do not remove it)
    public T sample() {
        return selectRandomNode().getValue();
    }

    private Node<T> selectRandomNode() {
        int index = StdRandom.uniform(size) + 1;
        int curr = 0;
        Node<T> currNode = root;

        while (curr != index) {
            currNode = currNode.getNext();
            curr++;
        }

        return currNode
    }

    // return an independent iterator over items in random order
    public Iterator<T> iterator() {

    }

    private class Iterator<T> implements java.util.Iterator<T> {
        Node node = root;

        public Iterator() {
            //Fill here the whole order of output sequence in simple array int[]
        }

        @Override
        public boolean hasNext() {
            //
        }

        @Override
        public T next() {
            //Get next in initially generated array
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        private Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private T getValue() {
            return value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        private Node<T> getPrev() {
            return prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
