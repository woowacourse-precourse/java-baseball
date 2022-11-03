package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    /**
     * 사용자의 답 중 정답과 값이 같은 숫자의 개수를 반환해주는 메소드입니다.
     *
     * @param userAnswer -> 사용자가 입력한 답
     * @return containCount -> 정답과 값이 같은 숫자의 개수
     */
    public int getContainCount(String userAnswer) {
        int containCount = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = Integer.parseInt(userAnswer.substring(i, i+1));

            if (answer.contains(userDigit)) {
                containCount += 1;
            }
        }

        return containCount;
    }

    /**
     * 사용자의 답 중 정답과 위치와 값이 모두 같은 숫자의 개수를 반환해주는 메소드입니다.
     *
     * @param userAnswer -> 사용자가 입력한 답
     * @return strikeCount -> 정답과 위치와 값이 모두 같은 숫자의 개수
     */
    public int getStrikeCount(String userAnswer) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = Integer.parseInt(userAnswer.substring(i, i+1));

            if (answer.get(i).equals(userDigit)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    /**
     * 사용자의 답안이 정답인지 확인하는 메소드
     *
     * 1. 먼저 '겹치는 숫자의 개수' 검사
     * 2. 0보다 크면 -> 스트라이크 검사 후 '스트라이크 개수' 만큼 '겹치는 숫자의 개수'에서 제거
     *    0이면 -> 낫싱 처리
     * 3. 결과 리스트 [ballCount, strikeCount, nothingFlag] 반환
     *
     * @param userAnswer -> 사용자가 입력한 답
     * @return result -> 결과 리스트 [ballCount, strikeCount, nothingFlag]
     */
    public List<Integer> checkAnswer(String userAnswer) {
        List<Integer> result = new ArrayList<>();
        int ballCount = 0;
        int strikeCount = 0;
        int nothingFlag = 0;

        int containCount = getContainCount(userAnswer);

        if (containCount > 0) {    // 겹치는 숫자가 한 개 이상인 경우 -> 스트라이크 검사
            strikeCount = getStrikeCount(userAnswer);
        } else {    // 겹치는 숫자가 아무것도 없는 경우
            nothingFlag = 1;
        }

        ballCount = containCount - strikeCount;

        result.add(ballCount);
        result.add(strikeCount);
        result.add(nothingFlag);

        return result;
    }

    /**
     * 사용자의 입력한 답에 대한 결과를 화면에 출력해주는 메소드
     *
     * @param result -> [ballCount, strikeCount, nothingFlag]
     */
    public void showResult(List<Integer> result) {
        int ballCount = result.get(0);
        int strikeCount = result.get(1);
        int nothingFlag = result.get(2);

        if (nothingFlag == 0) {
            if (strikeCount == 0 && ballCount != 0) {
                System.out.println(ballCount + "볼");
            } else if (strikeCount != 0 && ballCount == 0) {
                System.out.println(strikeCount + "스트라이크");
            } else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
        } else {
            System.out.println("낫싱");
        }
    }

    /**
     * 하나의 게임 단위를 실행하는 메소드
     */
    public void startGame() {
        Scanner sc = new Scanner(System.in);    /** 이 부분 Console.readLine()으로 바꿔야 함*/

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(getAnswer());    /** 이 부분은 추후에 제거해야 함*/

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = sc.nextLine();  /** 이 부분 Console.readLine()으로 바꿔야 함*/

            List<Integer> result = checkAnswer(userAnswer);
            showResult(result);

            if (result.get(1) == 3) {   // 3 strike인 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}