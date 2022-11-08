package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballGame {
    private static final String GAME_STARTS_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_ENDS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String GET_USER_NEXT_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String NO_BALL_NO_STRIKE = "낫싱";
    private static final String  STRIKE_TEXT = "스트라이크";
    private static final String BALL_TEXT = "볼";

    private static final Integer ZERO = 0;
    private static final Integer NUMBERS_OF_ARRAY = 3;
    private static final Integer GAME_RESTART = 1;
    private static final String INTEGER_NUMBER_REGEX = "^[1-9]*$";

    private static final Integer COMMAND_INPUT_LENGTH = 1;
    private static final List<Integer> COMMANDS_LIST = Arrays.asList(1,2);


    private static final RandomNumberGenerator computer = new RandomNumberGenerator();

    public BaseballGame() {
        System.out.print(GAME_STARTS_MESSAGE);
        computer.generate();
        startGame();
    }

    BaseballGame(String nextGameStarts){
        computer.generate();
        startGame();
    }

    public static void startGame() {
        UserScore user = new UserScore();
        proceedGame(user);

        System.out.println(GAME_ENDS_MESSAGE);
        getNextCommand();
    }

    public static boolean handleErrorForUserCommand(String command) {
        boolean isOneDigitInteger = command.length() == COMMAND_INPUT_LENGTH;
        if(!isOneDigitInteger){
            return false;
        }
        return COMMANDS_LIST.contains(Integer.parseInt(command));
    }

    public static void getNextCommand(){
        System.out.println(GET_USER_NEXT_COMMAND_MESSAGE);
        String userCommand = Console.readLine();

        if (!handleErrorForUserCommand(userCommand)) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(userCommand) == GAME_RESTART) {
            new BaseballGame("new game");
        }
    }

    private static void proceedGame(UserScore user) {
        String userInput;

        while (user.getStrike() != NUMBERS_OF_ARRAY) {
            user.init();
            System.out.print(GET_USER_INPUT_MESSAGE);
            userInput = Console.readLine();

            ArrayList<Integer> userInputArray = handleErrorForUserInput(userInput);

            countBallsAndStrikes(user, userInputArray);
            showUserAnswerStatus(user);
        }
    }
    private static void showUserAnswerStatus(UserScore user){
        int ball = user.getBall();
        int strike = user.getStrike();

        if(ball == ZERO){
            if (strike == ZERO){
                System.out.println(NO_BALL_NO_STRIKE);
            }else{
                System.out.println(strike + STRIKE_TEXT);
            }
        }else{
            if(strike == ZERO){
                System.out.println(ball + BALL_TEXT);
            }else{
                System.out.println(ball + BALL_TEXT + " " + strike + STRIKE_TEXT);
            }
        }
    }

    private static void countStrikes(UserScore user, ArrayList<Integer> inputArray) {
        for(int i=0;i<NUMBERS_OF_ARRAY;i++){
            if(computer.getRandomNumberAt(i) == inputArray.get(i)){
                user.addStrike();
            }
        }
    }

    private static void countBalls(UserScore user, ArrayList<Integer> inputArray) {
        for (int number : inputArray) {
            if (computer.randomNumberList.contains(number)) {
                user.addBall();
            }
        }
    }

    private static void countBallsAndStrikes(UserScore user, ArrayList<Integer> inputArray) {
        countBalls(user, inputArray);
        countStrikes(user, inputArray);
    }

    private static boolean isIntegerInRange(String value){
        return Pattern.matches(INTEGER_NUMBER_REGEX, value);
    }
    private static boolean isThreeDigit(String value){
        return value.length() == NUMBERS_OF_ARRAY;
    }

    private static ArrayList<Integer> toIntArray(String intValue){
        ArrayList<Integer> intArray = new ArrayList<>();

        for(char ch:intValue.toCharArray()){
            int recentNumber = Integer.parseInt(String.valueOf(ch));
            if (intArray.contains(recentNumber)){
                throw new IllegalArgumentException();
            }
            intArray.add(recentNumber);
        }
        return intArray;
    }

    public static ArrayList<Integer> handleErrorForUserInput(String userInput) {
        if (!(isIntegerInRange(userInput) && isThreeDigit(userInput))) {
            throw new IllegalArgumentException();
        }

        return toIntArray(userInput);
    }
}
