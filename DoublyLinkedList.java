import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		// TODO 
    	Node newNode = new Node(item);
   		if (isEmpty()) {
        	head = newNode;
        	tail = newNode;
    	} else {
        	tail.next = newNode;
        	newNode.prev = tail;
        	tail = newNode;
    	}
    	numberOfElements++;
	}

	@Override
	public void addFirst(T item) {
		// TODO 
    	Node newNode = new Node(item);
    	if (isEmpty()) {
        	head = newNode;
        	tail = newNode;
    	} else {
        	newNode.next = head;
        	head.prev = newNode;
        	head = newNode;
    	}
    	numberOfElements++;
	}

	@Override
	public T get(int position) {
		// TODO 
	    if (position < 0 || position >= numberOfElements) {
        	return null;
    	}
    	Node current = head;
    	int index = 0;
    	while (index < position) {
        	current = current.next;
        	index++;
   		}
    	return current.data;
	}

	@Override
	public void print() {
		// TODO
    	Node current = head;
    	while (current != null) {
        	System.out.print(current.data + " ");
        	current = current.next;
    	}
    	System.out.println();
	}

	@Override
	public void printBackwards() {
		// TODO 
		Node current = tail;
    	while (current != null) {
        	System.out.print(current.data + " ");
        	current = current.prev;
    	}
    	System.out.println();
	}

	@Override
	public boolean remove(T item) {
		// TODO 
    	if (isEmpty()) {
        	return false;
    	}
   		Node current = head;
    	while (current != null) {
        	if ((current.data == null && item == null) ||(current.data != null && current.data.equals(item))) {
            	if (head == tail) {
                	head = null;
                	tail = null;
            	}
            	else if (current == head) {
                	head = head.next;
                	head.prev = null;
           		}
            	else if (current == tail) {
                	tail = tail.prev;
                	tail.next = null;
            	}
            	else {
                	current.next.prev = current.prev;
					current.prev.next = current.next;
            	}
            	numberOfElements--;
            	return true;
        	}
        	current = current.next;
    	}
    	return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return numberOfElements == 0; 
	}

	@Override
	public int getLength() {
		// TODO 
		return numberOfElements;
	}
	
	/** 
	 * Inner class representing a node in the linked list
	 */
	public Iterator<T> iterator() {
    	return new DLLIterator();
	}
	private class DLLIterator implements Iterator<T> {
    	private Node current = head;
    	public boolean hasNext() {
        	return current != null;
    	}
    	public T next() {
        	T item = current.data;
        	current = current.next;
        	return item;
    	}
	}

	private class Node
	{
		public DoublyLinkedList<T>.Node prev;
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}
}

