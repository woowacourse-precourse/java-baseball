package domain;

public class UserValidate {
    private static final int SIZE = 3;

    public UserValidate() {
    }

    public void check_size(String input) throws IllegalArgumentException{
        if(input.length() != SIZE){
            throw new IllegalArgumentException();
        }
    }

    public void check_Integer(String input) throws IllegalArgumentException{
        if(!check_int(input)){
            throw new IllegalArgumentException();
        }
    }

    public boolean check_int(String input){
        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            if('0' < input.charAt(i) && input.charAt(i) <= '9'){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
