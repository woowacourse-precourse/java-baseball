package baseball;

public class Output {
    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean scoreMessage(int[] score) {
        if (score[0] == 3) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        if (score[1] != 0) {
            sb.append(score[1]).append("볼 ");
        }
        if (score[0] != 0) {
            sb.append(score[0]).append("스트라이크");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }
        String result = sb.toString();
        System.out.println(result);
        return false;
    }

    public static void endMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
