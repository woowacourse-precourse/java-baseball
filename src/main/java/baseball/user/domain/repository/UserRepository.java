package baseball.user.domain.repository;

import baseball.user.domain.User;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private UserRepository(){}
    private User user;
    public static UserRepository getInstance(){
        return instance;
    }
    public void createUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
}
