package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean Shutdown = true;
        while (Shutdown){
            gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            Shutdown = gameBreak();
        }
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean gameBreak(){
        int input = Integer.parseInt(Console.readLine());
        return getBreakConditional(input);
    }

    private static Boolean getBreakConditional(int input) {
        if(input == 2){
            return false;
        } else if (input == 1) {
            return true;
        }else {
            throw new IllegalArgumentException();
        }
    }

    private static void gameStart(){
        List<Integer> computerNumbers = getComputerNumbers();
        boolean iter = true;
        while (iter){
            System.out.print("숫자를 입력해주세요 : ");
            int[] userNumbers = Stream.of(Console.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            gameStartConditional(userNumbers);
            int[] scoreboard = getScoreboard(userNumbers, computerNumbers);
            iter = printScoreboard(scoreboard);
        }
    }



    private static boolean printScoreboard(int[] scoreboard){
        int strike = scoreboard[0];
        int ball = scoreboard[1];
        if (strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (strike==0 && ball==0){
            System.out.println("낫싱");
            return true;
        } else if (strike > 0 && ball > 0){
            System.out.println(ball+"볼"+" "+strike+"스트라이크");
            return true;
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
            return true;
        } else {
            System.out.println(strike+"스트라이크");
            return true;
        }
    }

    private static int[] getScoreboard(int[] userNumbers, List<Integer> computerNumbers) {
        int[] scoreboard = {0,0};
        for (int user_index = 0; user_index < userNumbers.length; user_index++){
            if (computerNumbers.contains(userNumbers[user_index])){
                for (int cpu_index = 0; cpu_index < computerNumbers.size(); cpu_index++){
                    if (userNumbers[user_index]== computerNumbers.get(cpu_index)){
                        if (user_index == cpu_index){
                            scoreboard[0]++; //strike
                            continue;
                        }
                        scoreboard[1]++; //ball
                    }
                }
            }
        }
        return scoreboard;
    }

    private static void gameStartConditional(int[] input_arr) {
        if (getGameStartConditional(input_arr)){
            throw new IllegalArgumentException();
        }
    }

    private static Boolean getGameStartConditional(int[] input_arr) {
        if (input_arr.length == 3 && removeDuplicates(input_arr).length == 3){
            return false;
        }
        return true;
    }
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
