package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자야구 게임을 시작합니다.");
        Referee.refereeResult();
        if (gameContinue() == true) {
            User.inputUserNumber();
        } else if (gameContinue() == false) {
            System.out.println("게임을 종료합니다.");
        }
    }
    private static boolean gameContinue(){
        String input = readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력해 주세요.");
    }
}
