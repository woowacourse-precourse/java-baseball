# 기능 목록
- 숫자 야구 게임의 흐름을 제어하는 컨트롤러 : Controller
  - 유저가 더이상 게임을 진행하고 싶지 않을때까지 게임을 진행 : play()

- 컨트롤러에서 게임을 구동하기 위한 게임 진행자 : Game
  - 게임을 위해 난수를 만들고, 게임을 3스트라이크가 나올때까지 진행  : startGame() 
    - 게임의 결과를 판정하고, 3스트라이크가 나올때까지 게임을 반복   : persistGame()
  - 게임의 종료를 알리고, 사용자의 재실행 여부를 물은 후 답을 반환  : askRegame()
  
- 상대방(컴퓨터)의 난수 생성 : CreateRandom
  - 컴퓨터의 난수가 되는 array를 생성 : makeRandomNums()
    - 랜덤값을 생성한 후, 중복을 피하여 array를 채우기   : fillArray()
      - 생성된 랜덤값이 array에 이미 존재하는 값인지 확인 : checkIfDuplicatedNumber()
  - 난수 array를 초기화 : initializer()

- 사용자로부터 값 입력받기 : NumsInputFromUser
  - 값을 콘솔로부터 입력받은 뒤, 각 자리수를 계산하고, 예외를 처리한뒤, 사용자 입력값을 담은 array 반환 : getInputNumForGame()
    - 입력받은 값의 각 자리수를 분리     : computeEach()
    - 입력받은 값에 대한 예외사항을 점검 : checkInputException()
    - 입력받은 값을 array에 담기       : toArr()

- 사용자의 입력과 난수를 비교하여 스코어 판정 : ScoreJudge
  - 사용자의 입력과 난수를 비교한 뒤 결과값을 문자열로 반환 : Judge()
    - 사용자 입력과 난수를 비교하여 결과값을 생성 : computeScore()
      - 스코어를 판정하기 위해 컴퓨터의 난수값 array에서 유저의 입력을 검색 : searchNumInArray()
      - 검색한 결과를 토대로 스트라이크 OR 볼을 판정                    : strikeOrBall()
    - 최종 판정 결과를 문자열로 만들어 반환                          : resultString()