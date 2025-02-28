import java.io.*;


class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;
    
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", GPA=" + gpa + "]";
    }
}

public class StudentSerializer {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student(1001, "John Doe", 3.85);
        
        try {
            // Serialize the student object
            serializeStudent(student, "student.ser");
            System.out.println("Student object serialized successfully.");
            
            // Deserialize the student object
            Student deserializedStudent = deserializeStudent("student.ser");
            System.out.println("Student object deserialized successfully.");
            System.out.println("Student details: " + deserializedStudent);
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
    
   
    public static void serializeStudent(Student student, String fileName) 
            throws FileNotFoundException, IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
        }
    }
    
    
    public static Student deserializeStudent(String fileName) 
            throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) in.readObject();
        }
    }
}
