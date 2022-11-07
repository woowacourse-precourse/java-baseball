package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    private static final String _start_msg = "숫자 야구 게임을 시작합니다.\n";
    private static final String _input_msg = "숫자를 입력해주세요 : ";
    private static final String _correct_msg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String _end_msg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static void main(String[] args) {
        Game game = new Game();
        List<Integer> comp, userInput, result;
        boolean isEnd;

        System.out.print(_start_msg);

        while (true) {
            isEnd = false;
            comp = game.generateRandomValue();
            while (!isEnd) {
                System.out.print(_input_msg);
                userInput = game.readInputForGame();
                result = game.getResult(userInput, comp);
                game.printHint(result);
                isEnd = game.isGameEnd(result);
            }
            System.out.print(_correct_msg + _end_msg);
            if (game.readIsQuit()) {
                break;
            }
        }
    }
}
