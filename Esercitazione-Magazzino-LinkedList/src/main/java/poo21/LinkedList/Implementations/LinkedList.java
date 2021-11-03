/**
 * 
 */
package poo21.LinkedList.Implementations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementazione di una Linked List
 * @see java.util.List
 * @author bruand
 *
 */
public class LinkedList<E> implements List<E> {
	private Node head = null;
	private int size = 0;
	
	/**
	 * Nodo di una linked list
	 * @author bruand
	 *
	 */
	private class Node{
		E data = null;
		Node next = null;
		
		public boolean hasNext() {
			return next != null;
		}
	}
	
	private class LinkedListIterator implements ListIterator<E> {
		private Node cursor = new Node();
		private boolean isModifiable = false;

		/**
		 * Implementazione di un iteratore di Linked List 
		 * @see java.util.ListIterator
		 * @author bruand
		 */
		public LinkedListIterator() {
			this.cursor = LinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.cursor.hasNext();
		}

		@Override
		public E next() {
			if(!this.hasNext()) {
				throw new NoSuchElementException("The iteration has no next element");
			}
			isModifiable=true;
			return this.cursor.next.data;
		}

		@Override
		public boolean hasPrevious() {
			throw new UnsupportedOperationException("hasPrevious is not supported by this implementation");
		}

		@Override
		public E previous() {
			throw new UnsupportedOperationException("previous is not supported by this implementation");
		}

		@Override
		public int nextIndex() {
			if(!cursor.hasNext()) {
				return LinkedList.this.size();
			}
			int count = 0;
			Node tmp = LinkedList.this.head;
			while(tmp.hasNext()) {
				if(tmp==cursor.next) {
					break;
				}
				tmp = tmp.next;
				count++;
			}
			return count;
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException("previousIndex is not supported by this implementation");
		}

		@Override
		public void remove() {
			if(!isModifiable) {
				throw new IllegalStateException();
			}
			int index = this.nextIndex()-1;
			Node parent = new Node();
			parent.next = LinkedList.this.head;
			while(parent.hasNext()) {
				if(parent.next == cursor) {
					break;
				}
				parent = parent.next;
			}
			LinkedList.this.remove(index);
			cursor=parent;
			this.isModifiable=false;
			
		}

		@Override
		public void set(E e) {
			if(!isModifiable) {
				throw new IllegalStateException();
			}
			int index = this.nextIndex()-1;
			LinkedList.this.set(index, e);
			
		}

		@Override
		public void add(E e) {
			int index = this.nextIndex()-1;
			if(index<0) {
				index = 0;
			}
			LinkedList.this.add(index, e);
			this.isModifiable=false;
		}
		
	}

	/**
	 * 
	 */
	public LinkedList() {}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		if(this.isEmpty()) {
			return false;
		}
		
