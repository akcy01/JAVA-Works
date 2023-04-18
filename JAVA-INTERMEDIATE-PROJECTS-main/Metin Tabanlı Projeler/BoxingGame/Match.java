package Classes.BoxingGame;

public class Match {

    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

     Match(Fighter f1,Fighter f2,int minWeight,int maxWeight){

        this.f1=f1;
        this.f2=f2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;

    }

    void run(){
         if (isCheck()){ //Since we do not know how long the result will return,we will run the while loop.
            while (this.f1.health>0 && this.f2.health>0){
                System.out.println("*****NEW ROUND*******");
                if (whoStarts()){
                    this.f2.health = this.f1.hit(this.f2);//F1 in vurduğu hasarı hit metotuna gönderdik
                     if (isWin()){                              //o da f2 nin healthından bunu çıkardı..
                        break;
                     }
                }
                else{
                    this.f1.health = this.f2.hit(this.f1);

                    if (isWin()){
                        break;
                    }
                    System.out.println(this.f1.name + " Health " + this.f1.health);
                    System.out.println(this.f2.name + " Health " + this.f2.health);
                }
            }
         }
         else{ // If the weights don't match this will work
             System.out.println("The weights of the fighters do not match !");
         }
    }

    boolean whoStarts(){
         double randomDeger = Math.random();
         if (randomDeger<=0.5){
             System.out.println("First fighter begins !  ");
             return true;
         }else{
             System.out.println("Second fighter begins ! ");
             return false;
         }
    }

    boolean isCheck(){

         return (this.f1.weight>=minWeight && this.f1.weight<=maxWeight) &&
                 (this.f2.weight>=minWeight && this.f2.weight<=maxWeight);

    }

    boolean isWin(){

         if (this.f1.health==0){
             System.out.println(this.f2.name + " WIN !!");
             return true;
         }

         if (this.f2.health==0){
             System.out.println(this.f1.name + " WIN !!");
             return true;
         }
         return false;
    }
}
