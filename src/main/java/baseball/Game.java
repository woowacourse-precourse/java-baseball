package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int LENGTH = 3;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = List.of(0, 0, 0);
    private String input;
    private String[] inputs;
    
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
        input = Console.readLine();
        inputs = input.split("");

        if (isValidInput()) {
            setUserList();
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidInput() {
        if (isLengthThree() && isEachNumberFrom1To9() && isDifferentNumbers())
            return true;

        return false;
    }
    
    private boolean isLengthThree() {
        if (input.length() == 3)
            return true;

        System.out.println("잘못된 입력값 입니다. 3자리 숫자로 입력하세요.");
        return false;
    }

    private boolean isEachNumberFrom1To9() {
        for (String input : inputs) {
            int in = Integer.parseInt(input);
            if (!(in >= 1 && in <= 9)){
                System.out.println("잘못된 입력값 입니다. 1이상 9이하 숫자를 입력하세요.");
                return false;
            }
        }
        return true;
    }

    private boolean isDifferentNumbers() {
        if ((inputs[0] != inputs[1]) && (inputs[0] != inputs[2]) && (inputs[1] != inputs[2]))
            return true;

        System.out.println("잘못된 입력값 입니다. 서로 다른 숫자를 입력하세요.");
        return false;
    }

    private void setUserList() {
        for (int i = 0; i < LENGTH; i++)
            user.set(i, Integer.parseInt(inputs[i]));
    }

//    boolean 값비교함수() {
//    }
}
