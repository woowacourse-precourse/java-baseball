package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    static final String Notice_intro = "숫자 야구 게임을 시작합니다.";
    static final String Notice_requireNum = "숫자를 입력해주세요 : ";
    static final String Notice_newGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean gameStart() {
        List<Integer> ComputerNum = Num_Generator.MakeComputerNum();
        User_Input user = new User_Input();
        Referee referee = new Referee(ComputerNum);
        boolean flag;

        System.out.println(Notice_intro);
        do {
            System.out.println(Notice_requireNum);
            List<Integer> userInput = user.getUserInput();
            flag = referee.printResult(userInput);
            if (!flag) {
                System.out.println(Notice_newGame);
                flag = gameRestart();
                if(flag) { return true; }
            }
        } while (flag);
        return false;
    }

    public boolean gameRestart() {
        String inputRestart =  Console.readLine();
        if (inputRestart.equals("1")) { return  true; }
        else if (inputRestart.equals("2")) { return false; }
        else {
            throw new IllegalArgumentException();
        }
    }
}
