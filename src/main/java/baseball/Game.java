package baseball;

import java.util.List;

import static baseball.Functions.*;
import static baseball.UserInput.*;

public class Game {
    private final static String CONTINUE = "1";
    //private final static String END = "2";
    public static void start(){
        begin_message();
        do {
            play();
            end_message();
        } while (askContinue());
    }
    private static void play() {
        //랜덤숫자 생성
        List<Integer> targetNums = createTargetNums();
        mainGame(targetNums);
    }
    private static void mainGame(List<Integer> targetNums) {
        while (true) {
            List<Integer> userNums = stringToIntegerList(numberInput());
            List<Integer> ball_Strike = count_BallStrike(targetNums, userNums);
            printResult(ball_Strike);
            if (is3Strikes(ball_Strike))
                break;
        }
    }
    private static boolean askContinue() {
        cont_message();
        String input = continueInput();
        if (input.equals(CONTINUE)) {
            return true;
        }
        return false;
    }
    private static void begin_message(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static void end_message(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private static void cont_message(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
