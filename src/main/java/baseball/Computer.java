package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> computerNumberList; // 컴퓨터 숫자(서로 다른 임의의 숫자 세 개)를 담고 있는 Arraylist

    public Computer() // 객체 생성 시, 자동으로 컴퓨터 숫자가 정해짐
    {
        generateComputerNumberList();
    }

    private void generateComputerNumberList() // 무작위로 컴퓨터 숫자 정함
    {
        ArrayList<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        this.computerNumberList = numberList;
    }
}
