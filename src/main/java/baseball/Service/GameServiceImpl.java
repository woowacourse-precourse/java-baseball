package baseball.Service;

import baseball.Model.Balls;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameServiceImpl implements GameService {

    private Balls balls;

    public GameServiceImpl(){
        this.balls = new Balls();
    }

    @Override
    public void generateNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(Randoms.pickNumberInRange(1,9));
        while(sb.length() != 3) sb.append(getUniqueNumber(sb.toString()));
        String answerNum = sb.toString();
        this.balls.setValue(0,answerNum.charAt(0) - '0');
        this.balls.setValue(1,answerNum.charAt(1) - '0');
        this.balls.setValue(2,answerNum.charAt(2) - '0');
    }

    @Override
    public int getUniqueNumber(String numStr) {
        int num;
        for(num = Randoms.pickNumberInRange(1,9); !numStr.contains(String.valueOf(num));){
            return num;
        }
        return 0;
    }

    @Override
    public int[] getInputs() {
        String intputNum = Console.readLine();
        if (intputNum.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(intputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new int[]{
                intputNum.charAt(0) - '0',
                intputNum.charAt(1) - '0',
                intputNum.charAt(2) - '0'
        };
    }

    @Override
    public int calcStrike(int[] inputNumbers) {
        int strikeCount = 0;
        if (balls.getValue(0) == inputNumbers[0]) strikeCount++;
        if (balls.getValue(1) == inputNumbers[1]) strikeCount++;
        if (balls.getValue(2) == inputNumbers[2]) strikeCount++;
        return strikeCount;
    }

    @Override
    public int calcBallet(int[] inputNumbers) {
        int ballCount = 0;
        if (balls.getValue(1) == inputNumbers[0] || balls.getValue(2) == inputNumbers[0]) ballCount++;
        if (balls.getValue(0) == inputNumbers[1] || balls.getValue(2) == inputNumbers[1]) ballCount++;
        if (balls.getValue(0) == inputNumbers[2] || balls.getValue(1) == inputNumbers[2]) ballCount++;
        return ballCount;
    }

    @Override
    public void calcResult(int[] inputNumbers) {
        int strikeCount = calcStrike(inputNumbers);
        int ballCount = calcBallet(inputNumbers);
        StringBuilder printString = new StringBuilder();

        if (ballCount > 0) printString.append(ballCount + "볼 ");
        if (strikeCount > 0) printString.append(strikeCount + "스트라이크");
        if (ballCount == 0 && strikeCount == 0) printString.append("낫싱");
        System.out.println(printString);
    }

    @Override
    public boolean isGameOver(int[] inputNumbers) {
       return calcStrike(inputNumbers) == 3;
    }

    @Override
    public boolean isContinueGame() {
        String inputString = Console.readLine();
        if (inputString.contentEquals("1")) {
            return true;
        } else if (inputString.contentEquals("2")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

    @Override
    public boolean playGame() throws IllegalArgumentException {
        this.generateNumber();
        while (true) {
            int[] userInput = this.getInputs();
            calcResult(userInput);
            if (isGameOver(userInput)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return isContinueGame();
            }
        }
    }
}
