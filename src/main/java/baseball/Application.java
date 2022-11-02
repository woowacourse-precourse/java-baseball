package baseball;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public List<Integer> numList = new ArrayList<>();
    public boolean answer = false;
    public String inputNum = "";

    public Application(){
        createNum();
        startGame();
    }

    public void createNum() {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!answer){
            getInputNum();
        }
    }

    public void getInputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNum = Console.readLine();
    }

    public List<Integer> getNumList() {
        return numList;
    }

    public static void main(String[] args) {
        Application app = new Application();
    }
}
