/**
 * 
 */
package poo21.LinkedList.Implementations;

import java.util.Collection;

/**
 * Implementazione di una Linked List non modificabile
 * @see poo21.LinkedList.Implementations.LinkedList<E>
 * @author bruand
 *
 */
public class UnmodifiableLinkedList<E> extends LinkedList<E> {
	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException("La lista non è modificabile");
	}
}
