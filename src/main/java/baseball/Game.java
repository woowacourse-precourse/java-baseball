package baseball;

public class Game {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final Computer computer = new Computer();
    private static final User user = new User();
    private static Status status = Status.Playing;

    public void start() {
        System.out.println(START_MSG);
        //테스트용 출력
        System.out.println(computer);

        while (status == Status.Playing) {
            user.scanUserNums();
            countResult();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void countResult() {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < 3; i++) {
            int cpNum = computer.getNums().get(i);
            int userNum = user.getNums().get(i);

            if (cpNum == userNum) strikeCnt++;
            else if (user.getNums().contains(cpNum)) ballCnt++;
        }

        System.out.println(showResult(ballCnt, strikeCnt));
        if(strikeCnt==3)status=Status.End;
    }

    private String showResult(int ballCnt, int strikeCnt) {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) return result.append("낫싱").toString();

        if (ballCnt > 0) result.append(ballCnt).append("볼 ");
        if (strikeCnt > 0) result.append(strikeCnt).append("스트라이크 ");
        return result.toString().trim();
    }


}
