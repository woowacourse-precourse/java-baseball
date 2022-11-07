package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame();
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame() {
        GameStatus status = GameStatus.CONTINUE;
        do {
            if (isStopStatus(status)) {
                break;
            }
            if (isExceptionStatus(status)) {
                throw new IllegalArgumentException();
            }
            GameFormatter.gameStartMessage();
            String answer = initComputerAnswer();
            GameFormatter.gameInputMessage();
            GameFormatter.gameEndMessage();
            status = setGameStatus(Console.readLine());
        } while (true);
    }

    /**
     * 게임 진행 상황을 제어하는 함수
     *
     * @param input
     * @return GameStatus
     */
    GameStatus setGameStatus(String input) {
        GameStatus status;
        switch (input) {
            case "1":
                status = GameStatus.CONTINUE;
                break;
            case "2":
                status = GameStatus.STOP;
                break;
            default:
                status = GameStatus.EXCEPTION;
                break;
        }
        return status;
    }

    boolean isStopStatus(GameStatus status) {
        return status.equals(GameStatus.STOP);
    }

    boolean isExceptionStatus(GameStatus status) {
        return status.equals(GameStatus.EXCEPTION);
    }

    /**
     * 상대방(컴퓨터)가 1부터 9까지 셔플한 결과 중 3개를 뽑아 문자열로 반환
     * @return answer
     */
    String initComputerAnswer(){
        StringBuffer answer = new StringBuffer();
        // 1~9까지 숫자 중 shuffle 한 다음, 앞의 3개의 수를 반환
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        for(Integer uniqueNum : list){
            answer.append(uniqueNum);
        }
        return answer.toString();
    }

}
