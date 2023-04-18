package AdventureGame;

public class Obstacle {

    private String name;
    private int id;
    private int damage;
    private int health;
    private int orjhealth;
    private int award;

  public Obstacle(String name,int id,int damage,int health,int award){

        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.setOrjhealth(health);

    }
   
    public int getOrjhealth() {
    return orjhealth;
}

public void setOrjhealth(int orjhealth) {
    this.orjhealth = orjhealth;
}

    public int getAward() {
    return award;
}

public void setAward(int award) {
    this.award = award;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }
    
}
