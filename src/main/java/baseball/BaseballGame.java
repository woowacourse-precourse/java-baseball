package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BaseballGame {
    private List<Integer> computer;
    private List<Integer> player;
    private void initComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private void initPlayer() {
        player = new ArrayList<>(Arrays.asList(0, 0, 0));
    }
    private void initGame() {
        initComputer();
        initPlayer();
    }
    public void play() {
        //TODO: 게임 초기화
        initGame();

        // TODO: 게임 진행
        //TODO: 결과 분석 및 결과에 따른 행동 수행 요구

    }
}