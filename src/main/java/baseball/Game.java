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

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = getComputerNum();
        List<Integer> userNum = getUserNum();

    }

    public  List<Integer> getUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();

        int num = validateNum(s);
        List<Integer> userNum = convertInttoList(num);
        validateRangeForAll(userNum);
        validateDigit(userNum);
        validateDuplication(userNum);

        return userNum;

    }
    public void validateRangeForAll(List<Integer> nums){
        for(int elem : nums){
            validateRange(elem);
        }
    }
    public List<Integer> convertInttoList(int num){
        int[] array = Stream.of(String.valueOf(num)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }


    //입력이 숫자가 아닌 경우
    public static int validateNum(String s) {
        try {
            int num = Integer.parseInt(s);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외 문자가 입력되었습니다.");
        }
    }

    //1~9 범위가 아닌 숫자
    public void validateRange(int num) {
        if(num > 9 || num < 1 ){
            throw new IllegalArgumentException("입력된 숫자가 범위를 초과했습니다.");
        }
    }
    //3자리 수 입력이 아닌 경우
    public void validateDigit(List<Integer> nums){
        if(nums.size() != 3){
            throw new IllegalArgumentException("세 자리 수가 아닙니다.");
        }
    }
    //중복
    public void validateDuplication(List<Integer> nums){
        if(nums.size() != nums.stream().distinct().count()){
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
