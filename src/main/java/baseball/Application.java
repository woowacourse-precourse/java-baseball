package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private void start_game() {
        // 기능 요구사항 1번
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private List<Integer> make_RandomNum(int maxLength) {
        // 기능 요구사항 2번
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < maxLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    private void input_PlayerNum() {
        // 기능 요구사항 3번
    }

    private void get_BallAndStrikeCount() {
        // 기능 요구사항 4번
    }

    private void progress_GameRule() {
        // 기능 요구사항 5번
    }

    private void close_game() {
        // 기능 요구사항 6번
    }

    private void play() {
        start_game();

        int maxLength = 3;
        List<Integer> computerNum = make_RandomNum(maxLength);

        input_PlayerNum();
        get_BallAndStrikeCount();
        progress_GameRule();
        close_game();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.play();

    }
}
