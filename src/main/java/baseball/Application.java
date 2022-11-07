package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            answer = new ArrayList<>();
            generateRandomNumber();

            int again = game();

            if (again == 2)
                break;
        }
    }

    private static List<Integer> answer;
    private static List<Integer> numbers;
    private static int strike;
    private static int ball;

    /**
     * play a single game
     */
    public static int game() {
        while (true) {
            while (true) {
                // 입력받기
                System.out.print("숫자를 입력해주세요 : ");
                String stringInput = Console.readLine().strip();
                // 오류체크 : 숫자 수, 다른 문자 있는지?

                numbers = new ArrayList<>();
                try {
                    for (int i = 0; i < 3; i++) {
                        numbers.add(stringInput.charAt(i) - '0');
                    }
                    break;
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    continue;
                }
            }

            // 계산하기
            strike = ScoreDetect.getStrikeCount(answer, numbers);
            ball = ScoreDetect.getBallCount(answer, numbers);

            // 출력하기
            if (strike == 3) {
                System.out.println("3스트라이크\n" +
                        "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // 입력받기
                int number = 0;
                while (true) {
                    // 입력받기
                    String stringInput = Console.readLine().strip();

                    try {
                        number = Integer.parseInt(stringInput);
                        break;
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    //오류체크
                }
                return number;
            } else if (strike != 0 || ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    /**
     * generate random number
     */
    public static void generateRandomNumber() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }


    public static String getAnswer() {
        return answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static String getNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

}
