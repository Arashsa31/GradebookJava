import java.util.*;

public class CourseGradebook extends Gradebook {
    private HashMap<String, HashMap<Integer, Double>> gradebook;

    public CourseGradebook() {
        this.gradebook = new HashMap<>();
    }

    public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
        if (gradebook.containsKey(assignmentName)) {
            return new HashMap<>(gradebook.get(assignmentName));
        } else {
            return new HashMap<>();
        }
    }

    public double getScore(String assignmentName, Integer studentID) {
        if (gradebook.containsKey(assignmentName) && gradebook.get(assignmentName).containsKey(studentID)) {
            return gradebook.get(assignmentName).get(studentID);
        } else {
            return Double.NaN;
        }
    }

    public ArrayList<String> getSortedAssignmentNames() {
        ArrayList<String> assignmentNames = new ArrayList<>(gradebook.keySet());
        Collections.sort(assignmentNames);
        return assignmentNames;
    }

    public ArrayList<Integer> getSortedStudentIDs() {
        HashSet<Integer> studentIDs = new HashSet<>();
        for (HashMap<Integer, Double> studentGrades : gradebook.values()) {
            studentIDs.addAll(studentGrades.keySet());
        }
        ArrayList<Integer> sortedIDs = new ArrayList<>(studentIDs);
        Collections.sort(sortedIDs);
        return sortedIDs;
    }

    public HashMap<String, Double> getStudentScores(Integer studentID) {
        HashMap<String, Double> studentScores = new HashMap<>();
        for (String assignmentName : gradebook.keySet()) {
            if (gradebook.get(assignmentName).containsKey(studentID)) {
                studentScores.put(assignmentName, gradebook.get(assignmentName).get(studentID));
            }
        }
        return studentScores;
    }

    public void setScore(String assignmentName, Integer studentID, Double score) {
        if (!gradebook.containsKey(assignmentName)) {
            gradebook.put(assignmentName, new HashMap<>());
        }
        gradebook.get(assignmentName).put(studentID, score);
    }
}
