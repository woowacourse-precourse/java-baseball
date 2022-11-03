package baseball.controller;

import baseball.service.ResultService;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameStartController {
    public void GameStart() {
        ResultService result = new ResultService();

        int Restart = 1;
        while (Restart == 1) {
            List<Integer> RandomNumber = GetRandomNum();
            System.out.println("숫자 야구 게임을 시작하겠습니다.");
            Restart = result.ReOrClose(RandomNumber);
        }
        System.out.println("종료 되었습니다.");
    }

    private List<Integer> GetRandomNum() {
        List<Integer> GetNum = new ArrayList<>();
        while (GetNum.size() < 3) {
            int rdNum = Randoms.pickNumberInRange(1, 9);
            if (!GetNum.contains(rdNum)) {
                GetNum.add(rdNum);
            }
        }
        return GetNum;
    }
}