		Node n = head;
		do {
			if(n.data.equals(o)) {
				return true;
			}
			n = n.next;
		} while(n.hasNext());
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[this.size()];
		if(!this.isEmpty()) {
			Node n = this.head;
			int count = 0;
			do {
				a[count] = n.data;
				n =n.next;
				count++;
			} while(n.hasNext());
		}
		return a;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(!this.isEmpty()) {
			if(this.size() > a.length) {
				a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
			}
			Node n = this.head;
			int count = 0;
			do {
				
				try {
					a[count] = (T) n.data;
				} catch (ClassCastException e) {
					throw new ArrayStoreException(e.getMessage());
				}
				n =n.next;
				count++;
			} while(n.hasNext());
		}
		return a;
	}

	@Override
	public boolean add(E e) {
		Node n = new Node();
		n.data=e;
		if(this.isEmpty()) {
			head = n;
		} else {
			Node c = head;
			while(c.hasNext()) {
				c = c.next;
			}
			c.next=n;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if(this.isEmpty()) {
			return false;
		}
		
		if(head.data.equals(o)) {
			Node tmp = head;
			head = head.next;
			tmp.next = null;
 			return true;
		}
		
		Node n = head.next;
		Node parent = head;
		do {
			if(n.data.equals(o)) {
				parent.next = n.next;
				n.next = null;
				return true;
			}
			parent = parent.next;
			n = n.next;
		} while(n.hasNext());
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(this.isEmpty()) {
			return c.isEmpty();
		}
		
		boolean flag = true;
		
		Iterator<?> iter = (Iterator<?>) c.iterator(); 
		
		while(iter.hasNext()) {
			flag = flag && this.contains(iter.next());
		}
		
		return flag;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Iterator<? extends E> iter = (Iterator<? extends E>) c.iterator();
		
		while(iter.hasNext()) {
			this.add(iter.next());
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Iterator<? extends E> iter = (Iterator<? extends E>) c.iterator();
		
		while(iter.hasNext()) {
			this.add(index, iter.next());
			index++;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Iterator<?> iter = (Iterator<?>) c.iterator();
		
		while(iter.hasNext()) {
			this.remove(iter.next());
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		ListIterator<E> l = this.listIterator();
		while (l.hasNext()) {
			if(!c.contains(l.next())) {
				l.remove();
			}
		}
		return true;
	}

	@Override
	public void clear() {
		this.head=null;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			return this.head.data;
		}
		int count = 0;
		Node n = this.head;
		while(n.hasNext()) {
			if(count == index) {
				break;
			}
			count ++;
			n = n.next;
		}
		return n.data;
	}

	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		Node curNode = this.head;
		while(curNode.hasNext()) {
			if(count == index) {
				break;
			}
			curNode = curNode.next;
			count++;
		}
		curNode.data = element;
		return element;
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(index);
		}
		Node n = new Node();
		n.data = element;
		if(index == 0) {
			n.next = head;
		}
		
		Node parent = this.head;
		Node current = this.head.next;
		int count = 1;
		while(current.hasNext()) {
			if(index == count) {
				break;
			}
			count++;
			parent = parent.next;
			current = current.next;
		}
		parent.next = n;
		n.next=current;

	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		E data = null;
		if (index == 0) {
			data = this.head.data;
			this.head = this.head.next;
			return data;
		}
		int count = 1;
		Node n = this.head.next;
		Node parent = this.head;
		while(n.hasNext()) {
			if(count == index) {
				break;
			}
			count ++;
			n = n.next;
			parent = parent.next;
		}
		data = n.data;
		parent.next = n.next;
		n.next = null;
		return data;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		int count = 0;
		Node n = this.head;
		int size = size(); //Per ottimizzare la performance
		while(count < size) {
			if(n.data.equals(o)) {
				index = count;
				break;
			}
			count ++;
			n = n.hasNext()?n.next:n;
		}
		return index;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		int count = 0;
		Node n = this.head;
		int size = size(); //Per ottimizzare la performance
		while(count < size) {
			if(n.data.equals(o)) {
				index = count;
			}
			count ++;
			n = n.hasNext()?n.next:n;
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new LinkedListIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int count = 0;
		Node n = this.head;
		while(n.hasNext()) {
			if(count == index) {
				break;
			}
			count++;
			n=n.next;
		}
		LinkedListIterator iter = new LinkedListIterator();
		iter.cursor.next = n;
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		
		//punto a fromIndex
		int count = 0;
		Node n = this.head;
		while(n.hasNext()) {
			if(count == fromIndex) {
				break;
			}
			n = n.next;
			count++;
		}
		
		//Inizializzo LinkedList
		LinkedList<E> l = new LinkedList<>();
		l.add(n.data);
		
		//agiungo tutti i nodi fino a toIndex escluso
		while(n.hasNext()) {
			if(count >= toIndex) {
				break;
			}
			n=n.next;
			l.add(n.data);
			count++;
		}
		return l;
	}

}
