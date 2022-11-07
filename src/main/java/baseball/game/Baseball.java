    private boolean checkProgress() {
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        switch (number) {
            case RESTART_GAME:
                return true;
            case FINISH_GAME:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }
    private void printStartMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printEndMessage() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임을 종료합니다. \n");
    }

    private void prinGameEndMessage() {
        System.out.print("게임 종료");
    }

    private void printRestartOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
