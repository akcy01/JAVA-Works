package AdventureGame;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private int orjHealth;
    private String charName;
    private String name;
    Scanner input = new Scanner(System.in);
    private Inventory inventory;

    Player(String name){ // sadece name aldık çünkü diğerlerini oyuncuya seçtireceğiz!!
        this.name = name;
        this.inventory = new Inventory(name, damage);
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public int getdamage(){
       return damage + this.getInventory().getWeaponDamage();
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCharName(){
        return charName;
    }

    public void setCharName(String charName){
        this.charName = charName;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }




    public void selectChar(){

        Character [] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("################");

        for(int i = 0; i<charList.length; i++){
           System.out.println("ID: " + charList[i].getId() + "\t Character: " +charList[i].getName() + "\t Damage: " +charList[i].getdamage() + "\t Health: " + charList[i].getHealth() + "\t Money: " + charList[i].getMoney());
        }

        System.out.println("################");
        System.out.println("Please select character with ID number");
        System.out.println();
        int selectCharacter = input.nextInt();

        switch(selectCharacter){

            case 1: 
            initPlayer(new Samurai());//playerin özelliklerini samurai ile değişiyorum.
            break;
            case 2:
            initPlayer(new Archer()); // playerin özelliklerini archer ile değişiyorum.
            break;
            case 3:
            initPlayer(new Knight()); // playerin özelliklerini knight ile değişiyorum.
            break;

         }

       /*  System.out.println("Character of your choice => " + this.getCharName() + "\tDamage: " + this.getdamage() + "\tHealth: " + this.getHealth() + "\tMoney: " + this.getMoney()); 
         //Karakterlerin özelliklerini kullanıcının özelliklerine atamış olduk!!
        */
        }

        public void printInfo(){ // oyuncuya her seferinde bilgi veriyorum.
            System.out.println("Your Character Name => " + this.getCharName() + 
            "\tYour gun => " + this.getInventory().getWeaponName() + 
            "\tYour damage => " + this.getdamage() + 
            "\tYour health => " + this.getHealth() + 
            "\tYour money => "  + this.getMoney()  + 
            "\tYour armor => "  + this.getInventory().getArmorName() + 
            "\tYour block value => " + this.getInventory().getArmorBlock());
        }

    

        public void initPlayer(Character chr) {
            
            this.setDamage(chr.getdamage()); // characterdeki karakterlerin özellikleri buna gececek 
            this.setHealth(chr.getHealth()); // playerin saglıgı chardan cagırdıgım karakterin saglıgıyla degısecek
            this.setMoney(chr.getMoney()); //playerin money ı chardan aldıgım karakterin moneyı ıle degsıcek
            this.setCharName(chr.getName());
            this.setOrjHealth(chr.getHealth());

    }


    
}
