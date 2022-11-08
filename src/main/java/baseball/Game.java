package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Game {

    public static Integer state = 0; // 0: 초기시작, 1: 재시작, 2: 종료

    public static String startMessage = "숫자 야구 게임을 시작합니다.";
    public static String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String inputMessage = "숫자를 입력해주세요 : ";
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

    public void play(){
        while(true){
            swing();
            if(state == 1) {
                initGame();
                state = 0;
            }
            if(state == 2){
                break;
            }
        }
    }

    public void swing(){
        while(ballCount.get(1) < 3){
            buildUser();
            judge();
            showBallCount();
        }
        endGame();
    }

    public void showBallCount(){
        String message = new String();
        String ball = ballCount.get(0).toString();
        String strike = ballCount.get(1).toString();

        if(!ball.equals("0")){
            message += ball + "볼";
        }
        if(!strike.equals("0")){
            if(!message.equals("")) message += " ";
            message += strike+"스트라이크";
        }
        if(ball.equals("0") && strike.equals("0")){
            message += "낫싱";
        }
        System.out.println(message);
    }

    public void judge(){
        ballCount = new ArrayList<Integer>(List.of(0,0));
        for(int index=0; index<3; index++){
            if(!judgeStrike(index)){
                judgeBall(index);
            }
        }
    }

    public boolean judgeStrike(int index){
        boolean strike = computer.get(index) == user.get(index);
        if(strike){
            ballCount.set(1, ballCount.get(1)+1);
        }
        return strike;
    }

    public void judgeBall(int index){
        boolean ball = computer.contains(user.get(index));
        if(ball){
            ballCount.set(0, ballCount.get(0) +1);
        }
    }

    public void buildUser(){
        initUser();
        printInputMessage();

        String userStr = readLine();
        validateUser(userStr);
        setUser(userStr);
    }

    public void printInputMessage(){
        System.out.print(inputMessage);
    }

    public void setUser(String userStr){
        for(int index=0;index<userStr.length();index++){
            int userInt = userStr.charAt(index) - '0';
            user.add(userInt);
        }
    }

    public void validateUser(String userStr){
        if(userStr.length() != 3) {
            throw new IllegalArgumentException("입력값은 세자리로 이뤄져야 합니다.");
        }

        for(int idx=0; idx<userStr.length(); idx++){
            int nowInt = userStr.charAt(idx) - '0';
            if(nowInt < 1 || nowInt > 9){
                throw  new IllegalArgumentException("입력값은 1에서 9 사이 수로 이뤄져야 합니다.");
            }
            if(user.contains(nowInt)){
                throw new IllegalArgumentException("입력값은 서로 다른 3개의 수로 이뤄져야 합니다.");
            }
        }
    }

    public Integer confirmRestart(){
        int input = Integer.parseInt(readLine());
        if(input != 1 && input != 2){
            throw new IllegalArgumentException("1 혹은 2 이외의 값이 입력되었습니다.");
        }

        return input;
    }

    public void restart(){
        System.out.println(restartMessage);
        state = confirmRestart();
    }

    public void printEndMessage(){
        System.out.println(endMessage);
    }

    public void endGame(){
        printEndMessage();
        restart();
    }

}
