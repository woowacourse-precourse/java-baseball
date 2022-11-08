package baseball.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.exceptions.exceptions.exception;
import static baseball.input.inputToint.toInt;

public class userNumber {

    public static List<Integer> user = Collections.emptyList();

    public void inputUser(){
        System.out.print("숫자를 입력해주세요 :");
        String inputNumber_s = Console.readLine();
        List<Integer> number = new ArrayList<>();
        try {
            number = toInt(inputNumber_s);
        }
        catch (NumberFormatException e1){
            throw new IllegalArgumentException("check to argument state");
        }
        if(exception(number)){
            this.user = Collections.emptyList();
        }
        this.user = number;
    }


    public List<Integer> getUser(){
        return user;
    }

    }
