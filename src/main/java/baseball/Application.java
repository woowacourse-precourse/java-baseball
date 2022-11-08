package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 기능 목록
 *  - executionGame : 하나의 게임 단위
 *  - continueGame :  게임을 새로 시작할지 종료할지 결정하는 함수
 *  - decision : 서로 다른 3개의 랜덤 수 저장
 *  - validationAndConvert : 입력에 대한 검증과 List<Integer>로 반환
 *  - calculationBall : 볼 계산
 *  - calculationStrike : 스트라이크 계산
 *  - currentSituation : 입력에 대한 결과를 문자열 형태로 반환
 *  - isCorrect : 정답을 맞추었는지
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}