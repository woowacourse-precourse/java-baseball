package baseball.view;

public enum Views {
    INITIAL_VIEW(() -> System.out.println("숫자 야구 게임을 시작합니다.")),
    INPUT_VIEW(() -> System.out.print("숫자를 입력해주세요 : ")),
    END_VIEW(() -> System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")),
    RESTART_VIEW(() -> System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")),
    FINISH_VIEW(() -> System.out.println("게임종료"));

    private final View view;

    Views(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
