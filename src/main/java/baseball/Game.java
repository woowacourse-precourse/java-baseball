package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    static final int START_RANGE = 1;
    static final int END_RANGE = 9;
    static final int NUMBER_TOTAL = 3;
    static final int NEW_GAME = 1;
    static final int END_GAME = 2;

    static final String GET_USERNUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    static final String SUCCESS_MESSAGE = Game.NUMBER_TOTAL + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + Game.NEW_GAME + ", 종료하려면 " + Game.END_GAME + "를 입력하세요.";
    int[] number = new int[3];

    Game() {
        int currentRandomNumber;
        int currentNumberIndex = 0;

        while (currentNumberIndex < 3) {
            currentRandomNumber = this.getRandomNumber();
            if(!Function.checkArrayContain(number, currentRandomNumber)){
                number[currentNumberIndex] = currentRandomNumber;
                currentNumberIndex++;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.NUMBER_TOTAL; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(Game.START_RANGE, Game.END_RANGE);
    }

    public static void init(Game computerAnswer) {
        Game userAnswer = Game.getAnswer();

        Hint hint = new Hint();
        hint.checkAnswer(userAnswer, computerAnswer);
        hint.showHint();

        if(hint.strike != Game.NUMBER_TOTAL){
            Game.init(computerAnswer);
            return;
        }

        int newGameChoice = Game.checkNewGame();
        if(newGameChoice == Game.NEW_GAME) {
            computerAnswer = new Game();
            Game.init(computerAnswer);
        }
    }

    private static int checkNewGame() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_CHECK_MESSAGE);

        String newGameAnswer = readLine();
        int newGameAnswerValue;
        try {
            newGameAnswerValue = Integer.parseInt(newGameAnswer);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if (newGameAnswerValue != Game.NEW_GAME && newGameAnswerValue != Game.END_GAME) {
            throw new IllegalArgumentException();
        }

        return newGameAnswerValue;
    }

    private static Game getAnswer() {
        System.out.print(GET_USERNUMBER_MESSAGE);
        String userInput = readLine();
        Game.checkInputValue(userInput);

        return new Game(userInput);
    }

    private static void checkInputValue(String userInput) {
        if (!Game.checkInputLength(userInput)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkInputNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkEqualNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInputLength(String str){
        return str.length() == 3;
    }

    static boolean checkInputNumber(String str){
        try{
            int numberValue = Integer.parseInt(str);
        } catch(NumberFormatException e){
            return false;
        }
        char[] numberArray = new char[str.length()];
        return !Function.checkArrayContain(numberArray, '0');
    }

    static boolean checkEqualNumber(String str){
        char[] checkEqual = new char[str.length()];
        char[] word = Function.getCharArrayToString(str);

        for (int i = 0; i < str.length(); i++){
            if (Function.checkArrayContain(checkEqual, word[i])){
                return false;
            }
            checkEqual[i] = word[i];
        }
        return true;
    }
}