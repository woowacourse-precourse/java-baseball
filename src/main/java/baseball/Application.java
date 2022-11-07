package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        StartNumberBaseballGame();
    }

    public static void StartNumberBaseballGame(){
        List<Integer> computer;
        do{
            computer = GenerateComputerNumbers();
            StartGuessingPhase(computer);
        }while(StartQuestioningPhase());
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

    public static boolean StartQuestioningPhase() {
        String input;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if(input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1과 2만 허용됩니다.");
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
            if(strike == 3){
                System.out.println();
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        System.out.println();
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
        CheckPlayerNumbersException(player);
        return player;
    }

    public static void CheckPlayerNumbersException(List<Integer> player){
        HashSet<Integer> checkSet = new HashSet<>(player);
        if(checkSet.size() != player.size()){
            throw new IllegalArgumentException("중복된 숫자가 감지되었습니다.");
        } if(player.size() != 3){
            throw new IllegalArgumentException("숫자를 3개만 입력해주세요.");
        }
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
