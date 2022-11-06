package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static int checkBall (List<Integer> answer, List<Integer> userInput) {
        int howManyBall = 0;
        for (int i=0; i<3; i++) {
            if (answer.contains(userInput.get(i))) {
                howManyBall++;
            }
        }
        return howManyBall;
    }

    public static void exceptionHandling (String userInputString) throws IllegalArgumentException{
        if (userInputString.length()!=3) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputString = readLine();
        List<Integer> userInput = new ArrayList<>();
        exceptionHandling(userInputString);
        for (int i=0; i<userInputString.length(); i++) {
            userInput.add(Character.getNumericValue(userInputString.charAt(i)));
        }
        return userInput;
    }

    public static int checkStrike (List<Integer> answer, List<Integer> userInput, int howManyBall) {
        int howManyStrike = 0;
        for (int i=0; i<userInput.size(); i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                howManyStrike++;
                howManyBall--;
            }
        }
        return howManyStrike;
    }

    public static void printStrikeAndBall (int ball, int strike) {
        if (ball==0&&strike==0) {
            System.out.println("낫싱");
        }
        if (ball>0&&strike==0) {
            System.out.println(ball+"볼");
        }
        if (ball==0&&strike>0) {
            System.out.println(strike+"스트라이크");
        }
        if (ball>0&&strike>0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public static boolean returnAnswer (int howManyStrike) {
        if (howManyStrike==3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean endGame() {
        boolean quit = false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueOrQuit = readLine();
        if (continueOrQuit.equals("2")) {
            quit = true;
        }
        return quit;
    }

    public static boolean playBaseball() {
        List<Integer> answer = new ArrayList<>();
        boolean correctAnswer;
        boolean quitGame;
        for (int i=0; i<3; i++) {
            answer.add(pickNumberInRange(0,9));
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> userInput = getUserInput();
            int ball = checkBall(answer,userInput);
            int strike = checkStrike(answer,userInput,ball);
            ball = ball-strike;
            printStrikeAndBall(ball,strike);
            correctAnswer = returnAnswer(strike);
            if (correctAnswer) {
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
