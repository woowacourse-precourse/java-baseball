package baseball.dto;

import java.util.List;

public class Computer {

    // Computer가 랜덤으로 생성한 숫자가 저장되어 있는 Integer형 리스트
    List<Integer> computerNumber;

    // Computer 클래스 생성자
    public Computer(List<Integer> numberList) {
        this.computerNumber = numberList;
    }

    // computerNumer 값을 얻기 위한 Getter
    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
