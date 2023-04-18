package AdventureGame;


import java.util.Random;


public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    
    public BattleLoc(Player player, String locName,int id,Obstacle obstacle,String award,int maxObstacle) {

        super(player, locName,id );
        this.obstacle = obstacle;
        this.award = award;
        this.setMaxObstacle(maxObstacle);

    }


    public int getMaxObstacle() {
        return maxObstacle;
    }


    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


    public String getAward() {
        return award;
    }


    public void setAward(String award) {
        this.award = award;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }


    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


    @Override
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();

        if(this.getAward() == "Food"){
            if(this.getPlayer().getInventory().isFood()==true){
                System.out.println("You already got the prize here.");
                return true;
            }
        }
        else if(this.getAward() == "firewood"){
            if(this.getPlayer().getInventory().isFirewood()==true){
                System.out.println("You already got the prize here.");
                return true;
            }
        }
        else if(this.getAward() == "Water"){
            if(this.getPlayer().getInventory().isWater()==true){
                System.out.println("You already got the prize here.");
                return true;
            }
            
        }

        System.out.println("You are here now => " + this.getLoc());
        System.out.println("Be careful!! " + obsNumber + " of the " + this.getObstacle().getName() + " live here !! ");
        System.out.println("Click ' S ' to fight ! && Click ' K ' to run !");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();//Küçük s'ye de tıklasa onu büyüğe çevirmesi için yaptım.
        if(selectCase.equals("S")){
            System.out.println("LET THE WAR BEGIN  !!!");
            if(combat(obsNumber)){
               
                System.out.println(" YOU DEFEAT ALL ENEMIES!  ");
                System.out.println(this.getLoc() + " for clearing all the enemies in your location  " + this.getAward() + " you have added the reward to your inventory.  ");

		        if(getAward() == "Food"){
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println();
                }
                else if(getAward() == "firewood"){
                    this.getPlayer().getInventory().setFirewood(true);
                }
                else if(getAward() == "Water"){
                    this.getPlayer().getInventory().setWater(true);
                }
                else if(getAward() == "Para/Silah/Zırh")
                    this.getPlayer().getInventory().setParaSilahZırh(true);
                return true;
                
            }
        }

        if(this.getPlayer().getHealth() <= 0 ){
            System.out.println("You are died ! ");
            System.out.println(this.getLoc() + " because you can't clear all the enemies in your location  " + this.getAward() + " You could not add the reward to your inventory. ");
            return false;
        }

        return true;
    }

    public int randomObstacleNumber(){
        Random r = new Random(); // 1 ile 3 arasında bir değer üretmesini istediğim için bu sınıfı kullandım.

        return r.nextInt(this.getMaxObstacle()) + 1 ;//+ 1'i koyma sebebim rastgele sayının 0 olmaması ve 3 değerini de getirebilmesi.
    }

    public boolean combat(int obsNumber){
         for(int i = 1; i<=obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjhealth()); //bir canavarı öldürdükten sonra diğerine sıra geldiğinde diğer canavarın canının full olması için bunu yaptım.
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth()> 0 && this.getObstacle().getHealth() > 0){
                System.out.println("Press 'V' key to hit && Press 'K' key to run " );
                String selectCombat = input.nextLine();
                selectCombat = selectCombat.toUpperCase();

                if(selectCombat.equals("V")){
                    System.out.println("You hit !! ");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getdamage());
                    afterHit();

                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " HIT!! ");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmorBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else{
                    return false;
                    }   

                }
                if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                    if(getAward()=="Para/Silah/Zırh"){
                        System.out.println("YOU KILLED THE SNAKE");

                        DusenItem();

                    }else if(getAward()=="Food" || getAward()=="firewood" || getAward() =="Water"){
                        System.out.println(" You killed the monster! ");
                        System.out.println(this.getObstacle().getAward() + " made money !!");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                        System.out.println("Your current money => " + this.getPlayer().getMoney());
                    }
                   
                }else{
                    return false;
                }
                   
            }
             return true;
     }

    public void afterHit(){
        System.out.println("Your health => " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Health => " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats(){

        System.out.println("-----Player values-----");
        System.out.println("---------------------------");
        System.out.println("Health => " + this.getPlayer().getHealth());
        System.out.println("Gun => " + this.getPlayer().getInventory().getWeaponName());
        System.out.println("Damage => " + this.getPlayer().getdamage());
        System.out.println("Armor => " + this.getPlayer().getInventory().getArmorName());
        System.out.println("Blocking => " + this.getPlayer().getInventory().getArmorBlock());
        System.out.println("Money => " + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i){

        System.out.println("-----Monster Values-----");
        System.out.println("---------------------------");
        System.out.println("Health => " + this.getObstacle().getHealth());
        System.out.println("Damage => " + this.getObstacle().getDamage());
        System.out.println("Award => " + this.getObstacle().getAward());

    }

    // HER BİR YILAN ÖLDÜĞÜNDE DÜŞEN İTEMLERİ YAZIYORUM

    public void DusenItem(){
        
    Random rastgele = new Random();
    int rastgeleSayi = rastgele.nextInt(100)+1;

    if(rastgeleSayi<=15){

        int randomWeapon = rastgele.nextInt(100)+1;

            if(randomWeapon <=20){
                System.out.println("You earned a pistol from this snake you killed.");
                this.getPlayer().getInventory().setWeaponName("Rifle");
                this.getPlayer().getInventory().setWeaponDamage(7);
            }

            if(randomWeapon >20 && randomWeapon <= 50){
                System.out.println("You earned a sword from this snake you killed.");
                this.getPlayer().getInventory().setWeaponName("Sword");
                this.getPlayer().getInventory().setWeaponDamage(3);
        }
            if(randomWeapon >50 && randomWeapon <=100){
                System.out.println("You earned a rifle from this snake you killed");
                this.getPlayer().getInventory().setWeaponName("Pistol");
                this.getPlayer().getInventory().setWeaponDamage(2);
            }

    }else if(rastgeleSayi > 15 && rastgeleSayi <= 30){

        int randomArmor = rastgele.nextInt(100)+1;

        if(randomArmor <= 20){
            this.getPlayer().getInventory().setArmorName("Heavy");
            this.getPlayer().getInventory().setArmorBlock(5);
            System.out.println("You earned the heavy armor from the victim you killed.");
        }

         if(randomArmor >20 && randomArmor <= 50){
            this.getPlayer().getInventory().setArmorName("Middle");
            this.getPlayer().getInventory().setArmorBlock(3);
            System.out.println("You earned the middle armor from the victim you killed.");
        }

        if(randomArmor > 50 && randomArmor <= 100){
            this.getPlayer().getInventory().setArmorName("Light");
            this.getPlayer().getInventory().setArmorBlock(1);
            System.out.println("You earned the light armor from the victim you killed.");
        }


    }else if(rastgeleSayi > 30 && rastgeleSayi <= 55){
        int randomMoney = rastgele.nextInt(100)+1;
        int balace = this.getPlayer().getMoney();

        if(randomMoney<=20){
            this.getPlayer().setMoney(balace + 10);
            System.out.println("You earned 10 coins from the snake you killed.");
        }
        if(randomMoney > 20 && randomMoney <= 50){
            this.getPlayer().setMoney(balace+5);
            System.out.println("You earned 5 coins from the snake you killed.");
        }
        if(randomMoney > 50 && randomMoney <= 100){
            this.getPlayer().setMoney(balace+1);
        }

    }

    else if(rastgeleSayi> 55 && rastgeleSayi <=100){
          // the player wont recieve any thing for kinlling the monster
         // because the randomPrize is bitween (55,100]
    }
  
 }

}


