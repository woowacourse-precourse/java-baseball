package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame extends AbstractBaseballGame {
    private static final String EVENT_MESSAGE_BEFORE_PLAY = "숫자 야구 게임을 시작합니다.";
    private static final String EVENT_MESSAGE_PLAYING = "숫자를 입력해주세요 : ";
    private static final String EVENT_MESSAGE_AFTER_PLAY = "${numMatch}개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 ${startNum}, 종료하려면 ${endNum}를 입력하세요.";

    private final NumberService numberService = new NumberServiceImpl();

    @Override
    protected void startEventBeforePlay() {
        System.out.println(EVENT_MESSAGE_BEFORE_PLAY);
    }

    @Override
    protected void play() {
        Score score;

        numberService.pickNumbersByComputer();
        do {
            System.out.print(EVENT_MESSAGE_PLAYING);
            numberService.enterNumbersByUser();
            score = numberService.evaluateNumbers();
            System.out.println(score);
        } while (!score.allMatch());
    }

    @Override
    protected ControlNumber startEventAfterPlay() {
        System.out.println(applyPlaceholder(EVENT_MESSAGE_AFTER_PLAY));

        String userInput = Console.readLine();
        try {
            int controlNumber = Integer.parseInt(userInput);
            return ControlNumber.controlNumberOf(controlNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Your input string: " + userInput);
        }
    }

    private String applyPlaceholder(String str) {
        return str.replaceAll("\\$\\{numMatch}", Integer.toString(NumberServiceImpl.NUM_MATCHES))
                .replaceAll("\\$\\{startNum}", ControlNumber.START_NUM.toString())
                .replaceAll("\\$\\{endNum}", ControlNumber.END_NUM.toString());
    }
}
