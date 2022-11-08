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
    private List<Integer> computerNumber;

    public void gameStart() {
        this.computerNumber = new ArrayList<>();
        List<Integer> playerNumber = new ArrayList<>();
        List<Integer> baseballCount = List.of(0, 0);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean option;
        do {
            pickRandomNumber(computerNumber);
            gameInProgress(computerNumber, playerNumber, baseballCount);
            option = gameEnd();
        } while (option);
    }
    public void gameInProgress(List<Integer> computerNumber, List<Integer> playerNumber, List<Integer> baseballCount) {
        String getPlayerNumber;
        do {
            getPlayerNumber = getPlayerNumber();
            playerNumberList(getPlayerNumber, playerNumber);
            comparisonPlayerComputer(computerNumber, playerNumber, baseballCount);
            printBaseballScore(baseballCount);
        } while (rightAnswer(baseballCount.get(STRIKE_INDEX)));
    }
    public boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String optionNumber= gameRestartOrEnd();
        boolean option = optionRestartOrEnd(optionNumber);
        return option;
    }

    public void pickRandomNumber(List<Integer> computerNumber) {
        this.computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public String getPlayerNumber() {
        String getPlayerNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.print("숫자를 입력해주세요 : ");
            getPlayerNumber = br.readLine();
            getPlayerNumberError(getPlayerNumber);
        } catch (Exception e) {
        }
        return getPlayerNumber;
    }
    public void playerNumberList(String getPlayerNumber, List<Integer> playerNumber) {
        int playerNum = Integer.parseInt(getPlayerNumber);
        for (int i = 0; i < NUMBER_SIZE; i++) {
            playerNumber.add(playerNum % 10);
            playerNum /= 10;
        }
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

    public void comparisonPlayerComputer(List<Integer> computerNumber, List<Integer> playerNumber, List<Integer> baseballCount) {

        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                comparisonNumber(playerNumber.get(i), computerNumber.get(j), i, j, baseballCount);
            }
        }
    }
    public void comparisonNumber(int playerNumber, int computerNumber, int i, int j, List<Integer> baseballCount) {
        if (playerNumber == computerNumber) {
            if (i == j) {
                countBaseball(baseballCount, STRIKE_INDEX);
            } else {
                countBaseball(baseballCount, BALL_INDEX);
            }
        }
    }
    public void countBaseball(List<Integer> baseballCount, int i) {
        int count;
        count = baseballCount.get(i) + 1;
        baseballCount.set(i, count);
    }

    public void printBaseballScore(List<Integer> baseballCount) {
        if ((baseballCount.get(STRIKE_INDEX) > 0) || (baseballCount.get(BALL_INDEX) > 0)) {
            printBall(baseballCount.get(BALL_INDEX));
            printStrike(baseballCount.get(STRIKE_INDEX));
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

    public boolean rightAnswer(int strike) {
        boolean success = false;
        if (strike == 3) {
            success = true;
        }
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