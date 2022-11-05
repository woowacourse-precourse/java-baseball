package baseball.view;

import baseball.dto.NumListDto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ReceiveConsole {

    public static NumListDto receiveNum(){
        List<Integer> numList = new ArrayList<>();
        String numString = Console.readLine();
        for (int i = 0; i < numString.length(); i++) {
            numList.add((int) numString.charAt(0));
        }
        NumListDto numListDto = new NumListDto(numList);
        return numListDto;
    }
}
