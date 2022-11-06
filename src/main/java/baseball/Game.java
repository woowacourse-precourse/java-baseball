package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int LENGTH = 3;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = List.of(0, 0, 0);

    public void run() {
        createComputerAnswer();
        inputUserNumbers();

//        while(사용자 인풋값 != 컴퓨터값)
//        // 사용자 인풋받기
//        // 인풋값과 컴퓨터값 비교하기
//        //1볼, 1스트라이크 이런거 찾기
//        // 인풋받기 돌아가기
    }

    private void createComputerAnswer() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private void inputUserNumbers() {
        String input = Console.readLine();
        if(!isValidInput(input)){
            throw new IllegalArgumentException();
        }
        setUserList(input);
    }

    private boolean isValidInput(String input) {
        return false;
    }

    private void setUserList(String input) {
        String[] inputs = input.split("");
        for (int i = 0; i < LENGTH; i++)
            user.set(i, Integer.parseInt(inputs[i]));
    }

//    boolean 값비교함수() {
//    }
}
