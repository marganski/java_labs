package lab1;

public class COOValue {
	private int index;
	private Object wartosc;
	
	public COOValue(int i, Object o){
		index = i;
		wartosc = o;
	}
	public int getIndex(){
		return index;
	}
	public Object getWartosc() {
		return wartosc;
	}
	public String toString() {
		return ""+index+wartosc;
	}

}
