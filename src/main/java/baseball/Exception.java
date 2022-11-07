package baseball;

public class Exception {

    public void inpuutNumberException(String number){
        System.out.println("예외 처리 진입");
        if(number.length() < 3 || number.contains("0")){
            System.out.println("Exception");
            throw new IllegalArgumentException();
        }
    }

}
