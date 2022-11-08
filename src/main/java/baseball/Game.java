package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
public class Game {
    private final int LENGTH = 3;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();
    private String input;
    private char[] fragmentedInputs;

    public void run() {
        createComputerAnswer();
        initializeUser();

        while(true){
            inputUserNumbers();

            if (isCorrect())
                break;

            findBallAndStrike();
        }
    }

    private void createComputerAnswer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void initializeUser() {
        for (int i = 0; i < LENGTH; i++)
            user.add(0);
    }

    private void inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        fragmentedInputs = input.toCharArray();

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
        for (char splitInput : fragmentedInputs) {
            if (!((splitInput >= '1' && splitInput <= '9'))) {
                System.out.println("잘못된 입력값 입니다. 1이상 9이하 숫자를 입력하세요.");
                return false;
            }
        }
        return true;
    }

    private boolean isDifferentNumbers() {
        int[] ints = new int[fragmentedInputs.length];
        for (int i = 0; i < fragmentedInputs.length; i++)
            ints[i] = fragmentedInputs[i] - '0';

        if ((ints[0] != ints[1]) && (ints[0] != ints[2]) && (ints[1] != ints[2]))
            return true;

        System.out.println("잘못된 입력값 입니다. 서로 다른 숫자를 입력하세요.");
        return false;
    }

    private void setUserList() {
        for (int i = 0; i < LENGTH; i++)
            user.set(i, fragmentedInputs[i] - '0');
    }

    private boolean isCorrect() {
        if (Arrays.equals(user.toArray(), computer.toArray())){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private void findBallAndStrike() {
        int ball = 0, strike = 0;

        for (int i = 0; i < LENGTH; i++) {
            if (user.get(i) == computer.get(i))
                strike++;
            else if (computer.contains(user.get(i)))
                ball++;
        }

        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.print(strike + "스트라이크");
        System.out.println("");
    }

}
