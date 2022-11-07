package baseball.mainbaseballgame;

import baseball.outputgenerator.GameResult;
import java.util.List;

import static baseball.Application.scanner;
import static baseball.inputparser.InputParser.parseInGameInput;
import static baseball.numbercomparator.NumberComparator.calculateStrike;
import static baseball.outputgenerator.OutputGenerator.outputGenerator;
import static baseball.randomgenerator.RandomNumberGenerator.getRandomNumList;

/**
 * 메인 게임을 실행하는 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
public class BaseballGameApplication {

    /**
     * 야구 게임 로직을 실행하는 메서드입니다.
     */
    public static void executeBaseballGame() {
        // 0. 컴퓨터 난수 생성
        List<Integer> computerNumberList = getRandomNumList();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            // 1. 시작 멘트 출력
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.nextLine();

            // 2. 입력 문자열을 숫자 리스트로 변환하고, 이를 컴퓨터 숫자 리스트와 비교합니다. 이후 결과와 출력 메시지로 변환합니다.
            GameResult result = outputGenerator(calculateStrike(computerNumberList, parseInGameInput(inputNumber)));
            System.out.println(result.getMessage());

            // 3. 3스트라이크인 경우, 게임을 종료합니다.
            if (result.isSuccess()) {
                break;
            }
        }
    }
}
