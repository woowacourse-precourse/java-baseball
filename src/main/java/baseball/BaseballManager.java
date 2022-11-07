package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballManager {
    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();

    public void startGame(){
        computer = BaseballMachine.computerSet();
    }

    public void playGame() {
        int result = 0;
        while (result != 3) {
            user = BaseballMachine.inputUserNumber();
            result = StrikeBallCount.strikeBall(computer, user);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkRestart = Console.readLine();
        if(checkRestart.equals("1")){
            return true;
        }
        else if(checkRestart.equals("2")){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
