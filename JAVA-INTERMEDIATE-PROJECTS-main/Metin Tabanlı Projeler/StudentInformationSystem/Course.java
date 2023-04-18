package Classes.StudentInformationSystem;

import javax.xml.namespace.QName;

public class Course {
    Teacher teacher; //classes can be attributes of classes
    String name;
    String code;
    String prefix;
    double midtermResult;
    double finalResult;
    double note;
    double courseAverage;

    Course(String name,String code,String prefix,Teacher teacher){ //This is a constructor
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.teacher = teacher;
        int note = 0;
    }

    void addTeacher(Teacher teacher){
        if (teacher.branch.equals(this.prefix)){
            this.teacher=teacher;
        }else{
            System.out.println("Teacher and department do not match !");
        }

    }

    void printTeacherInfo(){
        this.teacher.print();
    }

}
