package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public void start() {

        int answerLength = 3;
        boolean userContinue = true;
        BaseballGame baseBallGame = new BaseballGame(answerLength);

        baseBallGame.useGeneratedAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (userContinue) {

            System.out.print("숫자를 입력해주세요 : ");

            BaseballGameResultDto gameResult = baseBallGame.submitAnswer(Console.readLine());

            System.out.println(printResult(gameResult));

            if (gameResult.getStrike() == answerLength) {
                baseBallGame = new BaseballGame(3);
                baseBallGame.useGeneratedAnswer();

                System.out.println(answerLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userContinue = askUserContinue();
            }
        }

    }

    private boolean askUserContinue() {
        int userContinue = Integer.parseInt(Console.readLine());
        if (userContinue == 1) {
            return true;
        }
        if (userContinue == 2) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다");
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
