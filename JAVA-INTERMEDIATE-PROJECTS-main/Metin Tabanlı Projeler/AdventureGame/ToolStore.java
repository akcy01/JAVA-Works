package AdventureGame;


public class ToolStore extends NormalLoc{

    public ToolStore(Player player){
        super(player,"Tool Store",2);
    }

 
    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the TOOL STORE ! ");
        System.out.println("You can buy weapons or armor here ! ");
        System.out.println();
        System.out.println("1 - GUNS  ");
        System.out.println("2 - ARMORS  ");
        System.out.println("3 - EXIT  ");
        System.out.println();
        System.out.print("Your Choice => ");
        int selectAction = input.nextInt();
        
        switch(selectAction){
             case 1:
            printWeapon();
             break;

             case 2:
            printArmor();
             break;

             case 3:
             System.out.println("We are waiting for you again :)) ");
             return true;

        }

        return true;
    }


    public void printWeapon(){
        System.out.println("!!! GUNS !!!");
        System.out.println();
        selectWeapon();
        System.out.println();
        System.out.print("Please select a gun with ID => ");
        int selectGun = input.nextInt();

        switch(selectGun){
            case 1:
            if(new Pistol().getPrice() > this.getPlayer().getMoney()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new Pistol().getName() + " Silahını satın aldınız. ");
                int newMoney = this.getPlayer().getMoney() - new Pistol().getPrice();
                this.getPlayer().setMoney(newMoney); // Kullanıcının silahı aldıktan sonra kalan bakiyesini atadım.
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());
                //Şimdi artık silahın hasarını kullanıcı hasarına eklemem gerek bunun için inventory oluşturuyorum.
            
                // varsayılan gelen silahın ve o silahının hasarını satın alınan silahın adı ve hasarıyla değiştim.
                this.getPlayer().getInventory().setWeaponName(new Pistol().getName()); 
                this.getPlayer().getInventory().setWeaponDamage(new Pistol().getdamage());
                
            }
            break;

            case 2:

            if(new Sword().getPrice() > this.getPlayer().getMoney()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new Sword().getName() + " Silahını satın aldınız. ");
                int newMoney = this.getPlayer().getMoney() - new Sword().getPrice();
                this.getPlayer().setMoney(newMoney); // Kullanıcının silahı aldıktan sonra kalan bakiyesini atadım.
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());
                
                this.getPlayer().getInventory().setWeaponName(new Sword().getName()); 
                this.getPlayer().getInventory().setWeaponDamage(new Sword().getdamage());
                
            }
            break;

            case 3:

            if(new Rifle().getPrice() > this.getPlayer().getMoney()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new Rifle().getName() + " Silahını satın aldınız. ");
                int newMoney = this.getPlayer().getMoney() - new Rifle().getPrice();
                this.getPlayer().setMoney(newMoney); // Kullanıcının silahı aldıktan sonra kalan bakiyesini atadım.
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());
               
                this.getPlayer().getInventory().setWeaponName(new Rifle().getName()); 
                this.getPlayer().getInventory().setWeaponDamage(new Rifle().getdamage());
                
            }
            break;
        }
    
    }

    public void selectWeapon(){
        Weapon [] weaponlist = {new Pistol(),new Sword(),new Rifle()};
        System.out.println("############");

        for(int i = 0; i<weaponlist.length; i++){
            System.out.println("ID : " + weaponlist[i].getId() + "\tName : " + weaponlist[i].getName() + "\tDamage : " + weaponlist[i].getdamage()+ "\tPrice : " + weaponlist[i].getPrice());
        }
    }

    public void printArmor(){
        System.out.println("^^^^ ARMORS ^^^^");
        System.out.println();
        selectArmor();
        System.out.println();
        System.out.println("Please select a armor with ID ! ");
        int selectArmor = input.nextInt();

        switch(selectArmor){
            case 1:
            if(getPlayer().getMoney() < new LightArmor().getPrice()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new LightArmor().getName() + " Zırhını satın aldınız ! ");
                int newMoney =  getPlayer().getMoney() - new LightArmor().getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());

                this.getPlayer().getInventory().setArmorName(new LightArmor().getName());
                this.getPlayer().getInventory().setArmorBlock(new LightArmor().getBlock());

            }
                 break;

            case 2:
            if(new MediumArmor().getPrice() > getPlayer().getMoney()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new MediumArmor().getName() + " Zırhını satın aldınız ! ");
                int newMoney =  getPlayer().getMoney() - new MediumArmor().getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());

                this.getPlayer().getInventory().setArmorName(new MediumArmor().getName());
                this.getPlayer().getInventory().setArmorBlock(new MediumArmor().getBlock());
            }
            break;

            case 3:
            if(new HeavyArmor().getPrice() > getPlayer().getMoney()){
                System.out.println("You do not have enough funds. ");
            }else{
                System.out.println(new HeavyArmor().getName() + " Zırhını satın aldınız ! ");
                int newMoney =  getPlayer().getMoney() - new HeavyArmor().getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Your remaining balance => " + this.getPlayer().getMoney());

                this.getPlayer().getInventory().setArmorName(new HeavyArmor().getName());
                this.getPlayer().getInventory().setArmorBlock(new HeavyArmor().getBlock());

            }
            break;
        }
    }

    public void selectArmor(){
        Armor [] armorlist = {new LightArmor(),new MediumArmor(),new HeavyArmor()};
        System.out.println("###########");

        for(int i = 0; i<armorlist.length; i++){
            System.out.println("ID : " + armorlist[i].getId() + "\tName : " + armorlist[i].getName() + "\tBlock : " + armorlist[i].getBlock() + "\t Price : " + armorlist[i].getPrice());
        }
    }

}
