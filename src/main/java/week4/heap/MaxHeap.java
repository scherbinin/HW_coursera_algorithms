package week4.heap;

/**
 * Created by scher on 19.08.2019.
 */
public class MaxHeap {
    private final int DEFAULT_SIZE = 5;
    private final int ROOT_INDEX = 1;
    private int[] array;
    private int currentSize;

    public MaxHeap(int count) {
        if (count < 2) {
            array = new int[DEFAULT_SIZE];
        } else {
            array = new int[count];
        }
    }

    public MaxHeap() {
        this(0);
    }

    public void insert(int value) {
        if (currentSize == array.length - 1)
            resizeContainer();

        array[++currentSize] = value;
        swimUp(currentSize);
    }

    public int delete() {
        int deletedVal = array[ROOT_INDEX];
        swap(ROOT_INDEX, currentSize);
        array[currentSize--] = 0;
        sinkDown(ROOT_INDEX);

        return deletedVal;
    }

    public int size() {
        return currentSize;
    }

    private void swimUp(int nodeIndex) {
        //Until we don't archive parent
        while (nodeIndex / 2 > 0) {
            int parent = getParent(nodeIndex);

            if (array[parent] > array[nodeIndex])
                break;

            swap(nodeIndex, parent);
            nodeIndex = parent;
        }
    }

    private void sinkDown(int parentIndex) {
        while (parentIndex * 2 <= currentSize) {
            int biggerChild = getBiggerChild(parentIndex);

            if (array[biggerChild] > array[parentIndex]) {
                swap(biggerChild, parentIndex);
                parentIndex = biggerChild;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int getBiggerChild(int parent) {
        int left = getLeftChild(parent);
        int right = getRightChild(parent);

        if (left > currentSize)
            return right;
        else if (right > currentSize)
            return left;
        else return array[left] > array[right] ? left : right;
    }

    private int getLeftChild(int parent) {
        return parent * 2;
    }

    private int getRightChild(int parent) {
        return parent * 2 + 1;
    }

    private int getParent(int child) {
        return child / 2;
    }

    private void resizeContainer() {
        int[] newArray = new int[array.length * 2];

        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
