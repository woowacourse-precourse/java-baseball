package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static final int NEW_GAME_NUMBER = 1;
    static final int END_GAME_NUMBER = 2;

    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 9;
    static final int MAX_ARRAY_SIZE = 3;
    static final int ZERO_VALUE = 0;

    public boolean threeStrike = false;

    public static void main(String[] args) {
        Application app = new Application();
    }

    // TODO : 컴퓨터가 1에서 9까지의 서로다른 임의의 수 3개를 선택한다.
    public List<Integer> SelectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_ARRAY_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    // TODO : 사용자에게 3자리 수를 입력 받는다.
    public List<Integer> selectNumbers() {
        List<Integer> numbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if(isLengthThree(input) && isCorrectRange(input) && isEachOtherDifferent(input)){
            for (char number : input.toCharArray())
                numbers.add(Character.getNumericValue(number));
        }

        return numbers;
    }

    // TODO : 입력 값이 3자리가 아닌 경우 예외를 발생한다.
    public boolean isLengthThree(String input) throws IllegalArgumentException{
        if(input.length() != MAX_ARRAY_SIZE)
            throw new IllegalArgumentException();
        return true;
    }

    // TODO : 입력 값의 범위가 1-9가 아닌 경우 예외를 발생한다.
    public boolean isCorrectRange(String input) throws IllegalArgumentException{
        if(!input.replaceAll("[1-9]", "").isEmpty())
            throw new IllegalArgumentException();
        return true;
    }

    // TODO : 입력 값 중 중복된 숫자가 존재하는 경우 예외를 발생한다.
    public boolean isEachOtherDifferent(String input) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();
        for (char x : input.toCharArray())
            set.add(x);

        if (set.size() != MAX_ARRAY_SIZE)
            throw new IllegalArgumentException();

        return true;
    }

    // TODO : 같은 숫자가 같은 자리에 존재하는 경우의 수 반환
    public int CountingStrike(List<Integer> computer, List<Integer> user){
        int strike = ZERO_VALUE;
        for (int i=0; i<MAX_ARRAY_SIZE; i++){
            if (Objects.equals(computer.get(i), user.get(i)))
                strike += 1;
        }
        return strike;
    }

    // TODO : 같은 숫자가 다른 자리에 존재하는 경우의 수 반환
    public int CountingBall(List<Integer> computer, List<Integer> user){
        int ball = ZERO_VALUE;
        for (int number : user) {
            if (computer.contains(number))
                ball += 1;
        }
        return ball;
    }
}
