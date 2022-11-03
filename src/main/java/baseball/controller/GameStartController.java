package baseball.controller;


import baseball.service.GameStartService;

import java.util.List;

public class GameStartController {

    public static void startFirstGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        System.out.print("숫자를 입력해주세요 : ");
        getUserNumber();
    }

    private static void getUserNumber() {
        List<Integer> userNumber = GameStartService.getUserNumber();

    }
}


