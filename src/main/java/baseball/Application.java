package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private boolean isNumber(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfDigit = str.chars()
            .mapToObj(ch -> (char)ch)
            .filter(Character::isDigit)
            .count();
        return numOfDigit == str.length();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
