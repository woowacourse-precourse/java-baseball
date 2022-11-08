package baseball;

import java.util.List;

public class GameMessage {
    public void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printInputNumberToComputerMessage() {
        System.out.print("숫자를 입력해 주세요: ");
    }

    public void printRestartOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printHintMessage(List<Integer> hitStatus) {
        //아무것도 없을 때
        if (hitStatus.get(0) == 0 && hitStatus.get(1) == 0) {
            System.out.println("낫싱");
        }

        //ball만 있을 때
        if (hitStatus.get(1) == 0 && hitStatus.get(0) != 0) {
            System.out.println(hitStatus.get(0) + "볼");
        }

        //strike만 있을 때
        if (hitStatus.get(0) == 0 && hitStatus.get(1) != 0) {
            System.out.println(hitStatus.get(1) + "스트라이크");
        }

        //둘 다 있을 때
        if (hitStatus.get(0) != 0 && hitStatus.get(1) != 0) {
            System.out.println(hitStatus.get(0) + "볼 " + hitStatus.get(1) + "스트라이크");
        }
    }
}
