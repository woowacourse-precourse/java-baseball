package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String GAME_STARTS_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_ENDS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GET_USER_NEXT_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    BaseballGame(){
        startGame();
    }

    public static void startGame(){
        System.out.print(GAME_STARTS_MESSAGE); // 게임 시작 문구

        // 랜덤 정수 배열 생성하기
        RandomNumberGenerator randomNumbers = new RandomNumberGenerator();

        // 숫자 입력 받기
        System.out.print(GET_USER_INPUT_MESSAGE);
        String userInput = Console.readLine();


        // 숫자 맞히기

        // 다음 command

    }
}
