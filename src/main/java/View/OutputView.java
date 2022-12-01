package View;

import Controller.Game;
import Controller.validation;
import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.User;

public class OutputView {
    private final int NOTHING = 0;
    private final int ALL_HIT = 3;

    public void print_Message(User user) {
        ball_Message(user);
        strike_Message(user);
        nothing_Message(user);
    }

    public void strike_Message(User user) {
        if (user.strike_count() != NOTHING) {
            if (user.strike_count() == ALL_HIT) {
                whenCorrect_Message(user);

                set_exitstatus(Console.readLine());
            }

            System.out.print(user.strike_count() + "스트라이크" + " ");
        }
    }

    public void ball_Message(User user) {
        if (user.ball_count() != NOTHING) {
            System.out.print(user.ball_count() + "볼 ");
        }
    }


    public void nothing_Message(User user) {
        if (user.strike_count() == NOTHING && user.ball_count() == NOTHING) {
            System.out.print("낫싱" + "\n");
        }
    }

    public void whenCorrect_Message(User user) {

        System.out.print(user.strike_count() + "스트라이크" + "\n");
        System.out.print("숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + "\n");
    }

    public static void set_exitstatus(String input) {
        if (input.equals("1")) {
            Computer.setNumber(validation.get_ThreeRandomNumbers());
            return;
        }
        if (input.equals("2")) {
            System.out.print("게임 종료");

            Game.STATUS = "exit";
        }
    }

}
