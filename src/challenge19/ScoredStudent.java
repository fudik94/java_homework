package challenge19;

public class ScoredStudent extends Student {

    private double percentComplete;

    public ScoredStudent(int studentId, String name, String course, int year, double percentComplete) {
        super(studentId, name, course, year);
        this.percentComplete = percentComplete;
    }

    // override: match if percentComplete <= value, not just equal
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(fieldName, value); // search by same fields as Student
    }

    public double getPercentComplete() { return percentComplete; }

    @Override
    public String toString() {
        return String.format("id=%-4d name=%-20s course=%-15s year=%d  done=%.0f%%",
                getStudentId(), getName(), getCourse(), getYear(), percentComplete);
    }
}
