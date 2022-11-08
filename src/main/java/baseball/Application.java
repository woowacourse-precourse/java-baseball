package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int input;
        System.out.println("숫자 야구 게임을 시작합니다 \n");
        while(True) {
            input = sc.nextint();
            if(input == 1){
                continue;
            }
            if(input == 2) {
                return;
            }
            if(input < 100 || input >= 1000){
                return;
            }
            check(input);

        }
    }
    static void check(int in) {

        return;
    }
}
