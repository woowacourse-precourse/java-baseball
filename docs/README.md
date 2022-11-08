## 기능 목록 정의

### 💻 도메인 정의

------------------

#### ✅ Player
| 이름           | 설명                | 구분       | I / O                                                         | 비고  |
|:-------------|:------------------|:---------|:--------------------------------------------------------------|:----|
| firstNumber  | 플레이어의 첫 번째 숫자     | 변수 (int) |                                                               | -   |
| secondNumber | 플레이어의 두 번째 숫자     | 변수 (int) |                                                               | -   |
| thirdNumber  | 플레이어의 세 번째 숫자     | 변수 (int) |                                                               | -   |
| Player       | 생성자               | 생성자      | input - int firstNumber,int secondNumber,int thirdNumber      | -   |
| getter       | 플레이어의 각 숫자를 가져온다. | getter   | -                                                             | -   |
| setter       | 플레이어의 각 숫자를 설정한다. | setter   | input - int firstNumber,int secondNumber,int thirdNumber      | -   |


#### ✅ Computer
| 이름           | 설명               | 구분       | I / O                                                    | 비고  |
|:-------------|:-----------------|:---------|:---------------------------------------------------------|:----|
| firstNumber  | 컴퓨터의 첫 번째 숫자     | 변수 (int) |                                                          | -   |
| secondNumber | 컴퓨터의 두 번째 숫자     | 변수 (int) |                                                          | -   |
| thirdNumber  | 컴퓨터의 세 번째 숫자     | 변수 (int) |                                                          | -   |
| Computer     | 생성자              | 생성자      | input - int firstNumber,int secondNumber,int thirdNumber | -   |
| getter       | 컴퓨터의 각 숫자를 가져온다. | getter   | -                                                        | -   |
| setter       | 컴퓨터의 각 숫자를 설정한다. | setter   | input - int firstNumber,int secondNumber,int thirdNumber | -   |



### 💻 Repository 정의

------------------

#### ✅ PlayerRepository
| 이름        | 설명               | 구분          | I / O                                                   | 비고  |
|:----------|:-----------------|:------------|:--------------------------------------------------------|:----|
| player    | 플레이어가 입력한 숫자     | 객체 (Player) |                                                         | -   |
| setPlayer | 플레이어가 입력한 숫자를 저장 | 메서드         | input - int firstNuber,int secondNumber,int thirdNumber | -   |
| getPlayer | 플레이어가 입력한 숫자를 반환 | 메서드         | output - Player player                                  | -   |

#### ✅ ComputerRepository
| 이름          | 설명                  | 구분            | I / O                                                   | 비고  |
|:------------|:--------------------|:--------------|:--------------------------------------------------------|:----|
| computer    | 랜덤으로 정한 컴퓨터의 숫자     | 객체 (Computer) |                                                         | -   |
| setComputer | 랜덤으로 정한 컴퓨터의 숫자를 저장 | 메서드           | input - int firstNuber,int secondNumber,int thirdNumber | -   |
| getComputer | 컴퓨터의 숫자를 반환         | 메서드           | output - Player player                                  | -   |


### 💻 Service 정의

------------------

#### ✅ PlayerService
| 이름                 | 설명                        | 구분                    | I / O                                                                               | 비고  |
|:-------------------|:--------------------------|:----------------------|:------------------------------------------------------------------------------------|:----|
| PlayerRepository   | 플레이어 숫자 관련 저장소            | 객체 (PlayerRepository) |                                                                                     | -   |
| setPlayerNumber    | 플레이어가 입력한 숫자 정보 저장        | 메서드                   | input - ArrayList<Integer> playerNumberList                                         | -   |
| inputPlayerNumber  | 플레이어에게 숫자 3개를 입력 받음       | 메서드                   | output - ArrayList<Integer> playerNumberList                                        | -   |
| getPlayerNumber    | 플레이어의 숫자 정보 확인            | 메서드                   | output - ArrayList<Integer> playerNumberList                                        | -   |
| inputRestartAnswer | 게임 재시작 여부 입력              | 메서드                   | output - Boolean - True/False                                                       | -   |
| checkBallCount     | 컴퓨터와 플레이어의 값을 비교해 볼카운트 확인 | 메서드                   | input - ArrayList<Integer> computerNumbers<br>output - ArrayList<Integer> ballCount | -   |


