package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private Computer computer;
    private User user = new User();

    public void game() {
        setAnswer();
        while(true) {
            inputUserNumber();
            String hint = computer.getHint(user.getInputNumber());
        }
    }

    private void setAnswer() {
        System.out.println("START_MESSAGE = " + START_MESSAGE);
        String answer = "";
        while(answer.length() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(String.valueOf(num))) {
                answer += num;
            }
        }
        computer = new Computer(answer);
    }

    private void inputUserNumber() throws IllegalArgumentException{
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        user.checkInputFormat(input);
        user.setInputNumber(input);
    }
}
