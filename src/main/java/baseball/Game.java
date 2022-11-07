package baseball;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final String END_MESSAGE = "게임 종료";

    public Game(){
        Computer baseball = new Computer(computerNum);
    }

    void start(){
        printStartMessage();
        User user = new User(computerNum,userNum);
    }

    void printStartMessage(){
        System.out.println(START_MESSAGE);
    }

    void end(){
       printEndMessage();
    }

    void printEndMessage(){
        System.out.println(END_MESSAGE);
    }

    void chooseGameConditions(){
        GameCondition condition = new GameCondition();
    }
}
