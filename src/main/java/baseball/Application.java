package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answer = getRandomNumber();
        System.out.println("answer = " + answer.toString());

        List<Integer> guess = getUserAnswerList(getInputString());
        List<Integer> ballAndStrike = getBallCountAndStrikeCount(answer, guess);
        printResult(ballAndStrike.get(0), ballAndStrike.get(1));

    }

    /**
     * 사용자 입력을 받아 반환
     */
    private static String getInputString() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 사용자 입력으로부터 숫자 3개짜리 리스트 반환
     * @param userAnswer 입력 문자열
     * @return 숫자 3개짜리 리스트
     * @throws IllegalArgumentException 잘못된 입력에 대한 예외
     */
    protected static List<Integer> getUserAnswerList(String userAnswer) throws IllegalArgumentException {
        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("숫자 3개를 입력해야 함");
        }
        if (userAnswer.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자여야 함");
        }

        return userAnswer.chars()
                .map(c -> {
                    if (c < '1' || c > '9') {
                        throw new IllegalArgumentException("1~9 사이의 숫자가 아님");
                    }
                    return c-'0';
                })
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 서로 다른 랜덤 숫자 3개 리스트 반환
     */
    protected static List<Integer> getRandomNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(numbers);
    }

    /**
     * 사용자 대답에 대하여 볼, 스트라이크 개수 반환
     * @param answer 정답
     * @param guess 사용자 대답
     */
    protected static List<Integer> getBallCountAndStrikeCount(List<Integer> answer, List<Integer> guess) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i=0; i<3; i++) {
            if (answer.get(i) == guess.get(i)) {
                strikeCount++;
            } else if (guess.contains(answer.get(i))) {
                ballCount++;
            }
        }
        return List.of(ballCount, strikeCount);
    }

    private static void printResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼");
        }
        if (strikeCount > 0) {
            if (ballCount > 0) {
                System.out.print(" ");
            }
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();
    }
}
