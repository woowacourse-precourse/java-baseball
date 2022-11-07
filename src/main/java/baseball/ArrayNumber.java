package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ArrayNumber {
    private static final int cnt_nbr = 3;
    private static final int min_nbr = 1;
    private static final int max_nbr = 9;
    private static final String str_input = "숫자를 입력해주세요 : ";
    private static final String minus = "^["+ min_nbr +"-"+ max_nbr +"]*$";

    private int[] digits;

    public ArrayNumber() {}
}