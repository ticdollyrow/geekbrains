package gb.algorithms.collections.deque;

public class DequeImpl<E> implements Deque<E>{
    protected final E[] data;
    private int size;
    private int head;
    private int tail;

    private final int HEAD_DEFAULT = 1;
    private final int TAIL_DEFAULT = -1;

    public DequeImpl(int maxSize) {
        this.data = (E[])new Object[maxSize];
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
    }
    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if(head == 0){
            head = data.length;
        }

        data[--head] = value;
        size++;
        if(size == 1) tail = head;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;
        if(size == 1) head = tail;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        data[head] = null;
        if(head == data.length - 1) {
            head = 0;
        } else {
            head++;
        }

        size--;
        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        E value = data[tail];
        data[tail] = null;
        if(tail == 0){
            tail = data.length - 1;
        }else{
            tail--;
        }
        size--;
        return value;
    }


    @Override
    public boolean insert(Object value) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int n = data.length;
        int i = 0;
        int beg = head;
        while (i < n){
            sb.append(data[beg]);
            if(beg != tail){
                sb.append(", ");
            }
            if(beg == tail) break;
            beg++;
            if(beg == n) beg = 0;
            i++;
        }

        sb.append("]");
        return sb.toString();
    }

}
