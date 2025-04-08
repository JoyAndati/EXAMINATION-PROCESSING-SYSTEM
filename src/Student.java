import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<String, Integer> subjects;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.subjects = new HashMap<>();
    }

    public void addSubjectScore(String subject, int score) {
        subjects.put(subject, score);
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double calculateAverage() {
        if (subjects.isEmpty()) return 0;
        int total = 0;
        for (int score : subjects.values()) {
            total += score;
        }
        return total / (double) subjects.size();
    }

    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 70) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else if (avg >= 40) return "D";
        else return "E";
    }

    public String getRecommendation() {
        switch (getGrade()) {
            case "A": return "Excellent";
            case "B": return "Good";
            case "C": return "Average";
            case "D": return "Poor";
            default: return "Fail";
        }
    }
}
