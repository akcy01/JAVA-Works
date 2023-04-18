package AdventureGame;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in); //Private kullandım çünkü bunu sadece bu sınıfta kullancam
    
    public void Start(){

        System.out.println("Welcome the Adventure Game !! ");
        System.out.println("Please create a Player Name ");
        String playerName = input.nextLine();
        Player player = new Player(playerName); // adı aldık ve player sınıfındaki name nesnesinin içine attık
        System.out.println(" Dear " + player.getName() + " welcome to this dark island ");
        System.out.println(" Here are our characters  !");
        player.selectChar();
        
        while(true){
            player.printInfo();
            System.out.println();
            Location location = null;
            Location [] loclist = {new SafeHouse(null),new ToolStore(null),new Cave(null),new Forest(null),new River(null),new Quarry(null)};

            System.out.println("######### REGIONS #########");
            System.out.println();

            for( int i = 0; i<loclist.length; i++){
                System.out.println("ID : " + loclist[i].getId() + "\t Location : " + loclist[i].getLoc());
            }
            System.out.println();
            System.out.println("Please select location with ID ! ");
            int selectLocation = input.nextInt();

            switch(selectLocation){
                case 1: 
                location = new SafeHouse(player); 
                break;
                case 2:
                location = new ToolStore(player);
                break;
                case 3:
                location = new Cave(player);
                break;
                case 4:
                location = new Forest(player);
                break;
                case 5:
                location = new River(player);
                break;
                case 6:
                location = new Quarry(player);
                break;
                default:
                location = new SafeHouse(player);
            }

            

           // location.onLocation(); switch çalıştıktan sonra override ettiğim metot gelecek.

            if(!location.onLocation()){//onLocation'ın false dönmesi demek oyunu kaybetti demek..
                System.out.println("  GAME OVER !! :((( ");
                break;
            }
            
            if(player.getInventory().isFood()==true && player.getInventory().isFirewood()== true && player.getInventory().isWater()==true && player.getInventory().isParaSilahZırh()){
                System.out.println("!!! YOU WIN THE GAME CONGRATULATIONS !!!");
                break;
            }

        }
    }

}
