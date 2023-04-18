package Classes.MaasHesaplayıcı;

import javax.swing.*;

public class Employee {

    String name;
    int salary; // maaş
    int workHours; // haftalık çalışma saati
    int hireYear; // işe başlama yılı

    Employee(String name,int salary,int workHours,int hireYear){

        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;

    }

   double tax() {
        if (this.salary < 1000) {
            return 0;
        }
        else {
            return this.salary * 0.003;
        }

    }

    int bonus(){

        if (this.workHours>40){
            int fazladanSaat = this.workHours - 40;
            int bonusUcret = fazladanSaat * 30;
            return bonusUcret;
        }
        else {
            System.out.println("Bonustan faydalanamıyorsunuz ! ");
            return 0;
        }
    }

    double raiseSalary(){

        if (2021-this.hireYear<10){
           return this.salary * 0.05 + this.salary;
        }
        if (2021-this.hireYear>9 && 2021-this.hireYear<20){
           return this.salary * 0.10 + this.salary;

        }
        if (2021-this.hireYear>19){
           return this.salary * 0.15 + this.salary;
        }
        else
        {
            System.out.println("Yanlış bir değer girdiniz ! ");
        }
    return 0;
    }

    void toPrint(){

        double tax = this.tax();
        int bonus = this.bonus();
        double vergiBonus = this.salary + bonus - tax;
        double raiseSalary = raiseSalary();
        double toplamMaas = raiseSalary + bonus - tax;


        System.out.println("Çalışanın Adı => " + this.name);
        System.out.println("Çalışanın Maaşı => " + this.salary);
        System.out.println("Çalışanın Çalışma Saati => " + this.workHours);
        System.out.println("Çalışanın Başlangıç Yılı => " + this.hireYear);
        System.out.println("Çalışana Uygulanan Vergi => " + tax);
        System.out.println("Çalışana Verilecek Bonus => " + bonus);
        System.out.println("Vergi ve Bonuslar ile Maaş => " + vergiBonus );
        System.out.println("Toplam Maaş => " + toplamMaas);


    }


}


