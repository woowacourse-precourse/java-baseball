package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private int strike;
    private int ball;
    public Computer computer;

    public Game(Computer computer) {
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void start() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (strike < 3) {
            System.out.println("정답 : " +computer.getComputerNumbers());
            System.out.print("숫자를 입력해 주세요 : ");
            userInput = readLine();
            validateUserInput(userInput);

            userNumbers = stringToIntegerList(userInput);
            isValidateSize(userNumbers);
            isValidateRange(userNumbers);

            strike = checkStrikeCount(userNumbers);
            ball = checkBallCount(userNumbers);

            gameMessage();
            System.out.print("\n");
        }
        successMessage();
    }

    private List<Integer> stringToIntegerList(String userInput) {
        String[] userInputSplit = userInput.split("");
        ArrayList<Integer> result = new ArrayList<>();

        for (String u : userInputSplit) {
            result.add(Integer.parseInt(u));
        }

        return result;
    }

    public void validateUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is wrong.");
        }
    }

    public void isValidateSize(List<Integer> userInput) {
        if (userInput.size() != 3) {
            throw new IllegalArgumentException("Input size is too long.");
        }
    }

    public void isValidateRange(List<Integer> userInput) {
        for (Integer u : userInput) {
            if (u < 1 || u > 9) {
                throw new IllegalArgumentException("Input range is wrong.");
            }
        }
    }

    public void isDuplicatedNumber(List<Integer> userInput) {
        if (userInput.stream().distinct().count() != userInput.size()) {
            throw new IllegalArgumentException("Input is duplicated.");
        }
    }

    public int checkStrikeCount(List<Integer> userInput) {
        int strikeCount = 0;
        List<Integer> computerNumber = computer.getComputerNumbers();

        for (int i = 0; i < computerNumber.size(); i++) {
            if (Objects.equals(computerNumber.get(i), userInput.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public int checkBallCount(List<Integer> userInput) {
        int ballCount = 0;
        List<Integer> computerNumber = computer.getComputerNumbers();

        for (int i = 0; i < computerNumber.size(); i++) {
            if(!Objects.equals(computerNumber.get(i), userInput.get(i))
                    && computerNumber.contains(userInput.get(i))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public void gameMessage() {
        StringBuilder sb = new StringBuilder();

        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        if(ball != 0) {
            sb.append(ball).append("볼 ");
        }

        if(strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb.toString());
    }

    public void successMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
