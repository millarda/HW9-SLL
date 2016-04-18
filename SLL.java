
/***************************************************************************************
*
* NAME: Andrew Millard
*
* HOMEWORK: 4
*
* CLASS: ICS 211
*
* INSTRUCTOR: Scott Robertson
*
* DATE: February 21, 2016
*
* FILE: SLL.java
*
* DESCRIPTION: Single Linked List Class for Homework 4 
*
***************************************************************************************/
import java.util.*;

public class SLL<E extends Comparable<E>>{
	private SLLNode<E> head;
	private int size;

	/********************************************************************
	 *
	 * Method: SLL
	 *
	 * Description: A constructor that initializes member variables head and
	 * size
	 * 
	 *
	 * @param None
	 *
	 * @return None
	 *
	 ********************************************************************/
	public SLL() {
		head = new SLLNode<E>(null);
		size = 0;
	}

	public void InsertionSort() {
		if (size() > 1) {
			boolean sorting = true;
			while (sorting) {
				SLLNode<E> focus = head.getNext().getNext();
				SLLNode<E> focus2;// = focus.getNext();
				sorting = false;
				while (focus != null) {
					focus2 = focus.getNext();
					//while focus < focus.pre
					while (!focus.equals(head.getNext())&&((focus.getData()).compareTo( Previous(focus).getData()) < 0)) {
						swapNext(Previous(focus));
						sorting = true;
					}
					focus = focus2;
				}
			}
		}
	}
	
	private SLLNode<E> Previous(SLLNode<E> node){
		SLLNode<E> token = head;
		//have token be the node before node
		while(!token.getNext().equals(node)){
			token = token.getNext();
		}
		return token;
	}
	public void BubbleSort() {
		boolean sorting = true;
		
		for (int i = 0; i < size(); i++) {
			SLLNode<E> focus = head.getNext();
			sorting = true;
			while (sorting) {
				sorting = false;
				while (focus.getNext() != null) {
					// If focus.getNext is less than focus
					if ((focus.getNext().getData()).compareTo(focus.getData()) < 0) {
						sorting = true;
						swapNext(focus);
					}else{
						focus = focus.getNext();
					}
				}
			}
		}
	}

	private void swapNext(SLLNode<E> node){
		SLLNode<E> token = head;
		//have token be the node before node
		while(!token.getNext().equals(node)){
			token = token.getNext();
		}
		token.setNext(node.getNext());
		node.setNext(token.getNext().getNext());
		token.getNext().setNext(node);
	}


	/********************************************************************
	 *
	 * Method: add
	 *
	 * Description: Adds an element to the end of the list. increments size.
	 * MODIFIED to void
	 *
	 * @param element:
	 *            the element to be added to the end of the list
	 *
	 * @return none;
	 *
	 ********************************************************************/
	public void add(E element) {
		SLLNode<E> token = head;
		SLLNode<E> token2 = new SLLNode<E>(element);

		while (token.getNext() != null) {
			token = token.getNext();
		}
		token.setNext(token2);
		size++;
		

	}

