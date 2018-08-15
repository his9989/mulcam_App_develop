package edu.jaen.java.util;

public class ArrayGeneric<T> {

	private int max = 10;
	private Object[] objs = new Object[max];
	private int index;
	
	public void add(T o) {
		if(index>=0 && index<objs.length) {
			objs[index] = o;
			index++;
		} else {
			max *= 2;
			Object[] tmp = new Object[max];
			System.arraycopy(objs, 0, tmp, 0, objs.length);
			objs = tmp;
			objs[index] = o;
			index++;
		}
		
	}
	
	public T get(int i) {
		return (T)objs[i];
	}

	public String toString() {
		String str = new String();
		for(int i=0; i<index; i++) {
			str += objs[i].toString()+"\t";
		}
		return "["+str+"]";
	}
}
