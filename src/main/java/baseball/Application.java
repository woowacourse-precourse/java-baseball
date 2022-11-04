package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        StartNumberBaseballGame();
    }

    public static void StartNumberBaseballGame(){
        List<Integer> computer = GenerateComputerNumbers();
        StartGuessingPhase(computer);
    }
    public static void StartGuessingPhase(List<Integer> computer) {
        List<Integer> player;
        int strike = 0;
        int ball = 0;
        while(strike != 3) {
            player = GeneratePlayerNumbers();
            strike = CheckStrike(computer, player);
            ball = CheckBall(computer, player) - strike;
            PrintResult(strike, ball);
        }
    }

    public static void PrintResult(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;
        }
        if(ball > 0){
            System.out.print(ball + "볼 ");
        }
        if(strike > 0){
            System.out.print(strike + "스트라이크");
        }
    }
    public static int CheckStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int index = 0; index < computer.size(); index ++){
            if(computer.get(index) == player.get(index)){
                strike ++;
            }
        }
        return strike;
    }

    public static int CheckBall(List<Integer> computer, List<Integer> player){
        int ball = 0;
        for(int index = 0; index< computer.size(); index ++){
            if(computer.contains(player.get(index))){
                ball++;
            }
        }
        return ball;
    }

    public static List<Integer> GeneratePlayerNumbers(){
        List<Integer> player = new ArrayList<>();
        String input = Console.readLine();
        int tempNumbers = Integer.parseInt(input);
        int divider = (int)Math.pow (10, input.length() -1 );
        while(divider > 0){
            player.add(tempNumbers / divider);
            tempNumbers = tempNumbers - (player.get(player.size() - 1)) * divider;
            divider = divider / 10;
        }
        return player;
    }

    public static List<Integer> GenerateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        String input = Console.readLine();
//        System.out.println(input);
//        System.out.println(computer);
