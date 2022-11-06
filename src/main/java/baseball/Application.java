package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


//        String correctAnswer = makeRandomNumStr();
//        String correctAnswer = "589";

        boolean run = true;
        while (run) {
            String correctAnswer = makeRandomNumStr();

            runGame(correctAnswer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String next = Console.readLine();

            if (next.equals("1")) {
//                run = true;
                continue;
            } else if (next.equals("2")) {
                System.out.println("종료합니다.");
                run = false;
            } else {
                throw new IllegalArgumentException();
            }



        }
    }

    private static void runGame(String correctAnswer) {
        int ballCount;
        int strikeCount;

        boolean run = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (run) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            System.out.println(userAnswer);

//            입력값 검증
            lengthCheck(userAnswer);
            numberCheck(userAnswer);
            duplicateCheck(userAnswer);

//            계산
            strikeCount = getStrikeCount(correctAnswer, userAnswer);
            ballCount = getBallCount(correctAnswer, userAnswer);


//            결과 출력
            if (ballCount != 0 && strikeCount != 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
            if (ballCount != 0 && strikeCount == 0) {
                System.out.println(ballCount + "볼 ");
            }
            if (strikeCount != 0 && ballCount == 0) {
                System.out.println(strikeCount + "스트라이크 ");
            }
            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            }


            if (strikeCount == 3) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                System.out.println("게임 종료");
                run = false;
            }

        }

    }


    private static int getBallCount(String correctAnswer, String userAnswer) {

        int ballCount = 0;

        for (int i = 0; i < correctAnswer.length(); i++) {

            char c = userAnswer.charAt(i);
            int findIndex = correctAnswer.indexOf(c);

            if (findIndex != i && findIndex >= 0) {
                ballCount++;
            }

        }
        return ballCount;
    }

    private static int getStrikeCount(String correctAnswer, String userAnswer) {

        int strikeCount = 0;

        for (int i = 0; i < correctAnswer.length(); i++) {

            char target = correctAnswer.charAt(i);

            if (target == userAnswer.charAt(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static void duplicateCheck(String userAnswer) {
        char first = userAnswer.charAt(0);
        char second = userAnswer.charAt(1);
        char third = userAnswer.charAt(2);

        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException();
        }
    }

    private static void numberCheck(String userAnswer) {
        for (int i = 0; i < userAnswer.length(); i++) {
            char c = userAnswer.charAt(i);
            int numericValue = Character.getNumericValue(c);

            if (numericValue < 1 || 9 < numericValue) {
                throw new IllegalArgumentException();
            }

        }
    }


    private static void lengthCheck(String userAnswer) {

        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException();
        }

    }


    private static String makeRandomNumStr() {
        Set<String> correctAnswer = new HashSet<>();

        while (correctAnswer.size() < 3) {
            String str = Randoms.pickNumberInRange(1, 9) + "";
            correctAnswer.add(str);
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (String s : correctAnswer
        ) {
            stringBuilder.append(s);
        }

        return String.valueOf(stringBuilder);
    }

}
