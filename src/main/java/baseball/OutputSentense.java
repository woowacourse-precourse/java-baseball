package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputSentense {
    public String start = "숫자 야구 게임을 시작합니다.";
    public String inputNumber = "숫자를 입력해 주세요 : ";
    public String restart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public String ending = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public String reQuestion = "1,2가 아닙니다 다시 입력해 주세요";
    public String nothing = "낫싱";
    public String strike =  "스트라이크";
    public String ball = "볼";

    public  OutputSentense(){
    }

    public String Question(String str, int gameTypeNumber)throws IllegalArgumentException  {
        System.out.println(str);
        String myNumber = Console.readLine();
        if (myNumber.length() != gameTypeNumber) {
            throw new IllegalArgumentException();
        }
        return myNumber;
    }

}
