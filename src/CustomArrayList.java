import java.util.*;

public class CustomArrayList<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTS = {};
    private int size;
    private Object[] elements;

    public CustomArrayList() {
        elements = EMPTY_ELEMENTS;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        }
        if(initialCapacity == 0) {
            elements = EMPTY_ELEMENTS;
        }
    }

    public CustomArrayList(Collection<? extends E> collection) {
        addAll(collection);
    }

    public void add(E element) {
        if(size == elements.length) {
            grow(size + 1);
        }
        elements[size] = element;
        size++;
    }

    public void add(E element, int index) {
        checkIndex(index, size);
        if(size == elements.length) {
            grow(size + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        final int addCount = array.length;
        if(addCount == 0) {
            return false;
        }
        if (size + addCount > elements.length) {
            grow(addCount + size);
        }
        System.arraycopy(array, 0, elements, size, addCount);
        size += addCount;
        return true;
    }

    public E get(int index) {
        checkIndex(index, size - 1);
        return (E) elements[index];
    }

    public E remove(int index) {
        checkIndex(index, size - 1);
        E element = (E) elements[index];
        if (index < size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    public static <T extends Comparable<T>> void sort(CustomArrayList<T> collection) {
        boolean isSorted = false;
        int last = collection.size;
        Object[] elements = collection.elements;
        while(!isSorted) {
            isSorted = true;
            last--;
            for (int i = 0; i < last; i++) {
                if (((T) elements[i]).compareTo((T) elements[i + 1]) > 0) {
                    Object greater = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = greater;
                    isSorted = false;
                }
            }
        }
    }

    public void sort() {
        boolean isSorted = false;
        int last = size;
        while(!isSorted) {
            isSorted = true;
            last--;
            for (int i = 0; i < last; i++) {
                if (((E) elements[i]).compareTo((E) elements[i + 1]) > 0) {
                    Object greater = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = greater;
                    isSorted = false;
                }
            }
        }
    }

    private void grow(int minNewCapacity) {
        if (elements.length == 0) {
            elements = new Object[Math.max(DEFAULT_CAPACITY, minNewCapacity)];
        }
        else {
            int newCapacity = (int) (size * 1.5);
            elements = Arrays.copyOf(elements, Math.max(newCapacity, minNewCapacity));
        }
    }
    private void checkIndex(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int s = 0; s < size; s++) {
            sb.append(elements[s].toString()).append("\n");
        }
        sb.append("size = " ).append(size).append("\n");
        return sb.toString();
    }
}
