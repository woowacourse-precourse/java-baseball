package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        // TODO: 프로그램 구현

        while(true){
            Game game = new Game();
            game.startGame(Console.readLine().split(""));
        }
    }
}
