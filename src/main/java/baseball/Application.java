package baseball;

import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();
        Judge judge = new Judge();

        List<Integer> randomNumberList = computer.generateRandomNumberList();

        game.startGame();

        while(true) {
            String input = game.receiveUserNumber();
            user.validateNumber(input);
            
            List<Integer> userNumberList = user.generateNumberList(input);

            //마지막에 삭제
            System.out.println(randomNumberList);

            Integer strikeCnt = judge.countStrike(randomNumberList, userNumberList);
            Integer ballCnt = judge.countBall(randomNumberList, userNumberList, strikeCnt);

            Result result = new Result(strikeCnt, ballCnt);

            result.printResult();

            Integer coin = game.controlGame(result);

            if(coin==2) {
                break;
            }else if(coin==1) {
                randomNumberList = computer.generateRandomNumberList();
            }
        }
    }
}
