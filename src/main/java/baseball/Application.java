package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;


class Computer{
    private List<Integer> numbers = new ArrayList<>();

	public List<Integer> getNumbers(){return this.numbers;}
	public void generateNumbers(){
		while (this.getNumbers().size()<3) {
			int randomNumber = Randoms.pickNumberInRange(1,9);
			if (!this.getNumbers().contains(randomNumber)){
				this.getNumbers().add(randomNumber);
			}
		}
	}
}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
		computer.generateNumbers();

    }
}
