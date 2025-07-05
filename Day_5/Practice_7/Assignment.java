package Day_5.Practice_7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Day_5.Practice_7.Exceptions.AssignmentAlreadySubmitted;
import Day_5.Practice_7.Exceptions.AssignmentSubmissionClosedException;
import Day_5.Practice_7.Exceptions.InvalidGradeException;
import Day_5.Practice_7.Exceptions.StudentAlreadyExistsException;
import Day_5.Practice_7.Exceptions.StudentNotFoundException;

public class Assignment {
    private String name;
    private LocalDate dueDate;
    private List<String> listOfTasks;
    private List<Object> readingMaterials;
    private Double max_mark;

    private List<Object> submittedObjects;
    private List<String> listOfStudents;
    private List<Double> marks;
    private List<Boolean> submissionStatus;

    public Assignment(String name, LocalDate dueDate, List<String> listOfTasks, List<Object> readingMaterials, Double max_mark) {
        this.name = name;
        this.dueDate = dueDate;
        this.listOfTasks = listOfTasks;
        this.readingMaterials = readingMaterials;
        this.listOfStudents = new ArrayList<>();
        this.submittedObjects = new ArrayList<>();
        this.submissionStatus = new ArrayList<>();
        this.marks = new ArrayList<>();
        this.max_mark = max_mark;
    }

    public Assignment(String name, LocalDate dueDate, List<String> listOfTasks, List<Object> readingMaterials, Double maxMark ,List<String> listOfStudents) throws StudentAlreadyExistsException {
        this(name, dueDate, listOfTasks, readingMaterials, maxMark);
        assignStudents(listOfStudents);
    }

    public void assignStudents(List<String> newStudents) throws StudentAlreadyExistsException {
        for(String student : newStudents) {
            if(listOfStudents.contains(student)) {
                throw new StudentAlreadyExistsException(name + " already has a student named: " + student);
            }
        }
        this.listOfStudents.addAll(newStudents);
        this.submittedObjects.addAll(Stream.generate(() -> new Object()).limit(newStudents.size()).toList());
        this.submissionStatus.addAll(Stream.generate(() -> false).limit(newStudents.size()).toList());
        this.marks.addAll(Stream.generate(() -> 0.0).limit(newStudents.size()).toList());
    }

    public void submitAssignment(String studentName, Object submissionItem) throws AssignmentAlreadySubmitted, StudentNotFoundException, AssignmentSubmissionClosedException {
        Integer studentIndex = getStudentIndex(studentName);

        if(LocalDate.now().isAfter(dueDate)) {
            throw new AssignmentSubmissionClosedException("Submission for assignment " + name + " is closed.");
        }

        if(studentIndex != -1) {
            if(!submissionStatus.get(studentIndex)) {
                submittedObjects.set(studentIndex, submissionItem);
                submissionStatus.set(studentIndex, true);
            } else {
                throw new AssignmentAlreadySubmitted(studentName + " has already submitted the assignment: " + name);
            }
        } else {
            throw new StudentNotFoundException(studentName + " is not enrolled in the assignment: " + name);
        }
    }

    public void gradeAssignment(String studentName, double marks) throws StudentNotFoundException, InvalidGradeException {
        if(marks < 0 || marks > max_mark) {
            throw new InvalidGradeException("Marks must be between 0 and " + max_mark);
        }
        Integer studentIndex = getStudentIndex(studentName);

        if(submissionStatus.get(studentIndex) == false) {
            throw new InvalidGradeException(studentName + " has not submitted the assignment: " + name);
        }

        if(studentIndex != -1) {
            this.marks.set(studentIndex, marks);
        } else {
            throw new StudentNotFoundException(studentName + " is not enrolled in the assignment: " + name);
        }
    }

    public void printAssignmentDetails() {
        System.out.println("Assignment Name: " + name);
        System.out.println("Due Date: " + dueDate);
        for (int i = 0; i < listOfTasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + listOfTasks.get(i));
        }
        System.out.println("Reading Materials: ");
        for (Object material : readingMaterials) {
            System.out.println(" - " + material);
        }
    }

    private int getStudentIndex(String studentName) {
        return listOfStudents.indexOf(studentName);
    }

    public void printSubmissionStatus() {
        String line = "|----------------------------------------------------------------------------|";
        System.out.println(line);
        System.out.printf("| %-4s  | %-14s | %-28s | %-10s |\n", "Student Name", "Submitted", "Submission", "Marks");
        System.out.println(line);
        for (int i = 0; i < listOfStudents.size(); i++) {
            String student = listOfStudents.get(i);
            boolean status = submissionStatus.get(i);
            Object submission = submittedObjects.get(i);
            Double mark = marks.get(i);
            System.out.printf("| %-16s  | %-10s | %-28s | %-10.2f |\n", student, status ? "Yes" : "No", submission.getClass() == String.class ? submission : "N/A", mark);
        }
        System.out.println(line);
        System.out.println();
    }

    public String getName() {
        return name;
    }

}
