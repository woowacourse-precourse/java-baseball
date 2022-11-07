package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameView {


    public static void startGame() {
        // TODO: 프로그램 구현

        boolean result = true;
//        Game();
//        if (result){
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        }

        while(result){
            result = Game();
        }
    }



    public static boolean Game() {
        boolean result = true;
        BaseballGame baseballGame = new BaseballGame();
        InputException inputException = new InputException();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNumber = baseballGame.StringToIntList(input);
        System.out.println(input);

        baseballGame.strikeBallOut(inputNumber);
        result = baseballGame.checkResult();
        return result;
    }


}
