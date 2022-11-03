package baseball;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

// -

public class Application {
    public static void main(String[] args) {
        String readLine = Console.readLine();

        Player player = new Player();
        List<Integer> input = player.getInput(readLine);



    }
}
