package controller;

import camp.nextstep.edu.missionutils.Console;
import service.ThreeNumberService;

public class BaseballController {
    private static ThreeNumberService service;

    public BaseballController() {
        service = new ThreeNumberService();
    }

    public void init() {
        service.init();
    }

    public void playGameForever() {
        while(playGame() == 1){
            setReset();
        }
    }

    public int playGame() {
        while(!isEnd()) {
            service.reset();
            service.playGame();
        }

        return ask();
    }

    public int ask() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int answer = Integer.parseInt(Console.readLine());

        if(answer < 1 || answer > 2) {
            throw new IllegalArgumentException();
        }

        return answer;
    }

    public boolean isEnd() {
        if(ThreeNumberService.getStrike() == 3) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setReset() {
        service.reset();
        service.computerReset();
        service.init();
    }
}
