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
    public String strike = "스트라이크";
    public String ball = "볼";

    public OutputSentense() {
    }

    public String Question(String str, int gameTypeNumber) throws IllegalArgumentException {
        System.out.println(str);
        String myNumber = "123";// = Console.readLine();
        try {
            myNumber = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (myNumber == null || myNumber.length() != gameTypeNumber) {
            throw new IllegalArgumentException();
        }
        Integer.parseInt(myNumber);
        return myNumber;
    }

    public void showMessage(String str) {
        System.out.println(str);
    }

    public List<Integer> InputNumberList(String InputNumbers) {
        List<String> InputList = new ArrayList(Arrays.asList(InputNumbers.split("")));
        List<Integer> myList = new ArrayList<>();
        for (String s : InputList) {
            myList.add(Integer.valueOf(s));
        }
        return myList;
    }

    public int escape(String str) {
        int a = Integer.parseInt(str);
        return a;
    }

    public String scoreBoard(int countStrike, int countBall) {
        String sentense;
        String strStrike = String.valueOf(countStrike);
        String strBall = String.valueOf(countBall);
        if (countStrike == 0 && countBall == 0) {
            sentense = nothing;
        } else if (countStrike == 0 && !(countBall == 0)) {
            sentense = strBall + ball;
        } else if (!(countStrike == 0) && countBall == 0) {
            sentense = strStrike + strike;
        } else {
            sentense = strBall + ball + " " + strStrike + strike;
        }
        return sentense;
    }

    public List setRandomNumber(List<Integer> computer, int gameTypeNumber) {
        computer.clear();
        while (computer.size() < gameTypeNumber) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


}
