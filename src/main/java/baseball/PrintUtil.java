package baseball;

import javax.swing.text.Utilities;

public class PrintUtil {
    DataProcessing dataProcessing = new DataProcessing();
    private static final String STARTGAME = "숫자 야구 게임을 시작합니다.";
    private static final String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUTNUMBER = "숫자를 입력해주세요 : ";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String THREESTRIKE = "3스트라이크";
    private static final String NOTHING = "낫싱";
    public void printStartGame() {
        System.out.println(STARTGAME);
    }
    public void printEndGame() {
        System.out.println(ENDGAME);
    }
    public void printInputNumber() { System.out.print(INPUTNUMBER); }
    public void printRestart() { System.out.println(RESTART); }
    public void printThreeStrike() { System.out.println(THREESTRIKE); }
    public void printNoting() { System.out.println(NOTHING); }
}