package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import interfaces.Accesible;

public class Catalogo<T extends Accesible> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<T> container;

	public Catalogo() {
		container = new ArrayList<T>();
	}

	public boolean isEmpty() {
		return container.isEmpty();
	}

	public void add(T element) {
		container.add(element);
	}

	public void modify(int i, T element) {
		container.remove(i);
		container.add(i, element);
	}

	public T remove(int position) {
		return container.remove(position);
	}

	public void remove(T element) {
		container.remove(element);
	}

	public T getElementEach(String password) {
		for (T t : container) {
			if (t.getPassword().equalsIgnoreCase(password)) {
				return t;
			}
		}
		return null;
	}

	public boolean contains(String password) {
		for (T t : container) {
			if (t.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		}
		return false;
	}

	public T getElementContains(T element) {
		if (container.contains(element)) {
			return container.get(container.indexOf(element));
		}
		;
		return null;
	}

	public T getElementLambda(String password) {
		T element = container.stream().filter(s -> s.getPassword().equalsIgnoreCase(password)).toList().get(0);
		return element;
	}

	public T getElement(int i) {
		T element = container.get(i);
		return element;
	}

	public int getIndex(String password) {
		for (int i = 0; i < container.size(); i++) {
			if (container.get(i).getPassword().equalsIgnoreCase(password)) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return container.size();
	}

	public void ordenar() {
		container.sort((p1, p2) -> p1.getPassword().compareToIgnoreCase(p2.getPassword()));
	}
}
