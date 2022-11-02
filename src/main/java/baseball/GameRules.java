package baseball;

public enum GameRules {
	DIGIT_NUMBER(3){
		@Override
		public int getValue() {
			return DIGIT_NUMBER.getValue();
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
