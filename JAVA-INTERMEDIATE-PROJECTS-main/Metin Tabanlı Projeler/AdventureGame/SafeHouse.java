package AdventureGame;

public class SafeHouse extends NormalLoc {
    
    public SafeHouse(Player player){
        super(player, "Safe House",1); // Zaten güvenli evin ismi değişmeyecek direkt burada buranın ismini atadım.
    }


    @Override               
    public boolean onLocation() {         

      System.out.println("You are in the safe house. ");
      System.out.println("Your health is renewed. ");
      this.getPlayer().setHealth(this.getPlayer().getOrjHealth()); // playerın seçtiği oyuncunun canını orjJealthe atadım orjHealthi de player'ın healthına atadım.
      return true; 

    }

}
