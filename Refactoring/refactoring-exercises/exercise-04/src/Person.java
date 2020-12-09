import java.io.IOException;
import java.io.Writer;
//Encapsulate fields
//Inline class
public class Person {
	private String last;

	private String first;

	private String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	public void printPerson(Writer out) throws IOException {
		out.write(getFirst());
		out.write(" ");
		if (getMiddle() != null) {
			out.write(getMiddle());
			out.write(" ");
		}
		out.write(getLast());
	}
	public String formatPerson() {
		String result = getLast() + ", " + getFirst();
		if (getMiddle() != null)
			result += " " + getMiddle();
		return result;
	}
	public void display(Writer out) throws IOException {
		out.write(getLast());
		out.write(", ");
		out.write(getFirst());
		if (getMiddle() != null) {
			out.write(" ");
			out.write(getMiddle());
		}
	}

	@Override
	public String toString() {
		return getFirst() + ", " + getLast()
				+ ((getMiddle() == null) ? "" : " " + getMiddle());
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}
}