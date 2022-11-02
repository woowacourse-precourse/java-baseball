package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임에 쓰이는 메소드들을 정의한 클래스입니다.
 *
 * 1. 1부터 9까지 서로 다른 임의의 수 3개로 이루어진 '정답지'를 만들기
 * 2. 사용자의 답안이 맞는지 검증하는 로직 구현
 * 3. 프로그램의 종료 시점을 결정하는 로직 구현
 * 4. 예외적인 상황 처리(ex. 사용자의 잘못된 입력)
 */
public class NumberBaseball {
    /** 각각의 인스턴스를 구분할 수 있는 정보인 '정답'에 해당하는 리스트를 멤버로 갖도록 디자인했습니다. */
    private List<Integer> answer = new ArrayList<>();

    /** 생성자를 통해 랜덤한 1~9의 각기 다른 숫자 3개로 이루어진 리스트를 생성하도록 만들었습니다. */
    public NumberBaseball() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    /**
     * 정답 리스트를 반환하는 메소드
     *
     * @return answer
     */
    public List<Integer> getAnswer() {
        return answer;
    }
}