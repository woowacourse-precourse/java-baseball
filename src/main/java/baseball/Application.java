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

        List ballIndex = new ArrayList<Integer>();
        int ballCount = 0;
        List strikeIndex = new ArrayList<Integer>();
        int strikeCount = 0;

        strike(computer, player, strikeIndex, strikeCount);


    }

    private static void strike(Computer computer, Player player, List strikeIndex, int strikeCount) {
        for(int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if(computer.computerNumber.get(numericComparisonIndex) == player.playerNumber.get(numericComparisonIndex)) {
                strikeCount++;
                strikeIndex.add(numericComparisonIndex);
            }
        }
    }
}
