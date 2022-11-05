package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNums implements Nums{
    List<Integer> nums = new ArrayList<>();

    public PlayerNums() {

    }

    @Override
    public void setNums() {
        this.nums = Arrays.stream(Console.readLine().trim().split("")).map(Integer::parseInt).collect(
                Collectors.toList());
    }

    @Override
    public List<Integer> getNums() {
        return this.nums;
    }
}