	/********************************************************************
	 *
	 * Method: add
	 *
	 * Description: Adds the element to the given index. Overrides the previous
	 * add method. increments size
	 * 
	 *
	 * @param index:
	 *            the index of where to add the element element: the element to
	 *            be added to the list
	 *
	 * @return true if added sucessfully, false otherwise
	 *
	 ********************************************************************/
	public boolean add(int index, E element) {
		try {
			SLLNode<E> token = head.getNext();
			for (int i = 0; i < index; i++) {
				token = token.getNext();
			}
			SLLNode<E> token2 = new SLLNode<E>(token.getData());
			token2.setNext(token.getNext());
			token.setNext(token2);
			token.setData(element);
			size++;
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/********************************************************************
	 *
	 * Method: clear
	 *
	 * Description: Clears all elements in the list, resets the list
	 * 
	 *
	 * @param none
	 *
	 * @return none
	 *
	 ********************************************************************/
	public void clear() {
		head = new SLLNode<E>(null);
		size = 0;
	}

	/********************************************************************
	 *
	 * Method: contains
	 *
	 * Description: Returns true if the list contains the given element. Returns
	 * false otherwise.
	 * 
	 *
	 * @param element:
	 *            the element to be searched for
	 *
	 * @return true if it contains the given element, false otherwise
	 *
	 ********************************************************************/
	public boolean contains(E element) {
		SLLNode<E> token = head;
		while (token.getNext() != null) {
			token = token.getNext();
			if (token.getData().equals(element)) {
				return true;
			}
		}
		return false;
	}

	/********************************************************************
	 *
	 * Method: get
	 *
	 * Description: Returns the element at the given index. Returns null if the
	 * index is out of bounds
	 * 
	 *
	 * @param index:
	 *            the index of which's value to return
	 *
	 * @return none
	 *
	 ********************************************************************/
	public E get(int index) {
		SLLNode<E> token = head;
		try {
			for (int i = 0; i - 1 < index; i++) {
				token = token.getNext();
			}
			return token.getData();
		} catch (NullPointerException e) {
			return null;
		}
	}

	/********************************************************************
	 *
	 * Method: indexOf
	 *
	 * Description: Returns the index of the first occurrence of the element or
	 * -1 if the element does not exist.
	 * 
	 *
	 * @param element:
	 *            the index
	 *
	 * @return first occurrence of the element, if no element exists then return
	 *         false;
	 *
	 ********************************************************************/
	public int indexOf(E element) {
		SLLNode<E> token = head;
		for (int i = 0; token.getNext() != null; i++) {
			token = token.getNext();
			if (token.getData().equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/********************************************************************
	 *
	 * Method: isEmpty
	 *
	 * Description: Returns true if the list is empty or false if the list is
	 * not empty.
	 * 
	 *
	 * @param none
	 *
	 * @return true if the list is empty or false if the list is not empty
	 *
	 ********************************************************************/
	public boolean isEmpty() {
		if (head.getNext() == null) {
			return true;
		} else {
			return false;
		}
	}

	/********************************************************************
	 *
	 * Method: lastIndexOf
	 *
	 * Description: Returns the index of the last occurrence of the element or
	 * -1 if the element does not exist.
	 * 
	 *
	 * @param element:
	 *            the element being searched for
	 *
	 * @return the last index of the element being searched for
	 *
	 ********************************************************************/
	public int lastIndexOf(E element) {
		SLLNode<E> token = head;
		int last = -1;
		for (int i = 0; token.getNext() != null; i++) {
			token = token.getNext();
			if (token.getData().equals(element)) {
				last = i;
			}
		}
		return last;
	}

	/********************************************************************
	 *
	 * Method: removeIndex
	 *
	 * Description: Removes the element at the given index. Returns the removed
	 * element or null if no element was removed
	 * 
	 *
	 * @param index:
	 *            the index to be removed
	 *
	 * @return the removed element, or null if no element was removed
	 *
	 ********************************************************************/
	public E removeIndex(int index) {
		SLLNode<E> token = head;
		SLLNode<E> token2 = null;
		try {
			for (int i = 0; i <= index; i++) {
				token2 = token;
				token = token.getNext();
			}
			token2.setNext(token.getNext());
			size--;
			return token.getData();
		} catch (NullPointerException e) {
			return null;
		}

	}

	/********************************************************************
	 *
	 * Method: removeElement
	 *
	 * Description: Removes the first occurrence of the element. Returns the
	 * removed element or null if no element was removed
	 * 
	 *
	 * @param element:
	 *            the element to be searched for and removed
	 *
	 * @return the removed element, or null if no element was removed
	 *
	 ********************************************************************/
	public E removeElement(E element) {
		SLLNode<E> token = head;
		SLLNode<E> token2 = head;
		while (token.getNext() != null) {
			token2 = token;
			token = token.getNext();
			if (token.getData().equals(element)) {
				token2.setNext(token.getNext());
				size--;
				return token.getData();
			}
		}
		return null;
	}

	/********************************************************************
	 *
	 * Method: set
	 *
	 * Description: Sets the value at the given index to the given element.
	 * Returns the previous value or null if the index is out of bounds
	 * 
	 *
	 * @param index:
	 *            the location of the value to be changed element: the value to
	 *            replace at the specified index
	 *
	 * @return the previous value or null if the index is out of bounds
	 *
	 ********************************************************************/
	public E set(int index, E element) {
		try {
			SLLNode<E> token = head.getNext();
			for (int i = 0; i < index; i++) {
				token = token.getNext();
			}
			E token2 = token.getData();
			token.setData(element);
			return token2;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/********************************************************************
	 *
	 * Method: size
	 *
	 * Description: Returns the number of elements in this list.
	 * 
	 *
	 * @param none
	 *
	 * @return size: the size of of the list
	 *
	 ********************************************************************/
	public int size() {
		/*
		 * SLLNode<E> token = head;
		 * 
		 * for(int i = 1; token.getNext()!=null; i++){ token = token.getNext();
		 * if(token.getNext()==null){ return i; } }
		 * 
		 * return 0;
		 */
		return size;
	}

	/********************************************************************
	 *
	 * Method: toString
	 *
	 * Description: Returns a String representation of the list. If the list is
	 * empty, print “[]”. Otherwise, print “[1, 2, 3, etc…]”. You must include
	 * the brackets in your string or you will not get credit.
	 * 
	 *
	 * @param none
	 *
	 * @return list: a String that lists all of the items in the list
	 *
	 ********************************************************************/
	public String toString() {
		String list = "[";
		SLLNode<E> token = head;
		try {
			token = token.getNext();
			while (token.getNext() != null) {
				list += token.getData();
				token = token.getNext();
				list += ", ";
			}
			list += token.getData() + "]";
		} catch (NullPointerException e) {
			list += "]";
		}
		return list;
	}

	/********************************************************************
	 *
	 * Method: Iterator
	 *
	 * Description: Returns an Iterator starting at the head of the list
	 * 
	 *
	 * @param none
	 *
	 * @return an Iterator starting at the head of the list
	 *
	 ********************************************************************/
	public Iterator<E> Iterator() {
		return new SLLIterator();
	}

	/********************************************************************
	 *
	 * Class: SLLIterator
	 *
	 * Description: Private inner Iterator class
	 * 
	 * @implements Iterator
	 *
	 ********************************************************************/
	private class SLLIterator implements Iterator {
		private SLLNode<E> next;

		/********************************************************************
		 *
		 * Method: SLLIterator
		 *
		 * Description: constructor that sets next to head
		 * 
		 *
		 * @param none
		 *
		 * @return none
		 *
		 ********************************************************************/
		public SLLIterator() {
			next = head;
		}

		/********************************************************************
		 *
		 * Method: hasNext
		 *
		 * Description: Returns true if the next method would return a value
		 * that is not null
		 * 
		 *
		 * @param none
		 *
		 * @return true if next is null
		 *
		 ********************************************************************/
		public boolean hasNext() {
			if (next.getNext() != null) {
				return true;
			} else {
				return false;
			}
		}

		/********************************************************************
		 *
		 * Method: next
		 *
		 * Description: Returns the next value in the list
		 * 
		 *
		 * @param none
		 *
		 * @return the data of the next value
		 *
		 ********************************************************************/
		public E next() {
			next = next.getNext();
			return next.getNext().getData();
		}

		/********************************************************************
		 *
		 * Method: remove
		 *
		 * Description: Removes the last element returned by the next method
		 * 
		 *
		 * @param none
		 *
		 * @return none
		 *
		 ********************************************************************/
		public void remove() {
			SLLNode<E> token = head;
			while (!token.getNext().equals(next)) {
				token = token.getNext();
			}
			token.setNext(next.getNext());
		}
	}
}
