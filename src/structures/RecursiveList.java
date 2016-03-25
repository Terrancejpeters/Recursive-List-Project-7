package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
	private DLNode<T> head;
	private DLNode<T> tail;
	private int size;

	public RecursiveList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// TODO Auto-generated method stub

		setHead(new DLNode<T>(elem, head, null));
		if (getHead().getNext() == null) // this is the only element
			setTail(getHead());
		else
			getHead().getNext().setPrev(getHead());
		size++;
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		// TODO Auto-generated method stub

		setTail(new DLNode<T>(elem, null, tail));
		if (getTail().getPrev() == null) {
			setHead(getTail());
		} else {
			getTail().getPrev().setNext(getTail());
		}
		size++;
		return this;

	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			insertFirst(elem);
			return this;
		}
		if (index == (size - 1)) {
			insertLast(elem);
			return this;
		}
		DLNode<T> tempPrev = CountHelper(head, index);
		DLNode<T> tempNext = tempPrev.getNext();
		DLNode<T> toInsert = new DLNode<T>(elem, tempNext, tempPrev);
		tempNext.setPrev(toInsert);
		tempPrev.setNext(toInsert);
		return this;
	}

	@Override
	public T removeFirst() throws IllegalStateException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new IllegalStateException();
		T data = head.getData();
		if (head.getNext() != null)
			head.getNext().setPrev(null);
		else
			tail = null;
		head = head.getNext();
		size--;
		return data;
	}

	@Override
	public T removeLast() throws IllegalStateException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new IllegalStateException();
		T data = tail.getData();
		if (tail.getPrev() != null)
			tail.getPrev().setNext(null);
		else
			head = null;
		tail = tail.getPrev();
		size--;
		return data;
	}

	@Override
	public T removeAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return head.getData();
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return tail.getData();
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		DLNode<T> temp = CountHelper(head,i);
		return temp.getData();
	}

	@Override
	public boolean remove(T elem) throws NullPointerException {
		// TODO Auto-generated method stub
		if (elem == null)
			throw new NullPointerException();
		int index = indexHelper(elem,head,0);
		if (index == -1){
			return false;
		}
		DLNode<T> temp = CountHelper(head,index);
		DLNode<T> tempPrev = temp.getPrev();
		DLNode<T> tempNext = temp.getNext();
		tempNext.setPrev(tempPrev);
		tempPrev.setNext(tempNext);
		// remove by setting next and prev nodes appropriate pointers
		return true;
	}

	@Override
	public int indexOf(T elem) {
		// TODO Auto-generated method stub
		// binary tree search,
		return indexHelper(elem, head, 0);
	}

	// used for finding the index of an element
	public int indexHelper(T elem, DLNode<T> current, int count) {
		DLNode<T> temp = current;
		if (current.getData() == elem) {
			return count;
		}
		if (count >= size) {
			return -1;
		}
		if (temp.getNext() != null)
			temp = temp.getNext();
		return indexHelper(elem, temp, count + 1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	public DLNode<T> getHead() {
		return head;
	}

	public DLNode<T> getTail() {
		return tail;
	}

	public void setHead(DLNode<T> node) {
		head = node;
	}

	public void setTail(DLNode<T> node) {
		tail = node;
	}

	// used for getting node at an index
	public DLNode<T> CountHelper(DLNode<T> current, int countdown) {
		if (countdown == 0) {
			return current;
		}
		return CountHelper(current.getNext(), countdown - 1);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new listIterator<T>(head);
	}
}
