import java.util.Iterator;

public class LinkedIntList {
    public ListNode front;  // first value in the list
    public ListNode back;
    private int size;

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
        back = null;
    }



    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
            size = size + 1;
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
                size = size + 1;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
            size = size + 1;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
            size = size + 1;
        }

    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
            size = size - 1;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
            size = size - 1;
        }

    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    public ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }







    public boolean isEmpty() {
        return size == 0;
    }


    public void set( int index, Integer value) {
        ListNode current = nodeAt(index);
        current.data = value;
    }










    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }


    public boolean hasNext() {
        return false;
    }


    public Object next() {
        return null;
    }

    public Iterator  iterator() {
        return  new LinkedIterator();
    }

    private class LinkedIterator implements Iterator {
        private ListNode current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }



        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        @Override
        public Object next() {
            return null;
        }


    }
}
