package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private final static ComputerNumber computerNumber = new ComputerNumber();
    private final static BaseballGameService baseballGameService = new BaseballGameService();

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        User user = new User();

        while (!user.isEnd()) {
            if (user.getAnswers().isEmpty()) {
                List<Integer> answer = computerNumber.createComputerNumber();
                user.insertAnswer(answer);
            }

            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            user.inputNumber(number);

            baseballGameService.run(user);
            String resultMessage = baseballGameService.getResultMessage(user);
            System.out.println(resultMessage);

            if (resultMessage.equals("3스트라이크")) {
                user.correctAnswer();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String request = Console.readLine();
                if (request.equals("1")) {
                    user.reset();
                } else if (!request.equals("2")) {
                    throw new IllegalArgumentException();
                }
            }
        }

    }
}
