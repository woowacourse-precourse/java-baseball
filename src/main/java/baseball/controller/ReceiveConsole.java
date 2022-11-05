package baseball.controller;

import baseball.dto.NumListDto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ReceiveConsole {

    public static NumListDto receiveNumIncludeAllException() throws IllegalArgumentException {
        NumListDto numListDto;
        try {
            numListDto = receiveNum();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return numListDto;
    }

    private static NumListDto receiveNum() throws IllegalArgumentException{
        List<Integer> numList = new ArrayList<>();
        String numString = Console.readLine();
        for (int i = 0; i < numString.length(); i++) {
            numList.add((int) (numString.charAt(i)-'0'));
        }
        NumListDto numListDto = new NumListDto(numList);

        NotValidInputException(numListDto);

        return numListDto;
    }

    private static void NotValidInputException(NumListDto numListDto) {
        if (!Valid.isValidNumList(numListDto.getNumList())) {
            throw new IllegalArgumentException();
        }
    }


}
