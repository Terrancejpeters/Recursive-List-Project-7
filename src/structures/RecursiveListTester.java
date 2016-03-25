package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursiveListTester {
	private RecursiveList<Integer> list;

	@Before
	public void prep() {
		list = new RecursiveList<Integer>();
	}

	@Test(timeout = 500)
	public void testHeadTailInsert() {
		RecursiveList<Integer> list = new RecursiveList<Integer>();
		DLNode<Integer> theHead = new DLNode<Integer>(1, null, null);
		DLNode<Integer> theTail = new DLNode<Integer>(2, null, null);
		list.setHead(theHead);
		assertEquals(list.getHead(), theHead);
		assertEquals(1, (int) list.getFirst());
		list.setTail(theTail);
		assertEquals(theTail, list.getTail());
		assertEquals(2, (int) list.getLast());
		list.insertLast(3);
		assertEquals(3, (int) list.getLast());
		list.insertFirst(1);
		assertEquals(1, (int) list.getFirst());
	}

	@Test(timeout = 500)
	public void testCounterHelper() {
		RecursiveList<Integer> list = new RecursiveList<Integer>();
		list.insertLast(2);
		list.insertFirst(1);
		DLNode<Integer> check = list.CountHelper(list.getHead(), 1);
		assertEquals(list.getLast(), check.getData());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAt() {
		list.insertAt(4, 1);
		list.insertLast(2);
		list.insertFirst(1);
		list.insertAt(0, 3);
		assertEquals(3, (int) list.getFirst());
		list.insertAt(list.size(), 4);
		assertEquals((int) list.getLast(), 4);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet() throws IndexOutOfBoundsException {
		list.get(123);
		RecursiveList<Integer> list = new RecursiveList<Integer>();
		list.insertLast(2);
		list.insertFirst(1);
		list.insertAt(0, 3);
		assertEquals(3, (int) list.get(0));
		assertEquals(1, (int) list.get(1));
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveFirst() throws IllegalStateException {
		list.removeFirst();
		list.insertFirst(1);
		assertEquals(1, (int) list.removeFirst());
		list.insertLast(2);
		assertEquals(2, (int) list.removeFirst());
		assertEquals(0, list.size());
		list.insertFirst(3);
		list.insertFirst(2);
		list.insertAt(0, 1);
		assertEquals(1, (int) list.removeFirst());
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveLast() throws IllegalStateException {
		list.removeLast();
		list.insertLast(1);
		assertEquals(1, (int) list.removeLast());
		list.insertFirst(2);
		assertEquals(2, (int) list.removeLast());
		assertEquals(0, list.size());
		list.insertFirst(3);
		list.insertLast(4);
		list.insertAt(list.size(), 5);
		assertEquals(5, (int) list.removeLast());

	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveAt() throws IllegalStateException {
		list.removeAt(23);
		list.insertFirst(1);
		assertEquals(1, (int) list.removeAt(0));
		assertEquals(0, list.size());
		list.insertFirst(2);
		assertEquals(2, (int) list.removeAt(list.size() - 1));
		list.insertFirst(1);
		list.insertLast(3);
		list.insertAt(1, 2);
		assertEquals(2, (int) list.removeAt(1));
		list.insertLast(4);
		list.insertLast(5);
		assertEquals(4, (int) list.removeAt(2));

	}

	@Test(expected = NullPointerException.class)
	public void testRemove() throws NullPointerException {
		list.remove(3424);
		list.insertFirst(1);
		list.remove(1);
		assertTrue(list.isEmpty());
		list.insertFirst(1);
		list.insertLast(2);
		list.insertLast(3);
		list.remove(1);
		assertEquals(2, (int) list.getFirst());
		list.insertFirst(1);
		list.insertFirst(1);
		assertTrue(list.remove(3));
		list.remove(1);
		assertEquals(1, (int) list.getFirst());
		list.remove(1);
		assertEquals(2, (int) list.getFirst());

	}

	@Test(timeout = 500)
	public void testIndexOf() {
		list.insertFirst(1);
		assertEquals(0, list.indexOf(1));
		list.insertLast(2);
		assertEquals(1, list.indexOf(2));
		list.insertAt(1, 3);
		assertEquals(1, list.indexOf(3));
		assertEquals(2, list.indexOf(2));
	}
}
