package test.mypac;

public class FruitBox<T> {
/*
	private Apple apple;
	private Banana banana;
	private Orange orange;
	이것을 포괄적으로 담기 위함
*/
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}


}
