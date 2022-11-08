package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static final List<Integer> ALLOWED_NUMBER = List.of(1,2,3,4,5,6,7,8,9);

    public static void checkInputLength (String userInputString) throws IllegalArgumentException {
        if (userInputString.length()!=3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputValue (List<Integer> userInput) throws IllegalArgumentException {
        for (int i=0; i<userInput.size(); i++){
            if (!ALLOWED_NUMBER.contains(userInput.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkEndGameInput(String userInputString) throws IllegalArgumentException {
        if (userInputString.equals("1")||userInputString.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size()<3) {
            int pickedNumber = pickNumberInRange(1,9);
            if(!answer.contains(pickedNumber)) {
                answer.add(pickedNumber);
            }
        }
        return answer;
    }

    public static List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputString = readLine();
        List<Integer> userInput = new ArrayList<>();
        checkInputLength(userInputString);
        for (int i=0; i<userInputString.length(); i++) {
            userInput.add(Character.getNumericValue(userInputString.charAt(i)));
        }
        checkInputValue(userInput);
        return userInput;
    }

    public static int checkBall (List<Integer> answer, List<Integer> userInput) {
        int howManyBall = 0;
        for (int i=0; i<3; i++) {
            if (answer.contains(userInput.get(i))) {
                howManyBall++;
            }
        }
        return howManyBall;
    }

    public static int checkStrike (List<Integer> answer, List<Integer> userInput) {
        int howManyStrike = 0;
        for (int i=0; i<userInput.size(); i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                howManyStrike++;
            }
        }
        return howManyStrike;
    }

    public static void printStrikeAndBall (int ball, int strike) {
        if (ball==0 && strike==0) {
            System.out.println("낫싱");
        }
        if (ball>0 && strike==0) {
            System.out.println(ball+"볼");
        }
        if (ball==0 && strike>0) {
            System.out.println(strike+"스트라이크");
        }
        if (ball>0 && strike>0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public static boolean returnAnswer (List<Integer> answer, List<Integer> userInput) {
        int ball = checkBall(answer,userInput);
        int strike = checkStrike(answer,userInput);
        ball = ball-strike;
        printStrikeAndBall(ball,strike);
        return strike==3;
    }

    public static boolean endGame() {
        boolean quit = false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueOrQuit = readLine();
        checkEndGameInput(continueOrQuit);
        if (continueOrQuit.equals("2")) {
            quit = true;
        }
        return quit;
    }

    public static boolean playBaseball() {
        List<Integer> answer = makeAnswer();
        boolean isCorrect;
        boolean quitGame;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> userInput = getUserInput();
            isCorrect = returnAnswer(answer,userInput);
            if (isCorrect) {
                quitGame = endGame();
                break;
            }
        }
        return quitGame;
    }

    public static void main(String[] args) {
        boolean quitGame = false;
        while (!quitGame) {
            quitGame = playBaseball();
        }
    }
}
