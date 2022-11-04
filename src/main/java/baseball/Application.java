package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/***
 * feat: 새로운 기능 추가
 * fix: 버그 수정
 * docs: 문서 수정
 * style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
 * refactor: 코드 리펙토링
 * test: 테스트 코드, 리펙토링 테스트 코드 추가
 * chore: 빌드 업무 수정, 패키지 매니저 수정
 */

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Computer computer = new Computer(new ArrayList<>());
        computer.random3NumberOutput();

        Player player = new Player(new ArrayList<>());
        player.player3NumberInput();

        Integer ballCount = 0;
        Integer strikeCount = 0;

        strikeCount = strike(computer, player, strikeCount);
        ballCount = ball(computer, player, ballCount);

        resultOutput(ballCount, strikeCount);


    }

    private static void resultOutput(Integer ballCount, Integer strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private static Integer ball(Computer computer, Player player, int ballCount) {

        for (int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if (!computer.computerNumber.get(numericComparisonIndex).equals(player.playerNumber.get(numericComparisonIndex))) {
                ballCount = getBallCount(computer, player, ballCount, numericComparisonIndex);
            }
        }

        return ballCount;
    }

    private static int getBallCount(Computer computer, Player player, Integer ballCount, int numericComparisonIndex) {

        for (int playerNumberIndex = 0; playerNumberIndex < 3; playerNumberIndex++) {
            if (String.valueOf(computer.computerNumber.get(numericComparisonIndex)).contains(String.valueOf(player.playerNumber.get(playerNumberIndex)))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static Integer strike(Computer computer, Player player, Integer strikeCount) {

        for (int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if (computer.computerNumber.get(numericComparisonIndex).equals(player.playerNumber.get(numericComparisonIndex))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
