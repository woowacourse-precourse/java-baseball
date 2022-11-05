package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballGame {
    // 숫자야구에 사용될 문자열 기준 크기
    private static final int numberSize = 3;

    private String standard;
    private boolean gameContinue = true;

    private Referee referee;

    private String userInput;

    public void play() {
        referee = new Referee();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameContinue) {
            referee.setStandard(RandomNumberGenerator.generate(numberSize));
            while (referee.getStrike() < 3) {
                System.out.print("숫자를 입력해 주세요 : ");
                userInput = Console.readLine();
                PlayerInputValidator.validate(userInput, numberSize);
                referee.judge(userInput);
                referee.showResult();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = Console.readLine();
            if (!userInput.equals("1") && !userInput.equals("2")) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
            gameContinue = userInput.equals("1");
        }
        System.out.println("게임 종료");
    }
}
