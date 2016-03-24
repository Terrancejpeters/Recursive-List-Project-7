package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class listIterator<T> implements Iterator<T> {
	private DLNode<T> head;

	public listIterator(DLNode<T> in) {
		head = in;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (head != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T rVal = null;
		if (hasNext()) {
			rVal = head.getData();
			head = head.getNext();
		} else {
			throw new NoSuchElementException();
		}
		return rVal;
	}

}
