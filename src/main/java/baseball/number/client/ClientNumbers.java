package baseball.number.client;

import baseball.utils.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientNumbers {

   private Validation validation = new Validation();

    public List<Integer> clientNumberToList(String number){

        System.out.println(number);
        String clientInput = validation.validateClientNumbers(number);

        List<Integer> digitNumbers = stringToNumberList(clientInput);
        return digitNumbers;
    }

    public List<Integer> stringToNumberList(String number) {
        List<Integer> clientNumberList = new ArrayList<>();
        String[] strNumberArr = number.split("");
        for(String strNumber : strNumberArr) {
            clientNumberList.add(Integer.parseInt(strNumber));
        }
        return clientNumberList;
    }
}
