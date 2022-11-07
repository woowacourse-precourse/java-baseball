package baseball.dto;

import java.util.List;

public class User {

    // 유저가 입력한 숫자가 저장되어 있는 Integer형 리스트
    List<Integer> usersNumber;

    // User 클래스 생성자
    public User(List<Integer> numberList) {
        this.usersNumber = numberList;
    }

    // userNumber값을 얻기 위한 Getter
    public List<Integer> getUsersNumber () {
        return usersNumber;
    }

}
