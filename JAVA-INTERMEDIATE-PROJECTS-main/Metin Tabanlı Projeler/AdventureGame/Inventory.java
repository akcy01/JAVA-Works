package AdventureGame;

public class Inventory {

    private int weaponDamage;
    private String weaponName;

    private int armorBlock;
    private String armorName;

    private boolean water = false;
    private boolean firewood = false;
    private boolean food = false;
    private boolean ParaSilahZırh = false;
    
    public Inventory(String weaponName,int weaponDamage,int armorBlock,String armorName){
        this.weaponDamage = 0;
        this.weaponName = "Punch";

        this.armorBlock = 0;
        this.armorName = "Scrap";
    }

   

    public boolean isParaSilahZırh() {
        return ParaSilahZırh;
    }



    public void setParaSilahZırh(boolean paraSilahZırh) {
        this.ParaSilahZırh = paraSilahZırh;
    }



    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
       this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public Inventory(String name, int damage) {
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage){
        this.weaponDamage = weaponDamage;
    }

    public String getWeaponName(){
        return weaponName;
    }

    public void setWeaponName(String weaponName){
        this.weaponName = weaponName;
    }

    public int getArmorBlock(){
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock){
        this.armorBlock = armorBlock;
    }

    public String getArmorName(){
        return armorName;
    }

    public void setArmorName(String armorName){
        this.armorName = armorName;
    }

   
}
