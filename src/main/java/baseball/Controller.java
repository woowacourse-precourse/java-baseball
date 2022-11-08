package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final String MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String CONTINUE_GAME = "1";

    private Computer computer;
    private User user = new User();

    public void game() {
        setAnswer();
        while(true) {
            inputUserNumber();
            String hint = computer.getHint(user.getInputNumber());
            System.out.println(hint);
            if(stopGame(hint)) {
                break;
            }
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

    private void inputUserNumber() throws IllegalArgumentException {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        user.checkInputFormat(input);
        user.setInputNumber(input);
    }

    private boolean stopGame(String hint) {
        boolean answer = isAnswer(hint);
        if(answer) {
            String menu = selectMenu();
            if (menu.equals(CONTINUE_GAME)) {
                setAnswer();
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    private boolean isAnswer(String hint) {
        if(hint.equals("3스트라이크"))
            return true;
        else
            return false;
    }

    private String selectMenu() throws IllegalArgumentException {
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(MENU_MESSAGE);
        String menu = Console.readLine();
        if(!menu.equals("1") && !menu.equals("2")) {
            throw new IllegalArgumentException();
        }
        return menu;
    }
}
