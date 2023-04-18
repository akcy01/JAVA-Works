package Classes.BoxingGame;

public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    Fighter(String name,int damage,int health,int weight,int dodge){

        this.name=name;
        this.damage=damage;
        this.health=health;
        this.weight=weight;

        if (dodge<=100 && dodge>=0){
            this.dodge=dodge;
        }else {
            this.dodge = 0;
        }


    }

    int hit(Fighter foe){ // Alınan hasarı rakibin canından eksilten metot.Foe hasarı alan herhangi bir dövüscü
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " damaged ");
        if (isDodge()){
            System.out.println(foe.name + " BLOCKED !! ");
            return foe.health;
        }
        if (foe.health - this.damage < 0){
          return 0;
        }
        return foe.health - this.damage;
    }

    boolean isDodge(){
           double randomNumber = Math.random() * 100;
           return randomNumber <= this.dodge;

    }
}
