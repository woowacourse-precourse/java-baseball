package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 프로그램 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 새로운 문제 생성
            renewRandomNumber();

            // 새로운 게임 시작
            int again = game();
            // 게임 재시작 or 종료
            if (again == 2)
                break;
        }
    }

    private static List<Integer> answer;
    private static List<Integer> numbers;
    private static int strike;
    private static int ball;

    /**
     * 한 턴의 게임 실행
     * play a single game
     * return : 1 (게임 재시작) / 2 (실행종료)
     */
    public static int game() {
        String stringInput;
        while (true) {
            // 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            stringInput = Console.readLine().strip();

            renewNumbers(stringInput);

            // 계산하기
            try {
                strike = ScoreDetect.getStrikeCount(answer, numbers);
                ball = ScoreDetect.getBallCount(answer, numbers);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("올바르지 않은 숫자 리스트입니다.");
            }

            // 결과 출력
            if (strike == 3) {
                System.out.println("3스트라이크\n" +
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // 사용자 입력 받기
                stringInput = Console.readLine().strip();
                return getUserOption(stringInput); // 게임 종료
            } else if (strike != 0 || ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    /**
     * 난수로 answer 리스트 만들기
     * generate random number
     */
    public static void renewRandomNumber() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    /**
     * 유저의 인풋으로부터 숫자 리스트 만들기
     * make numbers list from user's string input
     */
    public static void renewNumbers(String stringInput) {
        // 오류체크 : 숫자 수, 다른 문자 있는지?
        if (stringInput.length() != 3)
            throw new IllegalArgumentException("올바르지 않은 숫자 입력입니다.");
        for (int i = 0; i < 3; i++) {
            if (stringInput.charAt(i) < '0' || stringInput.charAt(i) > '9')
                throw new IllegalArgumentException("올바르지 않은 숫자 입력입니다.");
        }

        numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(stringInput.charAt(i) - '0');
        }
    }

    /**
     * 계속진행 / 실행종료 옵션 입력 확인
     * check user's option input(1 or 2) and return option code
     */
    public static int getUserOption(String stringInput) {
        int number;
        try {
            number = Integer.parseInt(stringInput);
            if (number != 1 && number != 2)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("올바르지 않은 옵션 입력입니다.");
        }
        return number;
    }

    // admin - answer 반환
    public static String getAnswer() {
        return answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    // admin - numbers 반환
    public static String getNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
