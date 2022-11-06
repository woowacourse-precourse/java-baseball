package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void playGame(List<Integer> computer){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();

            String[] inputSplits = input.split("");
            int[] inputNumbers = Arrays.stream(inputSplits).mapToInt(Integer::valueOf).toArray();

            printNumberStatus(inputNumbers, computer);

        }
    }

    private static void printNumberStatus(int[] inputNumbers, List<Integer> computer){
        GameStatus gameStatus = new GameStatus();

        for(int i = 0 ; i < inputNumbers.length; i++){
            if( !computer.contains( inputNumbers[i] ) ){ //해당 숫자가 정답에 없다.
                gameStatus.nothing = true;
            } else { //포함은 되어 있다.
                if(i == computer.indexOf(inputNumbers[i])){ //스트라이크인 경우
                    gameStatus.strike++;
                } else gameStatus.ball++; //볼인 경우
            }
        }

    }

    public static class GameStatus{
        Boolean nothing = false;

        Integer ball = 0;

        Integer strike = 0;

    }
}
