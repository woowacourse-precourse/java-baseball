package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String GAME_STARTS_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_ENDS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GET_USER_NEXT_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final RandomNumberGenerator computer = new RandomNumberGenerator();

    BaseballGame(){
        System.out.print(GAME_STARTS_MESSAGE); // 게임 시작 문구
        computer.generate();
        startGame();
    }

    public static void startGame(){
        UserScore user = new UserScore();

        // 숫자 입력 받고 숫자 맞히기

        // 다음 command

    }
    private static void proceedGame(UserScore user){
        String userInput;

        // 숫자 입력 받으며 숫자 맞히기 게임 진행
        while(true){
            user.init();
            System.out.print(GET_USER_INPUT_MESSAGE);
            userInput = Console.readLine();
            
            // 사용자 입력에 따른 에러 처리
            
            // 볼, 스트라이크 개수 맞추기
            
            // 답에 대한 결과 보여주기
        }
    }
}