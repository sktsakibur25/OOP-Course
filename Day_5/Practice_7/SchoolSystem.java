package Day_5.Practice_7;

import java.time.LocalDate;
import java.util.List;

public class SchoolSystem {
    public static void main(String[] args) {
        List<String> students = List.of("Alice", "Bob", "Charlie", "David", "Eve");

        List<String> tasks = List.of("Do this", "Do that", "Do this & that");
        List<Object> readingMaterials = List.of("Book 1", "Book 2", "Book 3");

        try {
            Assignment assignment = new Assignment("Math Assignment", LocalDate.now().plusDays(10), tasks, readingMaterials, 50.0 ,students);
            System.out.println("Assignment created successfully");

            assignment.printAssignmentDetails();
            
            // Simulate student submissions
            assignment.submitAssignment("Alice", "Solution by Alice");
            assignment.submitAssignment("Bob", "Solution by Bob");
            
            // Print submission status
            assignment.printSubmissionStatus();

            // Assign new students
            List<String> newStudents = List.of("Frank", "Grace");
            assignment.assignStudents(newStudents);
            System.out.println("New students assigned successfully : "+newStudents+" to "+assignment.getName() +"\n");

            assignment.gradeAssignment("Alice", 40.0);
            assignment.gradeAssignment("Bob", 35.0);

            assignment.printSubmissionStatus();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
