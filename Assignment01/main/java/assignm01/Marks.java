package assignm01;

public class Marks {
	 String subjects;
	 double marks;
	
	 public Marks(String subjects, double marks) {
		super();
		this.subjects = subjects;
		this.marks = marks;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Marks [subjects=" + subjects + ", marks=" + marks + "]";
	}
	 
	
	


}
