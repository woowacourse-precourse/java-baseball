package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private static final int DIGIT = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    private List<Integer> computerNum;
    private List<Integer> userNum;
    private int strike = 0;
    private int ball = 0;
    private boolean nothing = false;

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = getComputerNum();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        userNum = getUserNum(input);
        calculateScore();


    }

    public void calculateScore() {
        for(int i = 0; i < DIGIT; i++){
             checkIfStrikeOrBall(i);
        }
        nothing = checkIfNothing();
    }

    public boolean checkIfNothing(){
        if(strike==0 && ball==0){
            return true;
        }
        return false;
    }

    public void checkIfStrikeOrBall(int index) {
        if (isStrike(index))
            strike++;
        if (isBall(index))
            ball++;
    }

    public boolean isBall(int index){
        return !isStrike(index) && computerNum.contains(userNum.get(index));
    }
    public boolean isStrike(int index){
        return computerNum.get(index) == userNum.get(index);
    }


    public List<Integer> getUserNum(String input) {
        int num = validateNum(input);
        List<Integer> userNum = convertInttoList(num);
        validateRangeForAll(userNum);
        validateDigit(userNum);
        validateDuplication(userNum);

        return userNum;

    }

    public void validateRangeForAll(List<Integer> nums) {
        for (int elem : nums) {
            validateRange(elem);
        }
    }

    public List<Integer> convertInttoList(int num) {
        int[] array = Stream.of(String.valueOf(num)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int validateNum(String s) {
        try {
            int num = Integer.parseInt(s);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외 문자가 입력되었습니다.");
        }
    }

    public void validateRange(int num) {
        if (num > 9 || num < 1) {
            throw new IllegalArgumentException("입력된 숫자가 범위를 초과했습니다.");
        }
    }

    public void validateDigit(List<Integer> nums) {
        if (nums.size() != 3) {
            throw new IllegalArgumentException("세 자리 수가 아닙니다.");
        }
    }

    public void validateDuplication(List<Integer> nums) {
        if (nums.size() != nums.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }


    public List<Integer> getComputerNum() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            computer.add(randomNumber);
        }
        return convertSettoList(computer);
    }

    private List<Integer> convertSettoList(Set<Integer> set) {
        return new ArrayList<>(set);
    }


}
