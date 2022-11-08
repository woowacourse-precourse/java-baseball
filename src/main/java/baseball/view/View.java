package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public static String gameStartMessage = "숫자 야구 게임을 시작합니다.";
    public static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String GAME_OVER = "게임 종료";
    public static String CORRECT_ANSWER = "개의 숫자를 모두 맞히셨습니다. 게임 종료";
    public static void gameStartMessage(){
        System.out.println(gameStartMessage);
    }

    public static void printBallAndStrike(int strikeNum, int ballNum){
        String result = "";
        if(ballNum > 0)
            result += ballNum + "볼 ";
        if(strikeNum > 0)
            result += strikeNum + "스트라이크";
        if(ballNum == 0 && strikeNum == 0)
            result = "낫싱";
        System.out.println(result);
    }

    public static String inputUserNumber(){
        System.out.println(USER_INPUT_MESSAGE);
        String input = readLine();
        return input;
    }

    public static String askRestartOrExit(String userChoice){
        System.out.println(userChoice);
        String input = readLine();
        return input;
    }
    public static void correctAnswer(int BASEBALL_GAME_NUMBER_LENGTH){
        System.out.println(BASEBALL_GAME_NUMBER_LENGTH + "스트라이크");
        System.out.println(BASEBALL_GAME_NUMBER_LENGTH + CORRECT_ANSWER);
    }
    public static void printGameOverMessage(){
        System.out.println(GAME_OVER);
    }

}
