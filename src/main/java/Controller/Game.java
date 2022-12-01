package Controller;

import View.InputView;
import View.OutputView;
import domain.User;

public class Game {
    public static String STATUS = "playing";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
        User user = new User(inputView.readnumber());
        outputView.print_Message(user);
    }
/*
    public static void set_EXITSTATUS(String input) {
        if (input.equals("1")) {
            Computer.setNumber(validation.get_ThreeRandomNumbers());

            return;
        }
        if (input.equals("2")) {
            System.out.print("게임 종료");

            EXITSTATUS = "exit";
        }
    }
    */
}
