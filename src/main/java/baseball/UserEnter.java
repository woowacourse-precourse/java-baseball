package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.HashSet;

public class UserEnter {
    public static void main(String[] args) {

    }

    public static void userEnterNum() throws RedundantException, SizeException, NaturalException {
        List <Integer> user = new ArrayList<>();
        Set<Integer> userSet;



        int strikeNball = 0;
        int strike = 0;
        int ball = 0;
        int userNumber = 0;
        int attempt = 0;

        attempt =attempt+1;

        System.out.printf("[%d차시도] 숫자를 입력해주세요: ",attempt);
        userNumber =Integer.parseInt(Console.readLine());

        int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
        user = new ArrayList<>();
        for(
                int order = 0;
                order<digits.length;order++)
        {
            user.add(digits[order]);
        }

        userSet = new HashSet<>(user);

        if (userSet.size() != user.size()) {
            throw new RedundantException("중복되는 숫자를 입력할 수 없습니다.");
        }
        if (user.size() != 3) {
            throw new SizeException("숫자 세개를 입력해야 합니다.");
        }
        if (user.contains(0)) {
            throw new NaturalException("1~9 사이의 숫자를 입력해야 합니다.");
        }
    }

    static class RedundantException extends Exception {
        RedundantException(String redundant) {
            super(redundant);
        }
    }
    static class SizeException extends Exception {
        SizeException(String size) {
            super(size);
        }
    }
    static class NaturalException extends Exception {
        NaturalException(String natural) {
            super(natural);
        }
    }
}