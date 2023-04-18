package Classes.StudentInformationSystem;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Meltem","Language","00040294261","Woman");
        Teacher t2 = new Teacher("Gamze","History","00015486225","Woman");
        Teacher t3 = new Teacher("Sena","Biology","00089465212","Woman");

        Course lng = new Course("English Language","101","Language",t1);
        lng.addTeacher(t1);
        Course hst = new Course("Europan History","102","History",t2);
        hst.addTeacher(t2);
        Course bio = new Course("Human Biology","103","Biology",t3);
        bio.addTeacher(t3);

        Student s1 = new Student("Kemal Kavakbaşı","1560","4",lng,hst,bio);
        s1.addMidtermResult(85,90,100);
        s1.addFinalResult(70,65,25);
        s1.isPass();

        Student s2 = new Student("Oğuz Akçay","886","3",lng,hst,bio);
        s2.addMidtermResult(95,85,65);
        s2.addFinalResult(75,100,100);
        s2.isPass();
    }
}
