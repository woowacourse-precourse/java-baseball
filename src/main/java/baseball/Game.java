package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
public class Game {
    private final int LENGTH = 3;
    private List<Integer> computer = new ArrayList<Integer>();
    private List<Integer> user = new ArrayList<Integer>();
    private String input;
    private String[] splitInputs; // input 을 한글자씩 쪼개 배열에 담음

    public void run() {
        createComputerAnswer();
        userInit();

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

    private void userInit() {
        for (int i = 0; i < LENGTH; i++)
            user.add(0);
    }

    private void inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        splitInputs = input.split("");

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
        for (String splitInput : splitInputs) {
            int in = Integer.parseInt(splitInput);
            if (!(in >= 1 && in <= 9)){
                System.out.println("잘못된 입력값 입니다. 1이상 9이하 숫자를 입력하세요.");
                return false;
            }
        }
        return true;
    }

    private boolean isDifferentNumbers() {
        int[] ints = new int[splitInputs.length];

        for (int i = 0; i < splitInputs.length; i++)
            ints[i] = Integer.parseInt(splitInputs[i]);

        if ((ints[0] != ints[1]) && (ints[0] != ints[2]) && (ints[1] != ints[2]))
            return true;

        System.out.println("잘못된 입력값 입니다. 서로 다른 숫자를 입력하세요.");
        return false;
    }

    private void setUserList() {
        for (int i = 0; i < LENGTH; i++)
            user.set(i, Integer.parseInt(splitInputs[i]));
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
        int ball, strike = 0;

        // strike
        for (int i = 0; i < LENGTH; i++) {
            if (user.get(i) == computer.get(i))
                strike++;
        }

        ball = getIntersection().size() - strike;

        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.print(strike + "스트라이크");
        System.out.println("");
    }

    private List<Integer> getIntersection() {
        List<Integer> copy = new ArrayList<>();
        for (int u : user)
            copy.add(u);
        copy.retainAll(computer); // copy는 교집합을 원소로 갖는 리스트가 된다.
        return copy;
    }
}
