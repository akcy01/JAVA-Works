package AdventureGame;

import java.util.Scanner;

public abstract class Location { // bundan da bir şey üretilsin istemiyorum abstract yaptım o yüzden.
    
    private Player player;
    private String locName;
    private int id;
    protected Scanner input = new Scanner(System.in); // alt sınıflardan da erişilsin diye protected kullandım.

    public Location(Player player,String locName,int id){

        this.player = player;
        this.locName = locName;
        this.id = id; 

    }

    public abstract boolean onLocation(); // Bütün alt sınıflar bunu kullansın diye tanımladık. 


    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public String getLoc(){
        return locName;
    }

    public void setLoc(String locName){
        this.locName = locName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
