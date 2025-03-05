package uni;

import java.util.*;

public class Student {
    public int studentID;
    public static List<Student> studentList = new ArrayList<Student>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentCode;

    public Student (int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        if (Major.findById(majorID) != null){
            Major.findById(majorID).addStudent();
        }
        setStudentCode();
        studentList.add(this);
        this.studentID = studentList.size();
    }

    public static Student findById(int ID){
        for (Student student : studentList){
            if (student.studentID == ID)
                return student;
        }
        return null;
    }

    public void setStudentCode(){
        if (Major.findById(majorID) != null) {
            this.studentCode = String.valueOf(entranceYear * 100000 + majorID * 1000 +
                    Major.findById(majorID).numberOfStudents);
        }
    }
}