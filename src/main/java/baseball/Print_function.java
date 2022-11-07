package baseball;

public class Print_function {

    public void start_sentence() {
        System.out.println("숫자야구 게임을 시작합니다.");
    }

    public void input_sentence() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void input_number_sentence(String digits) { System.out.println(digits);}

    public void result_sentence(Integer ball, Integer strike) {
        String ball_str = String.valueOf(ball);
        String strike_str = String.valueOf(strike);
        String result = "";

        if(ball>0){
            result += ball_str;
            String BALL_SENTENCE = "볼";
            result += BALL_SENTENCE;
            result += " ";
        }

        if(strike>0){
            result += strike_str;
            String STRIKE_SENTENCE = "스트라이크";
            result += STRIKE_SENTENCE;
        }

        if(ball == 0 && strike == 0){
            result = "낫싱";
        }

        System.out.println(result);
    }

    public void correct_sentence() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restart_sentence() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void restart_integer_sentence(Integer input_restart) {
        System.out.println(input_restart);
    }

    public void end_sentence() {
        System.out.println("숫자야구 게임을 종료합니다.");
    }
}
