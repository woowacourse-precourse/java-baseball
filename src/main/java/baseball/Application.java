package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private final int MAX_NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String THREE_STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String INPUT_EXCEPTION_LOG = "입력이 잘못되었습니다. 게임을 종료합니다.";

    String input = "";
    String answer = "";

    public void startGame() {
        printStart();
        answer = generateAnswer();

        boolean flag = true;
        while(flag) {
            try {
                input = getInput();
            } catch (IllegalArgumentException exception) {
                System.out.println(INPUT_EXCEPTION_LOG);
                throw exception;
            }

            if(!isValidInput(input)) {
                throw new IllegalArgumentException(INPUT_EXCEPTION_LOG);
            }

            String result = compareToAnswer(input, answer);

            System.out.println(result);
            if(result == THREE_STRIKE) {
                flag = endOfGame();
            }
        }

        System.out.println("게임을 종료합니다. 즐거우셨나요?");
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public String generateAnswer() {
        String answer = "";

        while(answer.length() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            String numberString = convertIntToString(randomNumber);
            if(!answer.contains(numberString)) {
                answer += numberString;
            }
        }

        return answer;
    }

    public String convertIntToString(int intValue) {
        return String.valueOf(intValue);
    }

    public boolean isValidInput(String input) {
        if(isOnlyNumber(input) && isThreeDigit(input) && isAllDifferent(input)) {
            return true;
        }
        return false;
    }

    public boolean isOnlyNumber(String input) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            return false;
        }
        return true;
    }

    public boolean isThreeDigit(String input) {
        if(input.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean isAllDifferent(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if(first == second || second == third || first == third) {
            return false;
        }
        return true;
    }

    public String compareToAnswer(String input, String answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);
        return createResult(strike, ball);
    }

    public int countStrike(String input, String answer) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(String input, String answer) {
        int count = 0;
        char[] inputCharArray = input.toCharArray();
        char[] answerCharArray = answer.toCharArray();

        for (int inputIdx = 0; inputIdx < inputCharArray.length; inputIdx++) {
            for (int answerIdx = 0; answerIdx < answerCharArray.length; answerIdx++) {
                if(inputIdx == answerIdx) {
                    continue;
                }

                if(inputCharArray[inputIdx] == answerCharArray[answerIdx]) {
                    count++;
                }
            }
        }

        return count;
    }

    public String createResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        } else if(strike == MAX_NUMBER_SIZE) {
            return THREE_STRIKE;
        } else if (strike == 0 && ball != 0){
            return ball + BALL;
        } else if (strike != 0 && ball == 0) {
            return strike + STRIKE;
        } else {
            return (ball + BALL + " " + strike + STRIKE);
        }
    }

    public boolean endOfGame() {
        boolean result;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();

            if (input.equals("1")) {
                result = true;
                resetGame();
                break;
            } else if (input.equals("2")) {
                result = false;
                break;
            }
        }

        return result;
    }

    public void resetGame() {
        answer = generateAnswer();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }
}
