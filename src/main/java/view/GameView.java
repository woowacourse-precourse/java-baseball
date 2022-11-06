package view;

import domain.BaseballNumbers;
import domain.RoundResult;

import java.util.List;

public class GameView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = BaseballNumbers.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage(){
        System.out.println(START_MESSAGE);
    }

    public static void printInputMessage(){
        System.out.println(INPUT_MESSAGE);
    }

    public static void printRoundResultMessage(RoundResult roundResult){
        System.out.println(roundResult.toString());
    }

    public static void printWinMessage(){
        System.out.println(WIN_MESSAGE);
    }
}
