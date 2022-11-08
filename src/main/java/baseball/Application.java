package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int loopFrequency = 2;
        gameFirstStart();
        boolean gameRunning = true;
        boolean randomInit = false;
        List<Integer> randomNumber = NumberManagement.randomNumberMake(loopFrequency);
        while (gameRunning) {
            int userNumber = gameStart();
            if (randomInit){
                randomNumber = NumberManagement.randomNumberMake(loopFrequency);
                randomInit=false;
            }


            Map<String, Integer> result = NumberScore.numberCount(userNumber, randomNumber, loopFrequency);
            boolean resultCheck = GameResult.resultCase(result);
            if (resultCheck) {
                gameRunning = gameRestart();
                randomInit=true;
                randomNumber.clear();
                result.clear();
            }
        }
    }

    private static void gameFirstStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int gameStart(){

        System.out.print("숫자를 입력해주세요 : ");
        int userNumber = Integer.valueOf(Console.readLine());
        if (100<=userNumber&&userNumber<=999){
            return userNumber;
        }else {
            throw new IllegalArgumentException("범위 밖의 숫자를 입력하셨습니다.");
        }
    }
    public static boolean gameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartPick = Integer.valueOf(Console.readLine());
        if (restartPick == 1) {
            boolean restartBool = true;
            return restartBool;
        }else if (restartPick == 2){
            boolean restartBool = false;
            System.out.println("게임을 종료합니다");
            return restartBool;
        }else{
            throw new IllegalArgumentException("다른 숫자를 입력하셨습니다.");
        }

    }
}
