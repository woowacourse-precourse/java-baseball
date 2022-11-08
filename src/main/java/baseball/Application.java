package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    // 1.상대 숫자 생성
    static void getSettingComputerNumber(List<Integer> computerNumber) {

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    // 2. 숫자 입력 기능
    static void getSettingGuessingNumber(List<Integer> guessingNumber) {

        System.out.print("숫자를 입력해주세요 : ");

        String strNumber = Console.readLine();

        System.out.println(strNumber);

        for (int idx = 0; idx < strNumber.length(); idx++) {
            int intNumber = Character.getNumericValue(strNumber.charAt(idx));
            guessingNumber.add(intNumber);
        }
    }

    // 3.낫싱 판단
    static void checkNoting(List<Integer> computerNumber, List<Integer> guessingNumber, List<Integer> numberCheckCount) {

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessingNumber.get(idx);
            if (computerNumber.contains(checkNumber)) {
                numberCheckCount.add(0);
                return;
            }
        }

        numberCheckCount.add(1);
    }

    // 4.볼 판단
    static void checkBall(List<Integer> computerNumber, List<Integer> guessingNumber, List<Integer> numberCheckCount) {

        int ballCount = 0;

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessingNumber.get(idx);

            if (computerNumber.contains(checkNumber) && checkNumber != computerNumber.get(idx)) {
                ballCount += 1;
            }
        }

        numberCheckCount.add(ballCount);
    }

    // 5.스트라이크 판단
    static void checkStrike(List<Integer> computerNumber, List<Integer> guessingNumber, List<Integer> numberCheckCount) {

        int strikeCount = 0;

        for (int idx = 0; idx < 3; idx++) {
            int checkNumber = guessingNumber.get(idx);
            if (computerNumber.contains(checkNumber) && checkNumber == computerNumber.get(idx)) {
                strikeCount += 1;
            }
        }

        numberCheckCount.add(strikeCount);
    }

    // 6.숫자 판단 결과
    static int getNoticeResult(List<Integer> numberCheckCount) {

        // 각 결과 수
        int nCount = numberCheckCount.get(0);
        int bCount = numberCheckCount.get(1);
        int sCount = numberCheckCount.get(2);

        String noticeResult = "";

        // 낫싱인 경우
        if (nCount == 1) {
            System.out.println("낫싱");
            return -1;
        }

        // 볼이 있는 경우
        if (bCount > 0) {
            noticeResult = bCount + "볼" + " ";
        }

        // 스트라이크가 있는 경우
        if (sCount > 0) {
            noticeResult = noticeResult + sCount + "스트라이크";
            System.out.println(noticeResult);

            // 모두 맞힌 경우
            if (sCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return 1;
            }
        }

        System.out.println(noticeResult);
        return -1;
    }

    // 8.결과 처리
    static String getCheckRestart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String selectNumber = Console.readLine();

        System.out.println(selectNumber);

        return selectNumber;
    }

    public static void main(String[] args) {

        String restart = "";

        while (true) {

            // 종료 조건
            if(restart.equals("2")) {
                System.out.println("게임 종료");
                return;
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computerNumber = new ArrayList<>();

            int gameResult = 0;

            // 상대 숫자 생성 함수 호출
            getSettingComputerNumber(computerNumber);

            // 7.게임 진행 반복
            while (gameResult != 1) {

                List<Integer> guessingNumber = new ArrayList<>();
                List<Integer> numberCheckCount = new ArrayList<>();

                // 숫자 입력 함수 호출
                getSettingGuessingNumber(guessingNumber);

                // 낫싱 판단 함수 호출
                checkNoting(computerNumber, guessingNumber, numberCheckCount);

                // 볼 판단 함수 호출주석 제거
                checkBall(computerNumber, guessingNumber, numberCheckCount);

                // 스트라이크 판단 함수 호출
                checkStrike(computerNumber, guessingNumber, numberCheckCount);

                // 숫자 판단 결과 함수 호출
                gameResult = getNoticeResult(numberCheckCount);
            }

            // 결과 처리 함수 호출
            restart = getCheckRestart();
        }
    }
}

// 기능 요구 사항
// 1. docs/README.md에 작성

// 프로그래밍 요구 사항
// 1.JDK 11 버전 확인
// 2.프로그램 실행의 시작점은 Application의 main()
// 3.build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용 금지
// 4.Java 코드 컨벤션 가이드를 준수하며 프로그래밍
// 5.프로그램 종료 시 System.exit()를 호출 금지
// 6.프로그램 구현이 완료되면 ApplicationTest의 모든 테스트의 성공 확인
// 7.프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 금지

// 추가된 요구 사항
// 1.indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현 (2까지만 허용)
//   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2
//   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하는 것
// 2.3항 연산자 금지
// 3.함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
// 4.JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
// 5.테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현

// 라이브러리
// 1.camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
// 2.Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
// 3.사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

// 과제 진행 요구 사항
// 1.미션은 java-baseball 저장소를 Fork & Clone해 시작
// 2.기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가
// 3.Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가
// 4.커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성
// 5.과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고
