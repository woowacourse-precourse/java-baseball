package baseball.player;


import camp.nextstep.edu.missionutils.Console;

public class Player {

    /**
     * 응답하는 기능
     */
    public String answerToProblem() {
        return Console.readLine();
    }

    /**
     * 플레이어가 재시작할지 종료할지 응답하는 기능
     */
    public String restartOrExit() {
        return Console.readLine();
    }
}
