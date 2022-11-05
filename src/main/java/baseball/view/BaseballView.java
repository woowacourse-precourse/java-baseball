package baseball;

import java.util.List;

public class BaseballView {

    public void printGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printHint(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        if (list.get(2) == 3) {
            System.out.println("낫싱");
            return;
        }
        if (list.get(1) == 3) {
            System.out.println("3스트라이크");;
            return;
        }
        if (list.get(0) > 0) {
            sb.append(list.get(0)).append("볼").append(" ");
        }
        if (list.get(1) > 0) {
            sb.append(list.get(1)).append("스트라이크");
        }
        System.out.println(sb);
    }
}
