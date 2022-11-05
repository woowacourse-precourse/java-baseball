package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/*** 커밋 컨벤션
 * feat: 새로운 기능 추가
 * fix: 버그 수정
 * docs: 문서 수정
 * style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
 * refactor: 코드 리펙토링
 * test: 테스트 코드, 리펙토링 테스트 코드 추가
 * chore: 빌드 업무 수정, 패키지 매니저 수정
 */

/*** 구현해야 할 기능
 *
 * 잘못된 입력값에 대한 IllegalArgumentException 예외 처리
 */

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String restart = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart.equals("1")) {

            Game.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Console.readLine();
            if (!(restart.equals("2") && restart.equals("1"))) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }
}

