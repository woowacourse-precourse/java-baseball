package baseball.user.domain.repository;

import baseball.user.domain.User;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private UserRepository(){user=new User();}
    private final User user;
    public static UserRepository getInstance(){
        return instance;
    }
    public User getUser(){
        return user;
    }
}
