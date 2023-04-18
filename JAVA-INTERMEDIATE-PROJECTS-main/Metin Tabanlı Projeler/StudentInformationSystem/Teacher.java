package Classes.StudentInformationSystem;

public class Teacher {
    String name;
    String branch;
    String phone;
    String gender;

    Teacher(String name,String branch,String phone,String gender){

        this.name=name;
        this.branch=branch;
        this.phone=phone;
        this.gender=gender;

    }
    void print(){
        System.out.println(name);
        System.out.println(branch);
        System.out.println(phone);
        System.out.println(gender);
    }
}
