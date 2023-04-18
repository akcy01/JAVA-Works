package Classes.StudentInformationSystem;

import java.security.cert.CertificateParsingException;

public class Student {
    String name;
    String stuNo;
    String classes;
    Course course1;
    Course course2;
    Course course3;
    double average ;
    boolean isPass ;

    Student(String name,String stuNo,String classes,Course course1,Course course2,Course course3){

        this.name=name;
        this.stuNo=stuNo;
        this.classes=classes;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.average=0.0;
        this.isPass=false;

    }

    void addMidtermResult(double languageMidterm,double historyMidterm,double biologyMidterm) {

        if (languageMidterm >= 0 && languageMidterm <= 100) {
            course1.midtermResult = languageMidterm;
        }
        if (historyMidterm >= 0 && historyMidterm <= 100) {
            course2.midtermResult = historyMidterm;
        }
        if (biologyMidterm >= 0 && biologyMidterm <= 100) {
            course3.midtermResult = biologyMidterm;
        }

    }
        void addFinalResult(double languageFinal,double historyFinal,double biologyFinal){
            if (languageFinal>=0 && languageFinal<=100){
               course1.finalResult = languageFinal;
               course1.courseAverage = course1.midtermResult * 0.2 + course1.finalResult * 0.8;
            }
            if (historyFinal>=0 && historyFinal<=100){
                course2.finalResult = historyFinal;
                course2.courseAverage = course2.midtermResult * 0.2 + course2.finalResult * 0.8;
            }
            if (biologyFinal>=0 && biologyFinal<=100){
                course3.finalResult = biologyFinal;
                course3.courseAverage = course3.midtermResult * 0.2 + course3.finalResult * 0.8;
            }

            }

    void isPass() {
        this.average = (this.course1.courseAverage + this.course2.courseAverage + this.course3.courseAverage) / 3.0;
        if (this.average >= 55) {
            System.out.println("You have successfully passed the class :) !! ");
        } else {
            System.out.println("You did not pass the class :( !! ");

        }
        printNote();
    }

    void printNote(){
        System.out.println(this.course1.name + " Your note => " + this.course1.courseAverage);
        System.out.println(this.course2.name + " Your note => " + this.course2.courseAverage);
        System.out.println(this.course3.name + " Your note => " + this.course3.courseAverage);
        System.out.println("Your average of all courses  => " + this.average);
    }


    }



