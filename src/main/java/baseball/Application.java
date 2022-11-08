package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.gameStart();
    }
}

class Baseball {
    private final int NUMBER_SIZE = 3;
    private final int STRIKE_INDEX = 0;
    private final int BALL_INDEX = 1;
    private final int ASCII_ZERO = 48;
    private List<Character> computerNumber;

    public void gameStart() {
        this.computerNumber = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean option;
        do {
            pickRandomNumber(computerNumber);
            gameInProgress(computerNumber);
            option = gameEnd();
        } while (!option);
    }
    public void gameInProgress(List<Character> computerNumber) {
        String playerNumber;
        int[] baseballCount = new int[2];
        do {
            playerNumber = getPlayerNumber();
            comparisonPlayerComputer(computerNumber, playerNumber, baseballCount);
            printBaseballScore(baseballCount);
        } while (rightAnswer(baseballCount));
    }
    public boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String optionNumber= gameRestartOrEnd();
        boolean option = optionRestartOrEnd(optionNumber);
        return option;
    }

    public void pickRandomNumber(List<Character> computerNumber) {
        this.computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char character = (char) (randomNumber + ASCII_ZERO);
            if (!computerNumber.contains(character)) {
                computerNumber.add(character);
            }
        }
    }

    public String getPlayerNumber() {
        String playerNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.print("숫자를 입력해주세요 : ");
            playerNumber = br.readLine();
            getPlayerNumberError(playerNumber);
        } catch (Exception e) {
        }
        return playerNumber;
    }

    public void getPlayerNumberError(String getPlayerNumber) {
        if (playerNumberOverLength(getPlayerNumber)) {
            throw new IllegalArgumentException("입력값이 세자리 수가 아닙니다.");
        } else if (playerNumberGetChar(getPlayerNumber)) {
            throw new IllegalArgumentException("입력값에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }
    public boolean playerNumberOverLength (String getPlayerNumber) {
        boolean getException = (getPlayerNumber.length() != NUMBER_SIZE);
        return getException;
    }
    public boolean playerNumberGetChar (String getPlayerNumber) {
        int playerNumber = Integer.parseInt(getPlayerNumber);
        boolean getException = (playerNumber / 1000 != 0);
        return getException;
    }

    public void comparisonPlayerComputer(List<Character> computerNumber, String playerNumber, int[] baseballCount) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                comparisonNumber(playerNumber.charAt(i) , computerNumber.get(j), i, j, baseballCount);
            }
        }
    }
    public void comparisonNumber(int playerNumber, int computerNumber, int i, int j, int[] baseballCount) {
        if (playerNumber == computerNumber) {
            if (i == j) {
                countBaseball(baseballCount, STRIKE_INDEX);
            } else {
                countBaseball(baseballCount, BALL_INDEX);
            }
        }
    }
    public void countBaseball(int[] baseballCount, int i) {
        int count;
        count = baseballCount[i] + 1;
        baseballCount[i] = count;
    }

    public void printBaseballScore(int[] baseballCount) {
        if ((baseballCount[STRIKE_INDEX] > 0) || (baseballCount[BALL_INDEX] > 0)) {
            printBall(baseballCount[BALL_INDEX]);
            printStrike(baseballCount[STRIKE_INDEX]);
        } else {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }
    public void printStrike(int strike) {
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
    }
    public void printBall(int ball) {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
    }

    public boolean rightAnswer(int[] baseballCount) {
        boolean success = false;
        if (baseballCount[STRIKE_INDEX] == 3) {
            success = true;
        }
        baseballCount[STRIKE_INDEX] = 0;
        baseballCount[BALL_INDEX] = 0;
        return !success;
    }
    public String gameRestartOrEnd() {
        String optionNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            optionNumber = br.readLine();
        } catch (Exception e) { }
        return optionNumber;
    }
    public boolean optionRestartOrEnd(String optionNumber) {
        boolean option;
        if (optionNumber.equals("1")) {
            option = true;
        } else if (optionNumber.equals("2")) {
            option = false;
        } else {
            throw new IllegalArgumentException("옵션값이 아닙니다.");
        }
        return !option;
    }
}