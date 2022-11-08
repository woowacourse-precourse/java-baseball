package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /*
         * ===============
         * 숫자 야구 게임
         * 서로 다른 수 3가지의 수를 맞추는 게임
         * ================================================
         * 컴퓨터가 랜덤으로 숫자를 뽑는다.
         * 플레이어가 유추한 3자리의 답을 알려주면서 플레이어가 맞혀한다.
         * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
         * 사용자가 값을 잘못 입력하면 IllegalArgumentException을 발생시킨 후 에플리케이션은 종료되어야한다.
         * */

    }

}

class Game {
    private static List<Integer> gameAnswer;
    public static List<Integer> guessNumber;

    Game() {
        gameAnswer = getGameRandomNumber();
    }

    public static List<Integer> getGameAnswer() {
        return gameAnswer;
    }


    private void requestAnswer() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = readLine();
        // userInput을 확인한다
        Game.validInputValue(userInput);

        // userInput을 List<Int> 형태로 type-casting한다.
        List<Integer> userInputList = parseIntList(userInput);

        // guessNumber에 할당한다.
        guessNumber = userInputList;
    }

    public List<Integer> parseIntList(String userInputNumber) {
        // String을 List<Integer>로 type-casting해주는 매서드.
        List<Integer> userInputList = new ArrayList<>();

        String[] splitString = userInputNumber.split("");

        for (String s : splitString) {
            userInputList.add(Integer.parseInt(s));
        }

        return userInputList;
    }


    public static String validInputValue(String userInput) {
        // 유저 입력값 검증 메서드.
        // 길이가 같지 않다면 Exception을 Throw한다.
        if (!Game.validInputLength(userInput)) {
            throw new IllegalArgumentException("3자리의 1~9 사이의 겹치지 않는 숫자를 입력해주세요.");
        }
        // 문자열인 경우
        if (!Game.validIsNumber(userInput)) {
            throw new IllegalArgumentException("1~9 사이의 겹치지 않는 3자리의 숫자를 입력해주세요.");
        }
        // 0이 들어있는 숫자인 경우
        if (!Game.validHasNonZero(userInput)) {
            throw new IllegalArgumentException("0을 제외한 1~9 사이의 겹치지 않는 3자리의 숫자를 입력해주세요.");
        }
        for (int index = 1; index < userInput.length(); index++) {
            // 겹치는 숫자가 있는 경우
            if (userInput.charAt(index - 1) == userInput.charAt(index)) {
                throw new IllegalArgumentException("겹치지 않는 1~9 사이의 3자리 숫자를 입력해주세요.");
            }
        }
        return userInput;
    }

    public static boolean validInputLength(final String strInput) {
        // 길이가 3인지 확인하는 매서드
        if (strInput.length() == 3) {
            return true;
        }
        return false;
    }

    static boolean validIsNumber(String strInput) {
        // 0 이외의 숫자를 입력했는지 확인하는 매서드.
        try {
            int number = Integer.parseInt(strInput);
        } catch (NumberFormatException e) {
            return false;
        }
        // 0이 포함되어있는지 확인한다.
        return true;
    }

    static boolean validHasNonZero(String strInput) {
        // strInput에 0 값이 있는지 확인하는 메서드.
        return !strInput.contains("0");
    }


    public List<Integer> getGameRandomNumber() {

        // 3개의 무작위 난수를 중복 없이 뽑는다.
        List<Integer> gameRandomNumber = new ArrayList<>();
        while (gameRandomNumber.size() < 3) {
            int randomNumber = getRandomNumber();
            // Random Number가 list 원소에 포함되어 있지 않다면, 추가한다.
            nonDuplicateAddElement(gameRandomNumber, randomNumber);
        }

        return gameRandomNumber;
    }

    private static void nonDuplicateAddElement(List<Integer> gameRandomNumber, int randomNumber) {
        if (!gameRandomNumber.contains(randomNumber)) {
            gameRandomNumber.add(randomNumber);
        }
    }

    public int getRandomNumber() {
        // 1 ~ 9 범위의 난수를 return하는 함수.
        return pickNumberInRange(1, 9);
    }

}

class Hint {
    // 플레이어가 유추한 3자리 답과 비교해 Stike, Ball을 알려주는 힌트 클래스이다.
    int strike;
    int ball;


    void compareAnswer(Game guessAnswer) {
        // 게임의 정답을 가져온다.
        List<Integer> gameAnswer = Game.getGameAnswer();
        // 각 자리별로 비교하면 Strike, Ball을 계산한다.
        for (int digit = 0; digit < gameAnswer.size(); digit++) {
            int curNumber = Game.guessNumber.get(digit);

            if (isStrike(gameAnswer, curNumber, digit)) {
                addStrikeCount();
            }
            if (isBall(gameAnswer, curNumber, digit)) {
                addBallCount();
            }
        }
    }

    // 유저에게 Strike와 Ball 값을 출력해주는 매서드.
    public String getResult() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + "볼";
        }
        if (this.strike != 0) {
            // 볼이 있으면 띄어쓰기 하기
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + "스트라이크";
        }
        if (result.equals("")) {
            result = "낫싱";
        }

        return result;
    }

    public void showResult() {
        System.out.println(getResult());
    }

    private void addStrikeCount() {
        this.strike++;
    }

    private void addBallCount() {
        this.ball++;
    }

    private boolean isStrike(List<Integer> gameAnswer, int number, int index) {
        // 해당 인덱스의 리스트 안에 있는 원소와 숫자를 비교하여 같으면 Strike 이다.
        if (gameAnswer.get(index) == number) {
            return true;
        }
        return false;
    }

    private boolean isBall(List<Integer> gameAnswer, int number, int index) {
        // 원소가 리스트 안에 있고 해당 인덱스에 있지 않으면, Ball 이다.
        if (gameAnswer.contains(number) && gameAnswer.get(index) != number) {
            return true;
        }
        return false;
    }


}

