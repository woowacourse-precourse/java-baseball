package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
class Computer{
    private List<Integer> computer;
    public Computer(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer=new ArrayList<>();
        newGame(computer);
    }
    private static void newGame(List<Integer> computer){
        selectNumbersByComputer(computer);
    }
    private static void selectNumbersByComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addComputerNumberIfValid(computer, randomNumber);
        }
    }
    private static void addComputerNumberIfValid(List<Integer> integerList, int randomNumber) {
        if (!integerList.contains(randomNumber)) {
            integerList.add(randomNumber);
        }
    }
    public List<Integer> getComputerNumber(){
        return computer;
    }
}
public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        Computer game=new Computer();
    }
}