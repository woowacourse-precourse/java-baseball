package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        Application main = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean again = true;
        boolean inGame = true;

        List<Integer> computerRanNumList = null;

        while (again) {
            if (inGame) {
                inGame = false;
                computerRanNumList = main.computerNumberList();
//                System.out.println("computer" + computerRanNumList);

            System.out.println("숫자를 입력해주세요 : ");
            String inputNumber = main.playerInputNumber();
            List<Integer> inputNumList = main.inputNumberList(inputNumber);
            }
        }
        int strike = main.strikeCnt(computerRanNumList, inputNumList);
        int inList = main.inListCnt(computerRanNumList, inputNumList);

        int ball = inList - strike;
        main.printScore(ball, strike);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            String inputAgainNumber = main.playerInputNumber();
            again = main.checkAgainNumber(inputAgainNumber);
            inGame = true;
        }
    }
    public int randomPickNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
    public boolean uniqueNumber(int computerRanNum, List<Integer> computerRanNumList) {
        if (computerRanNumList.contains((computerRanNum))) {
            return false;
        }
        return true;
    }
    public List<Integer> computerNumberList() {
        List<Integer> computerRanNumList = new ArrayList<>();
        while (computerRanNumList.size() < 3) {
            checkToInput(randomPickNumber(), computerRanNumList);
        }
        return computerRanNumList;
    }
    private void checkToInput(int computerRanNum, List<Integer> computerRanNumList) {
        if (uniqueNumber(computerRanNum, computerRanNumList)) {
            computerRanNumList.add(computerRanNum);
        }
    }
    public String playerInputNumber() {
        return Console.readLine();
    }

    public boolean checkLen(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int checkNum(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNum(int stringToInt) {
        if (stringToInt == 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public List<Integer> inputNumberList(String inputNumber) {
        List<Integer> inputNumList = new ArrayList<>();
        checkLen(inputNumber);
        for (String splitInputNumber : inputNumber.split("")) {
            int stringToInt = checkNum(splitInputNumber);
            checkNum(stringToInt);
            inputNumList.add(stringToInt);
        }
        return inputNumList;
    }
    public int strikeCnt(List<Integer> computer, List<Integer> player) {
        int strikeCount = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int inListCnt(List<Integer> computer, List<Integer> player) {
        int inListCount = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                inListCount++;
            }
        }
        return inListCount;
    }

    public boolean checkAgainNumber(String inputAgainNumber){
        if (inputAgainNumber.equals("1")) {
            return true;
        }
        if (inputAgainNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public void printScore(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCount == 0 && 1 <= ballCount && ballCount <= 3) {
            System.out.println(ballCount + "볼");
            return;
        }
        if (ballCount == 0 && 1 <= strikeCount && strikeCount <= 3) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}