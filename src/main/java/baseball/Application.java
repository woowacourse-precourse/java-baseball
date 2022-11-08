package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현

        Computer computer = new Computer();

        while (true) {
            computer.startGame();
            computer.playGame();
            if(computer.checkFinish()) break;
        }
    }






}
