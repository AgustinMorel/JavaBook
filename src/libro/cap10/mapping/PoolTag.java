package libro.cap10.mapping;

public class PoolTag {
	private String name;
	private int minsize;
	private int maxsize;
	private int steep;

	public String toString() {
		return name + ", " + minsize + ", " + maxsize + ", " + steep;
	}

	public String getName() {
		return name;
	}

	public int getMinsize() {
		return minsize;
	}

	public int getMaxsize() {
		return maxsize;
	}

	public int getSteep() {
		return steep;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setMinsize(int min) {
		this.minsize = min;
	}

	public void setMaxsize(int max) {
		this.maxsize = max;
	}

	public void setSteep(int s) {
		this.steep = s;
	}

}
