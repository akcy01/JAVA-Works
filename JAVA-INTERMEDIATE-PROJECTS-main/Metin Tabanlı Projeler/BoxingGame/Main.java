package Classes.BoxingGame;

public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Tony Ferguson",30,200,70,25);
        Fighter f2 = new Fighter("Conor Mcgregor",50,100,70,45);

        Match match = new Match(f1,f2,68,73);
        match.run();
    }

}
