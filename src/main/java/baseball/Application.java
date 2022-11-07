package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();
        int numberLengthCondition = 3;
        Pattern numberPatternCondition = Pattern.compile("^[1-9]*$");
        boolean isMaintains = true;
        int lastAnswer = 0;

        List<String> answerNumbers = service.generateRandomNumber(1, 9, numberLengthCondition);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isMaintains) {
            if (lastAnswer == 1) {
                answerNumbers = service.generateRandomNumber(1, 9, numberLengthCondition);
                lastAnswer = 0;
            }
            System.out.print("숫자를 입력해 주세요 : ");
            String userInput = Console.readLine();

            List<String> questionNumbers = service.getUserInputToList(userInput, numberLengthCondition, numberPatternCondition);

            Map<String, Integer> ballCount = service.getBallCount(questionNumbers, answerNumbers);

            service.printBallCountMap(ballCount);

            lastAnswer = service.checkAnswer(ballCount, numberLengthCondition);

            if(lastAnswer == 2){
                isMaintains = false;
            }
        }
    }
}
