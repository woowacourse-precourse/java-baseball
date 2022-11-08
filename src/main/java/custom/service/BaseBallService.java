package custom.service;

import camp.nextstep.edu.missionutils.Randoms;
import custom.dto.Response;
import custom.service.vo.ReTry;
import custom.service.vo.Score;
import custom.table.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallService {

    private final Table table;

    public BaseBallService(Table table) {
        this.table = table;
    }

    public Response init() {
        String number = makeUniqueRandomNumber();
        table.setNumber(number);
        return Response.keepOf("데이터 생성 완료");
    }

    public Response matchNumber(String input) {
        Score score = calculateScore(input);
        int scoreOfStrike = score.getScoreOfStrike();
        int scoreOfBall = score.getScoreOfBall();
        String message = generateMessage(scoreOfStrike, scoreOfBall);
        if (scoreOfStrike == 3) {
            return Response.retryOf(message);
        }
        return Response.keepOf(message);
    }

    public Response isKeepGo(ReTry reTry) {
        if (reTry.equals(ReTry.YES)) {
            return Response.keepOf("다시 시작");
        }
        return Response.endOf("종료");
    }

    private String makeUniqueRandomNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int temp = Randoms.pickNumberInRange(0, 9);
            if (list.contains(temp)) {
                continue;
            }
            list.add(temp);
        }
        return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }

    private Score calculateScore(String input) {
        int scoreOfStrike = 0;
        int scoreOfBall = 0;
        for (int i = 0; i < 3; ++i) {
            char number = input.charAt(i);
            if (number == table.get(i)) {
                scoreOfStrike += 1;
                continue;
            }
            if (table.contains(number)) {
                scoreOfBall += 1;
            }
        }
        return new Score(scoreOfStrike, scoreOfBall);
    }

    private String generateMessage(int scoreOfStrike, int scoreOfBall) {
        String ball = "";
        String strike = "";
        if (scoreOfBall == 0 && scoreOfStrike == 0) {
            return "낫싱";
        }
        if (scoreOfBall > 0) {
            ball = String.format("%d볼", scoreOfBall);
        }
        if (scoreOfStrike > 0) {
            strike = String.format("%d스트라이크", scoreOfStrike);
        }
        String answer = ball + " " + strike;
        return answer.trim();
    }
}
