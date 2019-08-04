package week2;

import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {
    private Node<T> root;
    private Node<T> last;
    private int size;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(T item) {
        if(item == null)
            throw new IllegalArgumentException();

        Node newNode = new Node(item, root, null);

        if(isEmpty()) {
            root = newNode;
            last = newNode;
        }

        root.setPrev(newNode);
        root = newNode;

        size++;
    }

    // add the item to the back
    public void addLast(T item) {
        if(item == null)
            throw new IllegalArgumentException();

        Node newLast = new Node<>(item, null, last);

        if (isEmpty()) {
            root = newLast;
            last = newLast;
        }

        last.setNext(newLast);
        last = newLast;
        size++;
    }

    // remove and return the item from the front
    public T removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        T value = root.getValue();
        root = root.getNext();

        if(root != null)
            root.setPrev(null);

        size--;

        return value;
    }

    // remove and return the item from the back
    public T removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        T value = last.getValue();
        last = last.getPrev();

        if(last != null)
            last.setNext(null);

        size--;

        return value;
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        return new Iterator<T>();
    }

    private class Iterator<T> implements java.util.Iterator<T> {
        Node node = root;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            T value = (T)node.getValue();
            node = node.getNext();

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