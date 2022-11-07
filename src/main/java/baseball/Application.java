package baseball;


public class Application {

    public static void main(String[] args) {
        InGame game = new InGame();
        Computer comp = new Computer();
        comp.printStartJavaBaseball();
        game.afterGameStart();
    }


}


