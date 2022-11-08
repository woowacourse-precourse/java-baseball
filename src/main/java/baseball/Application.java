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
    private final int BALL_INDEX = 0;
    private final int STRIKE_INDEX = 1;
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> playerNumber = new ArrayList<>();
    private List<Integer> baseballCount = List.of(0, 0);

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean option;
        do {
            pickRandomNumber();
            gameInProgress();
            option = gameEnd();
        } while (option);
    }
    public void gameInProgress() {
        do {
            getPlayerNumber();
            comparisonPlayerComputer();
            printBaseballScore();
        } while (rightAnswer());
    }
    public boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String optionNumber= gameRestartOrEnd();
        boolean option = optionRestartOrEnd(optionNumber);
        return option;
    }

    public void pickRandomNumber() {
        for (int i = 0; i < NUMBER_SIZE;) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
                i++;
            }
        }
    }

    public void getPlayerNumber() {
        String getPlayerNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.print("숫자를 입력해주세요 :");
            getPlayerNumber = br.readLine();
            getPlayerNumberError(getPlayerNumber);
            playerNumberList(getPlayerNumber);
        } catch (Exception e) {
        }
    }
    public void playerNumberList(String getPlayerNumber) {
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

    public void comparisonPlayerComputer() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                comparisonNumber(playerNumber.get(i), computerNumber.get(j), i, j);
            }
        }
    }
    public void comparisonNumber(int playerNumber, int computerNumber, int i, int j) {
        if (playerNumber == computerNumber) {
            if (i == j) {
                countBaseball(STRIKE_INDEX);
            } else {
                countBaseball(BALL_INDEX);
            }
        }
    }
    public void countBaseball(int i) {
        int count;
        count = baseballCount.get(i) + 1;
        baseballCount.set(i, count);
    }

    public void printBaseballScore() {
        if (baseballCount.get(STRIKE_INDEX) == 0 && baseballCount.get(BALL_INDEX) == 0) {
            System.out.print("낫싱");
        } else {
            printBall();
            printStrike();
        }
    }
    public void printStrike() {
        if (baseballCount.get(STRIKE_INDEX) != 0) {
            System.out.printf("%d스트라이크", baseballCount.get(STRIKE_INDEX));
        }
    }
    public void printBall() {
        if (baseballCount.get(BALL_INDEX) != 0) {
            System.out.printf("%d볼 ", baseballCount.get(BALL_INDEX));
        }
    }

    public boolean rightAnswer() {
        boolean success = false;
        if (baseballCount.get(STRIKE_INDEX) == 3) {
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
            listClear();
        } else if (optionNumber.equals("2")) {
            option = false;
        } else {
            throw new IllegalArgumentException("옵션값이 아닙니다.");
        }
        return !option;
    }
    public void listClear() {
        this.computerNumber.clear();
        this.playerNumber.clear();
        this.baseballCount.set(BALL_INDEX, 0);
        this.baseballCount.set(STRIKE_INDEX, 0);
    }
}