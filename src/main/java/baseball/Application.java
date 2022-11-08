package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public boolean isEnd(String number){

        int temp_num = Integer.parseInt(number);

        if (temp_num == 1){
            return true;
        } else if (temp_num == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
