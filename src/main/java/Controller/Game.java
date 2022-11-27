package Controller;

import View.InputView;
import View.OutputView;
import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.User;

public class Game {
    public static String EXITSTATUS = "playing";
    private InputView inputView=new InputView();
    private OutputView outputView=new OutputView();
    private User user;


    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
        this.user=new User(inputView.readnumber());
        outputView.print_Message(user);
    }

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
}
