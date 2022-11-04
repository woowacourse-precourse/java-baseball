package repository;

import data.UserData;
import util.Utils;

import java.util.List;

public class UserRepository {
    private UserData userData;

    public UserRepository(UserData userData) {
        this.userData = userData;
    }

    public String inputanswer(String userInput) throws IllegalArgumentException {
        String answer = checkinputint(userInput);
        userData.setUserData(answer);
        return userInput;
    }

    //넣은 값이 숫자인지 확인
    private String checkinputint(String userInput) throws IllegalArgumentException{//숫자만 입력되었는지 확인
        try{
            Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return checkinputlenth(userInput);
    }

    //답의 길이가 3개인지 확인
    private String checkinputlenth(String userInput) throws IllegalArgumentException{
        if(userInput.length()!= Utils.Numlen)
            throw new IllegalArgumentException();
        return checkinputoverlap(userInput);
    }

    //답의 숫자가 중복되는지 확인
    private String checkinputoverlap(String userInput) throws IllegalArgumentException{
        if(userInput.charAt(0)==userInput.charAt(1)
                || userInput.charAt(0)==userInput.charAt(2)
                || userInput.charAt(1)==userInput.charAt(2))
            throw new IllegalArgumentException(userInput);
        return validinput(userInput);
    }

    //답에 0이 포함되어 있는 지 확인
    private String validinput(String userInput) throws IllegalArgumentException{
        if(userInput.contains("0"))
            throw new IllegalArgumentException();
        return userInput;
    }

    public List<Integer> getUserData(){
        return userData.getUserData();
    }

}