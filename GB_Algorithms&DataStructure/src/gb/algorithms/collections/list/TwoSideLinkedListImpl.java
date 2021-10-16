package gb.algorithms.collections.list;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, first, null);

        if(!isEmpty()) {
            first.prev = newNode;
        }
        first = newNode;

        size++;
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, last);

        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if(first.prev != null) {
            first.prev = null;
        }
        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    public E removeLast(){
        Node<E> removedValue = last;
        last = last.prev;
        removedValue.prev = null;
        last.next = null;
        size--;
        return removedValue.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        } else if(current == last) {
            last = prev;
            last.next = null;
        }
        prev.next = current.next;
        current.next.prev = current.prev;

        current.next = null;
        current.prev = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }
}

