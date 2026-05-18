package challenge19;

import java.util.ArrayList;

// extends ArrayList — no separate items field needed
public class QueryList<T extends Student> extends ArrayList<T> {

    public QueryList() {
        super();
    }

    public QueryList<T> getStudentsByValue(String fieldName, String value) {
        QueryList<T> result = new QueryList<>();
        for (T student : this) {
            if (student.matchFieldValue(fieldName, value)) {
                result.add(student);
            }
        }
        return result;
    }
}
