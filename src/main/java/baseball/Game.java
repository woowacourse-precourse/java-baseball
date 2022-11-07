package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    static final String Notice_intro = "숫자 야구 게임을 시작합니다.";
    static final String Notice_requireNum = "숫자를 입력해주세요 : ";
    static final String Notice_success = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String Notice_newGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean gameStart() {
        List<Integer> ComputerNum = Num_Generator.MakeComputerNum();
        User_Input user = new User_Input();
        Referee referee = new Referee(ComputerNum);
        boolean flag = true;

        System.out.println(Notice_intro);
        do {
            System.out.println(Notice_requireNum);
            List<Integer> userInput = user.getUserInput();
//            System.out.println(ComputerNum);
//            System.out.println(userInput);
            flag = referee.printResult(userInput);
            if (!flag) {
                System.out.println(Notice_newGame);
                flag = gameRestart();
                if(flag) { // 1 : 게임 재시작
                    return true;
                }
            }
        } while (flag);
        return false;
    }

    public boolean gameRestart() {
        String inputRestart =  Console.readLine();
        if (inputRestart.equals("1")) {
            return  true;
        } else if (inputRestart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
