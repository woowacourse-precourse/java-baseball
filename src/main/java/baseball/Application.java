package baseball;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException, IllegalArgumentException{
        // TODO: 프로그램 구현

        ComputerNum computer = new ComputerNum();
        Init_game init = new Init_game();
        Compare compare = new Compare();
        Retry retry = new Retry();

        boolean again = true;

        while(again) {
            List<Integer> com_num = computer.ComputerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(com_num, init.player_num());
                System.out.println(result);
            }

            again = retry.retry();
        }
    }
}
