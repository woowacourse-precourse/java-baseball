package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public boolean isEnd(String number){

        int tempNum = Integer.parseInt(number);

        if (tempNum == 1){
            return true;
        } else if (tempNum == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public boolean CheckInput(String number){

        int tempNum = Integer.parseInt(number);

        if (100 <= tempNum && tempNum < 1000){
            return true;
        }
        throw new IllegalArgumentException();
    }


}
