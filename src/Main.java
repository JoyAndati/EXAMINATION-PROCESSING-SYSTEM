import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("Enter number of students (min 2):");
        int studentCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter name of student:");
            String name = scanner.nextLine();

            System.out.println("Enter ID of student:");
            String id = scanner.nextLine();

            Student student = new Student(name, id);

            System.out.println("Enter number of subjects (min 5):");
            int subjectCount = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < subjectCount; j++) {
                System.out.println("Enter subject name:");
                String subject = scanner.nextLine();

                System.out.println("Enter score for " + subject + ":");
                int score = Integer.parseInt(scanner.nextLine());

                student.addSubjectScore(subject, score);
            }

            students.add(student);
        }

        System.out.println("\n--- REPORT CARDS ---");
        for (Student s : students) {
            printReportCard(s);
        }
    }

    public static void printReportCard(Student student) {
        System.out.println("\n=========================");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Subjects and Scores:");
        for (Map.Entry<String, Integer> entry : student.getSubjects().entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Average Score: " + student.calculateAverage());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Recommendation: " + student.getRecommendation());
        System.out.println("Report Date: " + new Date());
        System.out.println("=========================");
    }
}
