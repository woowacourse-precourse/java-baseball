package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Baseball {

    private List<Integer> computer;
    private List<Integer> user;
    private String input;
    private GameInfo gameInfo;

    public Baseball() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
        input = "";
        gameInfo = new GameInfo();
    }

    private void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void getRandomNumbers() {
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }


    private void readNumbers() {
        String number = Console.readLine();
    }

    public void gameStart() {
        printInit();
        getRandomNumbers();
    }


}
