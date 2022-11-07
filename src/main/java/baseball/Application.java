package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    /**
     * 컴퓨터가 생성한 수 반환
     *
     * @return 1부터 9까지 서로 다른 임의의 수 3개로 된 String
     */
    public static String generateRandomNumberString() {
        List<Integer> usedNumber = new ArrayList<>();
        StringBuilder generatedNumber = new StringBuilder();

        while (usedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!usedNumber.contains(randomNumber)) {
                usedNumber.add(randomNumber);
                generatedNumber.append(randomNumber);
            }
        }
        return generatedNumber.toString();
    }

    /**
     * 플레이어로부터 서로 다른 3개의 숫자를 입력받아 반환
     *
     * @return 플레이어가 입력한 3자리 숫자로 된 String
     * @throws IllegalArgumentException 3자리가 아닌 경우, 1~9까지의 숫자가 아닌 경우, 중복되는 숫자가 존재하는 경우
     */
    public static String getGuessNumberInput() throws IllegalArgumentException {
        String inputNumber;
        List<Character> usedNumber = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputNumber.length(); i++) {
            char ch = inputNumber.charAt(i);

            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException();
            }
            if (usedNumber.contains(ch)) {
                throw new IllegalArgumentException();
            }

            usedNumber.add(ch);
        }

        return inputNumber;
    }

    /**
     * 스트라이크의 개수 반환
     *
     * @param answer            컴퓨터가 생각한 숫자 String
     * @param guessNumberString 사용자가 생각한 숫자 String
     * @return 같은 수가 같은 자리에 있는 숫자의 개수
     */
    public static int calcStrikeCount(String answer, String guessNumberString) {
        int strike = 0;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guessNumberString.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    /**
     * 볼의 개수 반환
     *
     * @param answer            컴퓨터가 생각한 숫자 String
     * @param guessNumberString 사용자가 생각한 숫자 String
     * @return 같은 수가 다른 자리에 있는 숫자의 개수
     */
    public static int calcBallCount(String answer, String guessNumberString) {
        int ball = 0;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != guessNumberString.charAt(i)
                    && answer.indexOf(guessNumberString.charAt(i)) != -1) {
                ball++;
            }
        }
        return ball;
    }

    /**
     * 볼, 스트라이크 개수에 따른 메시지 출력
     *
     * @param strike 스트라이크의 개수
     * @param ball   볼의 개수
     */
    public static void printGuessResult(int strike, int ball) {
        StringBuilder resultOutput = new StringBuilder();

        if (ball > 0) {
            resultOutput.append(ball);
            resultOutput.append("볼 ");
        }
        if (strike > 0) {
            resultOutput.append(strike);
            resultOutput.append("스트라이크 ");
        }
        if (strike == 0 && ball == 0) {
            resultOutput.append("낫싱");
        }

        System.out.println(resultOutput.toString().strip());
    }

    /**
     * 게임종료 후 새로 시작할지를 플레이어로부터 입력받아 반환
     *
     * @return 새로 시작할지 여부
     * @throws IllegalArgumentException 새로 시작/종료 명령어 이외의 명령어를 입력한 경우
     */
    public static boolean isContinue() throws IllegalArgumentException {
        String playerInput;
        final String CONTINUE_COMMAND = "1";
        final String QUIT_COMMAND = "2";

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        playerInput = Console.readLine();
        if (!playerInput.equals(CONTINUE_COMMAND) && !playerInput.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException();
        }

        if (playerInput.equals(QUIT_COMMAND)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            String answer = generateRandomNumberString();
            int strike = 0;
            int ball = 0;

            while (strike != 3) {
                String guessNumberString = getGuessNumberInput();

                strike = calcStrikeCount(answer, guessNumberString);
                ball = calcBallCount(answer, guessNumberString);
                printGuessResult(strike, ball);
            }
        } while (isContinue());
    }
}
