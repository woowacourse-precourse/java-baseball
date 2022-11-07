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
            return true;
        } else if (input == 1) {
            return false;
        }else {
            throw new IllegalArgumentException();
        }
    }

    private static void gameStart(){
        int[] userNumbers = Stream.of(Console.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gameStartConditional(userNumbers);
        List<Integer> computerNumbers = getComputerNumbers();
        int[] scoreboard = getScoreboard(userNumbers, computerNumbers);
        int strike = scoreboard[0];
        int ball = scoreboard[1];
        

    }

    private static int[] getScoreboard(int[] userNumbers, List<Integer> computerNumbers) {
        int[] scoreboard = {0,0};
        for (int user_index = 0; user_index < userNumbers.length; user_index++){
            if (computerNumbers.contains(userNumbers[user_index])){
                for (int cpu_index = 0; cpu_index < computerNumbers.size(); cpu_index++){
                    if (userNumbers[user_index]== computerNumbers.get(cpu_index)){
                        if (user_index == cpu_index){
                            scoreboard[0]++; //strike
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
