package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Game {

    public static Integer state = 0; // 0: 초기시작, 1: 재시작, 2: 종료

    public static String startMessage = "숫자 야구 게임을 시작합니다.";
    public static String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static List<Integer> computer;
    public static List<Integer> user;
    public static List<Integer> ballCount;

    Game(){
        printStartMessage();
        state = 0;
        initGame();
    }

    public void printStartMessage(){
        System.out.println(startMessage);
    }

    public void initGame(){
        buildTarget();
        initUser();
        initBallCount();
    }

    public void initUser(){
        user = new ArrayList<Integer>();
    }

    public void initBallCount(){
        ballCount = new ArrayList<>(List.of(0,0));
    }

    public void buildTarget(){
        computer = new ArrayList<Integer>();
        while(computer.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randNum)){
                computer.add(randNum);
            }
        }
    }


}
