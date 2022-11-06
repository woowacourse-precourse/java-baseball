package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        while(true){
            if( playGame(generateRandomNumber()).equals("2")) break;
        }

    }

    public static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer.get(0));
        System.out.println(computer.get(1));
        System.out.println(computer.get(2));
        return computer;
    }

    public static String playGame(List<Integer> computer){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            System.out.println(input);
            String[] inputSplits = input.split("");
            int[] inputNumbers = Arrays.stream(inputSplits).mapToInt(Integer::valueOf).toArray();

            GameStatus gameStatus = new GameStatus();
            saveNumberStatus(inputNumbers, computer, gameStatus);
            String response = responseNumberStatus(gameStatus);
            System.out.println(response);

            if(gameStatus.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }

        return Console.readLine();
    }

    private static void saveNumberStatus(int[] inputNumbers, List<Integer> computer, GameStatus gameStatus){
        for(int i = 0 ; i < inputNumbers.length; i++){
            if( computer.contains( inputNumbers[i] ) ){ //해당 숫자가 정답에 없다.
                gameStatus.nothing = false;
            }
        }

        if(!gameStatus.nothing){
            for(int i = 0 ; i < inputNumbers.length; i++){
                if(i == computer.indexOf(inputNumbers[i])){ //스트라이크인 경우
                    gameStatus.strike++;
                } else if (computer.contains(inputNumbers[i])) {
                    gameStatus.ball++; //볼인 경우
                }
            }
        }


    }

    private static String responseNumberStatus(GameStatus gameStatus){
        StringBuilder sb = new StringBuilder();

        if(gameStatus.nothing) return "낫싱";
        else {
            if(gameStatus.ball > 0) sb.append(gameStatus.ball).append("볼 ");
            if(gameStatus.strike > 0) sb.append(gameStatus.strike).append("스트라이크 ");
        }
        return sb.toString();
    }
    public static class GameStatus{
        Boolean nothing = true;

        Integer ball = 0;

        Integer strike = 0;

    }
}
