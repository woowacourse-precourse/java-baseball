package baseball;

class ResponseMessage {
    static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static void allStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void stopProgram() {
        System.out.println("프로그램이 종료되었습니다.");
    }

    static String stopExceptionProgram() {
        return "잘못된 값으로 인해 프로그램이 종료되었습니다.";
    }
}
