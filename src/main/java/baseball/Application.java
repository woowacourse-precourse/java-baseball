package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {
    private void start_game() {
        // 기능 요구사항 1번
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private List<String> make_RandomNum(int maxLength) {
        // 기능 요구사항 2번
        List<String> computerNum = new ArrayList<>();
        while (computerNum.size() < maxLength) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    private List<String> input_PlayerNum(int maxLength) {
        // 기능 요구사항 3번
        String playerNum_string = Console.readLine();
        if (check_PlayerNum(playerNum_string, maxLength)) {
            String[] playerNum_array = playerNum_string.split("");
            return new ArrayList<>(Arrays.asList(playerNum_array));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean check_PlayerNum(String num,int maxLength) {
        String[] check_array = num.split("");
        HashSet<String> check_set = new HashSet<>(Arrays.asList(check_array));
        return !num.isEmpty() && num.matches("^[1-9]*$") && num.length() == maxLength
                && check_set.size() == num.length();

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
        while (true) {
            int maxLength = 3;
            List<String> computerNum = make_RandomNum(maxLength);

            List<String> playerNum = input_PlayerNum(maxLength);

            get_BallAndStrikeCount();
            progress_GameRule();
            close_game();
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.play();
    }
}
