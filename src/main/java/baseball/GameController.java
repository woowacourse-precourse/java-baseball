package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class GameController {

    public void start() {

        int answerLength = 3;

        BaseballGame baseballGame = new BaseballGame(answerLength);

        baseballGame.useGeneratedAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean userContinue = true;

        while (userContinue) {
            int input = 0;

            System.out.print("숫자를 입력해주세요 : ");

            BaseballGameResultDto gameResult = baseballGame.submitAnswer(Console.readLine());

            System.out.println(printResult(gameResult));

            if (gameResult.getStrike()==answerLength) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                input = submitContinue(Console.readLine());
            }

            if (input == 1) {
                baseballGame.useGeneratedAnswer();
            }
            if (input == 2) {
                userContinue = false;
            }
        }
    }

    public int submitContinue(String number) {
        String regex = "^[1-2]{1}";
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다");
        }
        return Integer.parseInt(number);
    }

    public String printResult(BaseballGameResultDto baseballResultDto) {
        int ball = baseballResultDto.getBall();
        int strike = baseballResultDto.getStrike();

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball + "볼" + " ");
        }

        if (strike > 0) {
            sb.append(strike + "스트라이크" + " ");
        }

        if (sb.length() == 0) {
            return "낫싱";
        }
        return sb.toString();
    }
}
