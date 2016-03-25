package structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveListTester {

	@Test (timeout = 500)
	public void testHeadTailInsert() {
		RecursiveList<Integer>list = new RecursiveList<Integer>();
		DLNode<Integer> theHead = new DLNode<Integer>(1,null,null); 
		DLNode<Integer> theTail = new DLNode<Integer>(2,null,null);
		list.setHead(theHead);
		assertEquals(list.getHead(),theHead);
		assertEquals(1,(int)list.getFirst());
		list.setTail(theTail);
		assertEquals(theTail,list.getTail());
		assertEquals(2,(int)list.getLast());
		list.insertLast(3);
		assertEquals(3,(int)list.getLast());
		list.insertFirst(1);
		assertEquals(1,(int)list.getFirst());
	}
	
	@Test(timeout = 500)
	public void testCounterHelper(){
		RecursiveList<Integer>list = new RecursiveList<Integer>();
		list.insertLast(2);
		list.insertFirst(1);
		DLNode<Integer> check = list.CountHelper(list.getHead(), 1);
		assertEquals(list.getLast(),check.getData());
	}
	
	@Test (timeout = 500)
	public void testInsertAt(){
		RecursiveList<Integer>list = new RecursiveList<Integer>();
		list.insertLast(2);
		list.insertFirst(1);
		list.insertAt(0, 3);
		assertEquals(3,(int)list.getFirst());
		list.insertAt(list.size()-1, 4);
		assertEquals((int)list.getLast(),4);
	}
	
	@Test (timeout = 500)
	public void testGet(){
		RecursiveList<Integer>list = new RecursiveList<Integer>();
		list.insertLast(2);
		list.insertFirst(1);
		list.insertAt(0, 3);
		assertEquals(3,(int)list.get(0));
		assertEquals(1,(int)list.get(1));
		}
	
}
