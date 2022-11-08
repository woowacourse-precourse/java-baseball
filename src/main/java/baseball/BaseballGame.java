package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {

    public List<Integer> inputAnswer() {
        String line = Console.readLine();

        validateAnswer(line);

        return List.of(Integer.parseInt(line));
    }

    public int inputCommand() {
        String line = Console.readLine();

        validateCommand(line);

        return Integer.parseInt(line);
    }

    private void validateAnswer(String answer) {
        for (char c : answer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력될 수 있습니다.");
            }
        }
    }

    private void validateCommand(String command) {
       if (!command.equals("1") && !command.equals("2")) {
           throw new IllegalArgumentException("명령은 1 또는 2만 입력 가능합니다.");
       }
    }

//    public void run() {
//        /**
//         * new Computer();
//         * 게임을 시작합니다.
//         * (최초 실행 시 바로 문제 맞추기)
//         * while() {
//         *  readline();
//         *  result = computer.inputValue()
//         *  if(result.equals("3스트라이크") {
//         *      "정답을 맞췄습니다. 게임 더? 종료?"
//         *      readline()
//         *      if (input.eqauls(2)) {
//         *          "끝~";
//         *          break;
//         *      }
//         * }
//         * */
//    }
}
