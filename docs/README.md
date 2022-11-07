

<h2>숫자 야구 게임 기능 목록 작성</h2>
<hr>
<body>
<h2>domain</h2>

<h3>Computer</h3>

<LI>setComputerRandomNumberList : 컴퓨터의 임의의 3개 숫자를 생성하고 저장하는 메서드
</LI>
<LI>getComputerRandomNumberList : 컴퓨터의 3개의 랜덤 넘버가 담긴 List를 반환해주는 메서드</LI>
<LI>initComputerRandomNumberList : 새로운 게임을 시작할 때 컴퓨터의 랜덤 넘버 초기화를 위해 새로운 ArrayList로 만들어주는 메서드</LI>

<h3>User</h3>
<LI>setUserInputNumberList : 유저의 임의의 3개 숫자를 입력받고 저장하는 메서드
</LI>
<LI>getUserInputNumberList : 유저의 3개의 입력 넘버가 담긴 List를 반환해주는 메서드</LI>
<LI>initUserInputNumberList : 새로운 게임을 시작할 때 유저의 입력 넘버 리스트 초기화를 위해 새로운 ArrayList로 만들어주는 메서드</LI>

<h3>Constant</h3>
<Li>MIN_NUMBER, MAX_NUMBER, MAX_NUMBER_SIZE : 최소 숫자(1), 최대 숫자(9), 숫자 크기(3개)</Li>
<LI>COMPUTER_GAME_EXIT, COMPUTER_GAME_RESTART : 게임 재시작("1"), 종료 옵션 넘버("2")</LI>
<LI>COMPUTER_OPTION, USER_NUMBER_OPTION : 입력받은 숫자가 숫자로만 구성되어 있는지 확인하기 위한 변수
<LI>GAME_END_MESSAGE, MISSION_COMPLETE_MESSAGE : 게임 종료 메세지
<LI>BALL, STRIKE, NOTHING : 볼, 스트라이크, 낫싱 문구
<LI>STRIKE_DEFAULT, BALL_DEFAULT, THREE_STRIKE_NUMBER : 스트라이크, 볼의 기본값, 스트라이크 3개


<h2>Controller</h2>
<h3>GameController</h3>
<LI>askUserInputNumberMessage : "숫자를 입력해 주세요" 메세지를 출력하기 위한 메서드
<LI>endNumberBaseballGameMessage : "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 메세지를 출력하기 위한 메서드
<LI>startNumberBaseballGame : service의 startNumberBaseballGame의 기능을 실행하기 위한 메서드 => 이 메서드에서 service에게 요청을 보내서 스트라이크가 3이 되기 전 까지 숫자 야구 게임 실행

<h2>Service</h2>
<h3>GameService</h3>
<LI>initNumberStrikeAndBallCount : strike와 ball의 개수를 0으로 초기화하는 메서드
<LI>getComputerRandomNumbers : 컴퓨터에서 임의의 숫자 3개를 생성받고, 랜덤 숫자 리스트(숫자 3개가 담긴 List)를 반환해주는 메서드
<LI>getUserInputNumbers : 유저가 숫자를 세개 입력하고, 입력한 숫자 리스트(숫자 3개가 담긴 List)를 반환해주는 메서드
<LI>countStrike : Strike의 개수를 세주는 메서드
<LI>countBall : Ball의 개수를 세주는 메서드
<LI>getStrikeCount : strike 개수를 반환해주는 메서드
<LI>getBallCount : ball 개수를 반환해주는 메서드
<LI>addStrikeCount : strike의 개수를 1 더해주는 메서드
<LI>addBallCount : ball의 개수를 1 더해주는 메서드
<h2>Exception</h2>
<h3>ComputerException</h3>
<LI>checkComputerGameOptionNumberBetweenOneAndTwo : 게임 재시작(1), 종료(2) 옵션 넘버 외에 넘버를 입력했을 때 예외처리 해주는 메서드
<LI>checkComputerGameOptionNumberOnlyOneAndTwo : 숫자를 입력하지 않았을 때 예외처리 해주는 메서드
<LI>checkComputerExceptions : 위에 명시한 예외들에 속하지 않는지 check 해주는 메서드
<h3>UserException</h3>
<LI>checkUserNumberBetweenOneAndNine : User가 입력한 숫자가 1에서 9사이인지 check 해주는 메서드
<LI>checkUserInputNumberAboutOnlyNumber : User가 입력한 값이 숫자로만 구성되어 있는지 check 해주는 메서드
<LI>checkDuplicatedUserInputNumber : User가 입력한 값들 중에서 중복된 숫자가 있는지 check 해주는 메서드
<LI>checkLengthOfUserInputNumber : User가 입력한 값의 길이가 3인지 check 해주는 메서드
<LI>checkUserExceptions : 위에 명시한 예외들에 속하지 않는지 check 해주는 메서성
<h2>View</h2>
<h3>InputView</h3>
<LI>askUserInputNumber : "숫자를 입력해 주세요 : " 메세지를 화면에 보여주는 메서드
<LI>askRestartGameMessage : "게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요." 메세지를 화면에 보여주는 메서드
<LI>printFirstNumberBaseballGameMessage : "숫자 야구 게임을 시작합니다. " 메세지를 화면에 보여주는 메서드

<h3>OutputView</h3>
<LI>printNumberBaseballResult : 게임 결과 스트라이크 개수와 볼의 개수를 화면에 출력해주는 메서드
<LI>printMissionCompleteMessage : "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 메세지를 화면에 출력해주는 메서드
<LI>printExitMessage : "게임 종료" 메세지를 화면에 출력해주는 메서드
<br>
<br>
최종적으로 Application을 실행하여 Application에서 controller 객체를 생성시켜 위의 기능들을 실행할 수 있도록 구현
</body>