package baseball.service;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerService {
    private static final int LIST_SIZE = 3;
    Computer computer = new Computer();

    /**
     * 리스트에 1부터 9 사이의 겹치지 않는 숫자를 더한다.
     *
     * @param numbers 숫자를 담은 리스트
     */
    private static void addNumberToList(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    /**
     * 컴퓨터의 랜덤 숫자들을 초기화한다.
     *
     * @return computer
     */
    public void initComputer() {
        computer.setNumbers(getRandomNumbers());
    }

    /**
     * 컴퓨터를 가져온다.
     *
     * @return 컴퓨터
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * 겹치지 않는 랜덤 숫자를 LIST_SIZE 만큼 가져온다.
     *
     * @return 랜덤 숫자들
     */
    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        while (numbers.size() < LIST_SIZE) {
            addNumberToList(numbers);
        }
        return numbers;
    }
}
