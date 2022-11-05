package baseball.number.client;

import baseball.utils.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClientNumbers {

    private final Validation validation;

    public ClientNumbers(Validation validation) {
        this.validation = validation;
    }

    public List<Integer> clientNumberToList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String clientInput = "";
        try{
            clientInput = validation.validateClientNumbers(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("문자 변환 오류");
        }

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
