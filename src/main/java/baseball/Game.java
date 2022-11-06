package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final int LENGTH = 3;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();
    private String input;
    private String[] inputs;
    
    public void run() {
        createComputerAnswer();

        while(true){
            inputUserNumbers();

            if (isCorrect()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            //1볼, 1스트라이크 이런거 찾기
            // compare();
        }

    }

    private void createComputerAnswer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("computer : " + computer.toString());
    }

    private void inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        System.out.println("input : " + input);
        inputs = input.split("");

        if (isValidInput()) {
            setUserList();
        }
        else {
            System.out.println("is not valid input");
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
            user.add(0);

        for (int i = 0; i < LENGTH; i++)
            user.set(i, Integer.parseInt(inputs[i]));
        System.out.println("user : " + user.toString());
    }

    private boolean isCorrect() {
        if (Arrays.equals(user.toArray(), computer.toArray()))
            return true;

        return false;
    }

    private void compare() {
    }
}
