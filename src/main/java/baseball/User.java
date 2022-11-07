package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private BaseballList baseballList;

    public void setBaseballList() {
        String temp = Console.readLine();
        this.baseballList = new BaseballList(
                Arrays.stream(temp.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }
    public void getUserBaseballList(){
        this.baseballList.getBaseballList();
    }
}
