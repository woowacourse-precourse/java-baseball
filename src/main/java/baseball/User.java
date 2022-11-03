package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {

	private final List<String> user;

	public User(List<String> user) {
		this.user = user;
	}

	public User(String userBallInput) {
		this.user = makeUserBallsFromUserInput(userBallInput);
	}

	private List<String> makeUserBallsFromUserInput(String userBallInput) {
		return new ArrayList<>(Arrays.asList(userBallInput.split("")));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user1 = (User)o;
		return Objects.equals(user, user1.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}
}
