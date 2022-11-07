package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private static final String START_ANNOUNCE = "숫자 야구 게임을 시작합니다.";

    private Player player;
    private Referee referee;

    protected List<Integer> answer = new ArrayList<>();

    public Game(Player player, Referee referee) {
        this.player = player;
        this.referee = referee;
        initProcess();
    }

    public void initAnswer() {
        answer.clear();

        for (int i = 0; i < 3; i++) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }

        if (isDuplicated(answer)) {
            initAnswer();
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void play() {
        List<Integer> userAnswer = player.askNumbers();
        player.announce(referee.judge(answer, userAnswer));
        if (referee.isEnd()) {
            doWantRegame();
        }
    }

    public void doWantRegame() {
        if (player.askRegame()) {
            initProcess();
        }
    }

    public void run() {
        while (referee.isPlaying()) {
            play();
        }
    }

    private void initProcess() {
        this.initAnswer();
        player.announce(START_ANNOUNCE);
        referee.playGame();
    }

    private boolean isDuplicated(List<Integer> answer) {
        return answer.size() != new HashSet<>(answer).size();
    }
}
