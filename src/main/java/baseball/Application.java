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
        System.out.print("숫자를 입력해주세요 : ");
        String playerNum_string = Console.readLine();
        if (check_PlayerNum(playerNum_string, maxLength)) {
            String[] playerNum_array = playerNum_string.split("");
            return new ArrayList<>(Arrays.asList(playerNum_array));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean check_PlayerNum(String num, int maxLength) {
        String[] check_array = num.split("");
        HashSet<String> check_set = new HashSet<>(Arrays.asList(check_array));
        return !num.isEmpty() && num.matches("^[1-9]*$") && num.length() == maxLength
                && check_set.size() == num.length();

    }

    private int[] get_BallAndStrikeCount(List<String> computer, List<String> player) {
        // 기능 요구사항 4번
        int ballCnt = find_BallCount(computer, player);
        int strikeCnt = find_StrikeCount(computer, player);

        return new int[]{ballCnt, strikeCnt};

    }

    private int find_BallCount(List<String> computer, List<String> player) {
        int ballCnt = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(player.get(i)) && !computer.get(i).equals(player.get(i))) {
                ballCnt += 1;
            }
        }
        return ballCnt;
    }

    private int find_StrikeCount(List<String> computer, List<String> player) {
        int StrikeCnt = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                StrikeCnt += 1;
            }
        }
        return StrikeCnt;
    }

    private boolean progress_GameRule(int[] ballAndStrikeCount) {
        // 기능 요구사항 5번
        int ballCnt = ballAndStrikeCount[0];
        int strikeCnt = ballAndStrikeCount[1];
        boolean recycle_flag = true;

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 3) {
            System.out.println("3스트라이크");
            recycle_flag = false;
        } else {
            if (ballCnt == 0 && strikeCnt > 0 && strikeCnt < 3) {
                System.out.printf("%d스트라이크\n", strikeCnt);
            } else if (ballCnt > 0 && ballCnt < 4 && strikeCnt == 0) {
                System.out.printf("%d볼\n", ballCnt);
            } else {
                System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
            }
        }

        return recycle_flag;
    }

    private boolean is_Close() {
        // 기능 요구사항 6번
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selectEnd = Console.readLine();
        if (selectEnd.equals("1")) {
            return false;
        } else if (selectEnd.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }

    }

    private void play() {
        start_game();
        while (true) {
            int maxLength = 3;
            List<String> computerNum = make_RandomNum(maxLength);
            eachGame(maxLength,computerNum);
            if (is_Close()) {
                break;
            }

        }
    }

    private void eachGame(int maxLength, List<String> computerNum) {
        while (true) {
            List<String> playerNum = input_PlayerNum(maxLength);

            int[] ballAndStrikeCount = get_BallAndStrikeCount(computerNum, playerNum);

            boolean recycle_flag = progress_GameRule(ballAndStrikeCount);
            if (!recycle_flag) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }

    public static void main(String[] args) {
        Application application = new Application();
        application.play();
        System.out.println("게임 종료");
    }
}
