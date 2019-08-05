package week2;


import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by scher on 04.08.2019.
 * <p>
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure
 */
public class RandomizedQueue<T>  implements Iterable<T> {
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
        T value = randomNode.getValue();
        size--;

        if(randomNode.getPrev() != null) {
            Node<T> prevNode = randomNode.getPrev();
            prevNode.setNext(randomNode.getNext());

            if(randomNode == last)
                last = prevNode;
        }

        if(randomNode.getNext() != null) {
            Node<T> nextNode = randomNode.getNext();
            nextNode.setPrev(randomNode.getPrev());

            if(randomNode == root)
                root = nextNode;
        }

        if (isEmpty()) {
            root = null;
            last = null;
        }

        return value;
    }

    // return a random item (but do not remove it)
    public T sample() {
        if(isEmpty())
            throw new NoSuchElementException();

        return selectRandomNode().getValue();
    }

    private Node<T> selectRandomNode() {
        int index = StdRandom.uniform(size);
        int curr = 0;
        Node<T> currNode = root;

        while (curr != index) {
            currNode = currNode.getNext();
            curr++;
        }

        return currNode;
    }

    // return an independent iterator over items in random order
    public Iterator<T> iterator() {
        return new Iterator<>();
    }

    private class Iterator<T> implements java.util.Iterator<T> {
        private Node[] nodes;
        private int index;

        public Iterator() {
            Node node = root;
            nodes = new Node[size()];

            for (int i =0; i < size(); i++) {
                nodes[i] = node;
                node = node.getNext();
            }

            StdRandom.shuffle(nodes);
        }

        @Override
        public boolean hasNext() {
            return index != size() -1;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            T value = (T) nodes[index].getValue();
            index++;

            return value;
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
