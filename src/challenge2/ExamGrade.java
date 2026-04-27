package challenge2;

public class ExamGrade {

    public static String getGrade(int score) {

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else if (score >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        System.out.println(getGrade(95));
        System.out.println(getGrade(72));
        System.out.println(getGrade(40));
    }
}