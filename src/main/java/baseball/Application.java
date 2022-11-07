package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

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
        int[] input_arr = Stream.of(Console.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gameStartConditional(input_arr);



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
