package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
    private static final String INTEGER_NUMBER_REGEX = "^[1-9]*$";

    private static final RandomNumberGenerator computer = new RandomNumberGenerator();

    BaseballGame() {
        System.out.print(GAME_STARTS_MESSAGE); // 게임 시작 문구
        computer.generate();
        startGame();
    }

    public static void startGame() {
        UserScore user = new UserScore();

        // 숫자 입력 받고 숫자 맞히기
        proceedGame(user);

        // 다음 command

    }

    private static void proceedGame(UserScore user) {
        String userInput;

        // 숫자 입력 받으며 숫자 맞히기 게임 진행
        while (true) {
            user.init();
            System.out.print(GET_USER_INPUT_MESSAGE);
            userInput = Console.readLine();

            // 사용자 입력에 따른 에러 처리
            ArrayList<Integer> userInputArray = handleErrorForUserInput(userInput);

            // 볼, 스트라이크 개수 맞추기
            countBallsAndStrikes(user, userInputArray);

            // 답에 대한 결과 보여주기
            showUserAnswerStatus(user);

            if(user.getStrike()==3){
                break;
            }
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
                System.out.println(ball + BALL_TEXT + strike + " " + STRIKE_TEXT);
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
        return value.length()==3;
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