#### ✅ ComputerService
| 이름                 | 설명            | 구분                       | I / O                                          | 비고  |
|:-------------------|:--------------|:-------------------------|:-----------------------------------------------|:----|
| ComputerRepository | 컴퓨터 숫자 관련 저장소 | 객체 (ComputerRepository)  |                                                | -   |
| setComputerNumber  | 컴퓨터의 정답 랜덤 설정 | 메서드                      |                                                | -   |
| getComputerNumber  | 컴퓨터의 정답 확인    | 메서드                      | output - ArrayList<Integer> computerNumberList | -   |

#### ✅ MessageService
| 이름                 | 설명               | 구분  | I / O                                                              | 비고  |
|:-------------------|:-----------------|:----|:-------------------------------------------------------------------|:----|
| startGameMessage   | 게임 시작시 출력        | 메서드 | output - "숫자 야구 게임을 시작합니다."                                        | -   |
| restartGameMessage | 게임 재시작 여부 메시지 출력 | 메서드 | output - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."                         | -   |
| endGameMessage     | 게임 종료시 출력        | 메서드 | output - "3개의 숫자를 모두 맞히셨습니다! 게임 종료"                                | -   |
| ballCountMessage   | 볼카운트 출력          | 메서드 | input - ArrayList<Integer> ballCount <br>output - "x볼 x스트라이크","낫싱" | -   |


#### ✅ gameService
| 이름                         | 설명                                                                | 구분                                 | I / O                                        | 비고  |
|:---------------------------|:------------------------------------------------------------------|:-----------------------------------|:---------------------------------------------|:----|
| checkInputPlayerNumber     | 플레이어가 입력한 숫자가 유효한지 확인<br> 예외 발생시 IllegalArgumentException 발생      | input - String inputPlayerNumbers  |                                              | -   |
| checkTheLength             | 플레이어가 입력한 숫자의 길이가 올바른지 확인 <br> 예외 발생시 IllegalArgumentException 발생 | input - String inputPlayerNumbers  |                                              | -   |
| checkForDuplicateNumber    | 중복된 숫자가 없는지 확인  <br> 예외 발생시 IllegalArgumentException 발생           | input - String inputPlayerNumbers  |                                              | -   |
| checkThePresenceOfZeros    | 0이 포함되어 있는지 확인   <br> 예외 발생시 IllegalArgumentException 발생          | input - String inputPlayerNumbers  |                                              | -   |
| checkForCharacterExistence | 문자가 포함되어 있지 않은지 확인     <br> 예외 발생시 IllegalArgumentException 발생    | input - String inputPlayerNumbers  |                                              | -   |


### 💻 Controller 정의

------------------


#### ✅ BaseballController
| 이름                  | 설명                                        | 구분   | I / O                       | 비고  |
|:--------------------|:------------------------------------------|:-----|:----------------------------|:----|
| gameStart           | 게임의 메인 루프                                 | 메서드  |                             | -   |
| initGame            | 게임의 시작에 앞서 컴퓨터의 정답을 정한다                   | 메서드  |                             | -   |
| confirmGameRestart  | 정답을 맞출 시 필요한 메시지를 출력한다. 게임의 재시작 여부를 리턴한다. | 메서드  | output - boolean            | -   |
| checkStrikeNumber   | 스트라이크의 갯수를 구한다.                           | 메서드  | output - (int) strikeNumber | -   |
| inputPlayerNumber   | 플레이어에게 숫자를 입력받아 저장한다                      | 메서드  | -                           | -   |