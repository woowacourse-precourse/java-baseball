package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHECKING_REPLAYING_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int ballSize = 3;

    private Computer computer;
    private User user;
    private Status status;

    public Game() {
        computer = new Computer();
        user = new User();
        status = Status.Playing;
    }

    public void start() {
        System.out.println(START_MSG);
        //테스트용 출력
        System.out.println(computer);

        while (status == Status.Playing) {
            user.scanUserNums();
            countResult();
        }

        System.out.println(GAME_FINISH_MSG);
        if (checkingReplaying()) {
            restart();
        }
    }

    private void restart() {
        status = Status.Playing;
        computer.setRandNums();
        start();
    }

    private boolean checkingReplaying() {
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == 1) return true;
        else if (userStatus == 2) return false;
        else throw new IllegalArgumentException();
    }

    private void countResult() {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < ballSize; i++) {
            int cpNum = computer.getNums().get(i);
            int userNum = user.getNums().get(i);

            if (cpNum == userNum) strikeCnt++;
            else if (user.getNums().contains(cpNum)) ballCnt++;
        }

        System.out.println(showResult(ballCnt, strikeCnt));
        if (strikeCnt == ballSize) status = Status.End;
    }

    private String showResult(int ballCnt, int strikeCnt) {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) return result.append("낫싱").toString();

        if (ballCnt > 0) result.append(ballCnt).append("볼 ");
        if (strikeCnt > 0) result.append(strikeCnt).append("스트라이크 ");
        return result.toString().trim();
    }


}
