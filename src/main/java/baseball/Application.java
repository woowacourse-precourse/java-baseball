package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        inputThreeDistinctDigits();

    }

    public static char[] inputThreeDistinctDigits () {
        System.out.print("숫자를 입력해주세요 : ");
        String whatClientInputs = Console.readLine();
        if(whatClientInputs.isBlank()||whatClientInputs.length()!=3) {
            makeException();
        }
        if(whatClientInputs.charAt(0)==whatClientInputs.charAt(1)
            ||whatClientInputs.charAt(1)==whatClientInputs.charAt(2)
            ||whatClientInputs.charAt(0)==whatClientInputs.charAt(2)){
            makeException();
        }
        if(isNumber(whatClientInputs)==false){
            makeException();
        }
        char[] guessedNumbers = whatClientInputs.toCharArray();
        return guessedNumbers;
    }

    public static void makeException(){
        System.out.println("올바르지 않은 입력입니다. 프로그램을 종료합니다.");
        throw new IllegalArgumentException();
    }

    public static boolean isNumber(String something) {
        for(int charIndex= 0; charIndex<something.length(); charIndex++){
            //ASCII Code ((int)'0')==48, ((int)'9'==57)
            if((int)something.charAt(charIndex)<48||(int)something.charAt(charIndex)>57) {
                return false;
            }
        }
        return true;
    }
}
