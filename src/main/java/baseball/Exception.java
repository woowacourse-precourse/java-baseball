package baseball;

public class Exception {

    public void numberException(String number){
        System.out.println("예외 처리 진입");
        if(!number.matches("[1-9]]")){
            System.out.println("Exception");
            throw new IllegalArgumentException();
        }
    }

}
