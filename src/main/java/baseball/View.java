package baseball;

public class View {

    private static class ViewHolder {
        private static final View INSTANCE = new View();
    }

    private View() {

    }

    public static View getInstance() {
        return ViewHolder.INSTANCE;
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
