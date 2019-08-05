package week2;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by scher on 04.08.2019.
 * <p>
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> root;
    private Node<Item> last;
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
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node<Item> newNode = new Node<>(item, root, null);

        if (isEmpty()) {
            root = newNode;
            last = newNode;
        } else {
            root.setPrev(newNode);
            root = newNode;
        }

        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<Item> randomNode = selectRandomNode();
        Item value = randomNode.getValue();
        size--;

        if (randomNode.getPrev() != null) {
            Node<Item> prevNode = randomNode.getPrev();
            prevNode.setNext(randomNode.getNext());

            if (randomNode == last)
                last = prevNode;
        }

        if (randomNode.getNext() != null) {
            Node<Item> nextNode = randomNode.getNext();
            nextNode.setPrev(randomNode.getPrev());

            if (randomNode == root)
                root = nextNode;
        }

        if (isEmpty()) {
            root = null;
            last = null;
        }

        return value;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        return selectRandomNode().getValue();
    }

    private Node<Item> selectRandomNode() {
        int index = StdRandom.uniform(size);
        int curr = 0;
        Node<Item> currNode = root;

        while (curr != index) {
            currNode = currNode.getNext();
            curr++;
        }

        return currNode;
    }

    // return an independent iterator over items in random order
    public java.util.Iterator<Item> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<Item> {
        private Node<Item>[] nodes;
        private int index;

        Iterator() {
            Node<Item> node = root;
            nodes = new Node[size()];

            for (int i = 0; i < size(); i++) {
                nodes[i] = node;
                node = node.getNext();
            }

            StdRandom.shuffle(nodes);
        }

        @Override
        public boolean hasNext() {
            return index != size();
        }

        @Override
        public Item next() {
            if (index >= size())
                throw new NoSuchElementException();

            Item value = nodes[index].getValue();
            index++;

            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        Item value;
        Node<Item> next;
        Node<Item> prev;

        private Node(Item value, Node<Item> next, Node<Item> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private Item getValue() {
            return value;
        }

        private Node<Item> getNext() {
            return next;
        }

        private void setNext(Node<Item> next) {
            this.next = next;
        }

        private Node<Item> getPrev() {
            return prev;
        }

        private void setPrev(Node<Item> prev) {
            this.prev = prev;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }
}
