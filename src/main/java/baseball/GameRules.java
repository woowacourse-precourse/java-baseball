package baseball;

public enum GameRules {
	BALL_NUMBER(3){
		@Override
		public int getValue() {
			return BALL_NUMBER.getValue();
		}
	},
	RESTART(1){
		@Override
		public int getValue() {
			return RESTART.getValue();
		}
	},
	END(2){
		@Override
		public int getValue() {
			return END.getValue();
		}
	};

	GameRules(int code) {
	}

	public abstract int getValue();
}
