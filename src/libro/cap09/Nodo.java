package libro.cap09;

public class Nodo<T> {
	private T info;
	private Nodo<T> ref;

	public void setInfo(T i) {
		info = i;
	}

	public void setRef(Nodo<T> n) {
		ref = n;
	}

	public Nodo<T> getRef() {
		return ref;
	}

	public T getInfo() {
		return info;
	}
	/*
	public Nodo<T> getSig(){
		return ref;
	}
	
	public void setSig(Nodo<T> r){
	ref 
	}	
	*/
}



