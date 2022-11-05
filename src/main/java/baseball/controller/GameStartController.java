package baseball.controller;

import baseball.domain.RandomValue;
import baseball.service.ResultService;
import java.util.List;

public class GameStartController {
    public void GameStart() {

        ResultService resultService = new ResultService();
        RandomValue randomValue = new RandomValue();

        int restart = 1;

        while (restart == 1) {
            List<Integer> randomNumber = randomValue.getRandom();
            System.out.println("숫자 야구 게임을 시작하겠습니다.");
            restart = resultService.ReOrClose(randomNumber);
        }

        System.out.println("종료 되었습니다.");
    }
}