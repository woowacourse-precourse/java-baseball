package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public int checkBall (List<Integer> answer, List<Integer> userInput) {
        int howManyBall = 0;
        for (int i=0; i<3; i++) {
            if (answer.contains(userInput.get(i))) {
                howManyBall++;
            }
        }
        return howManyBall;
    }

    public List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputString = readLine();
        List<Integer> userInput = new ArrayList<>();
        for (int i=0; i<3; i++) {
            userInput.add(Character.getNumericValue(i));
        }
        return userInput;
    }

    public int checkStrike (List<Integer> answer, List<Integer> userInput, int howManyBall) {
        int howManyStrike = 0;
        for (int i=0; i<3; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                howManyStrike++;
                howManyBall--;
            }
        }
        return howManyStrike;
    }

    public boolean returnAnswer (int howManyBall, int howManyStrike) {
        if (howManyStrike==3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean endGame() {
        boolean quit = false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueOrQuit = readLine();
        if (continueOrQuit.equals("2")) {
            quit = true;
        }
        return quit;
    }

    public boolean playBaseball() {
        List<Integer> answer = new ArrayList<>();
        boolean correctAnswer;
        boolean quitGame;
        for (int i=0; i<3; i++) {
            answer.add(pickNumberInRange(0,9));
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> userInput = getUserInput();
        while(true) {
            int ball = checkBall(answer,userInput);
            int strike = checkStrike(answer,userInput,ball);
            ball = ball-strike;
            correctAnswer = returnAnswer(ball,strike);
            if (correctAnswer) {
                quitGame = endGame();
                break;
            }
        }
        return quitGame;
    }

    public static void main(String[] args) {
    }
}
