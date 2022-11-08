package utils;

import static utils.OutputUtil.GameMessage.*;
import static utils.OutputUtil.GameMessage.GAME_START;

public class OutputUtil {

    private OutputUtil(){
    }

    public static void printGameStart(){
        System.out.println(GAME_START.getMessage());
    }

    public static void printTryCorrect(){
        System.out.print(TRY_CORRECT.getMessage());
    }

    public static void printGameEnd(){
        System.out.println(GAME_END.getMessage());
    }

    public static void printRetryGame(){
        System.out.print(RETRY_GAME.getMessage());
    }

    public enum GameMessage {

        GAME_START("숫자 야구 게임을 시작합니다."),
        TRY_CORRECT("숫자를 입력해주세요 : "),
        GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        RETRY_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        ;

        private final String message;

        GameMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
