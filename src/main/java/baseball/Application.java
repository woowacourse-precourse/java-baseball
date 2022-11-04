package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        while (true) {
            int flag = 0;
            Computer computer = new Computer();
            List<Character> computerList = computer.makeRandomNum();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                Input input = new Input();
                List<Character> userList = input.readAndMakeInputList();
                CompareTwoList compareTwoList = new CompareTwoList();
                Output output = new Output();
                List<Integer> strikeBalls = compareTwoList.compareLists(computerList, userList);
                output.printStrikeBall(strikeBalls);
                if (strikeBalls.equals(List.of(3, 0))) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    EndOrRe endOrRe = new EndOrRe();
                    Integer oneOrTwo = endOrRe.readAndMakeInputList();
                    if (oneOrTwo == 1) {
                        break;
                    }
                    if (oneOrTwo == 2) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}
