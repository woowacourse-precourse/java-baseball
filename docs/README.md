Aplication.java
update: main문에서 start 메소드를 실행하여 숫자 야구 게임 실행

ArrayNumber.java
update: 메소드 실행부 및 전역변수 선언과 기본 생성자

public int[] getDigits
feat: int형 배열 반환

private boolean isNotDuplicate(String input)
feat: 중복된 숫자 검사, 셋에 있는 데이터들은 중복값이 들어가지 않기에 중복을 제거한 값이 3글자인지 검사 후 반환

private boolean isMinToMax(String input)
feat: 1부터 9까지만 잘 받아왔는지 정규식으로 체크

private boolean lengthisthree(String input)
feat: input의 길이가 3인지 체크

private boolean isValidString(String str)
feat: str이 3글자 이하이며 1부터 9까진지 중복 없는지 체크

private void setDigits(String input)
feat: 유효한 숫자인지 검사, 유효하지않으면 에러를 출력하며 문자 받은거 한글자씩 잘라서 stream통해서 int형 array로 변환 후 digits에 저장

private int getRandomNumber()
feat: 1부터 9까지 랜덤한 숫자 반환

private int[] convertIntegerSetToIntArray (Set<Integer> set)
feat: set을 int형 배열로 바꾸기

public void inputAnswer()
feat: 숫자와 개행의 입력을 받아서 셋팅

public void setRandomNbr()
feat: Set인스턴스가 null이 아니고 숫자 3개를 채울때까지 hashset에 숫자 추가

process.java
update: 새로운 클래스 생성 및 필요한 전역변수 선언

private String getResStr()
feat: 결과를 string으로 만들어주기
아무것도 맞추지 못했으면 낫싱 리턴
스트링빌더로 쌓아서 반환할 것이며 숫자 + 문자 형식으로 쌓음:: ex) 1볼
그 후 String으로 변환

private void printResult()
feat: 결과를 출력하며 점수 출력 및 3스트라이크일 경우 종료문구 출력

private int isStrikeOrBall(int num, int index)
feat: 스트라이크인지 볼인지 체크
3자리 수이기에 3번 검사하며 컴퓨터가 가진 숫자 배열과 사람이 입력한 숫자 배열을 이용해서 
컴퓨터의 숫자와 같은 숫자이며, 자리까지 일치할 때 strike 처리
자리는 일치하지 않지만 같은 숫자가 있을 때 ball로 처리
둘 다 아니라면 -1 리턴

private boolean RightAnswer(String input)
feat: 1또는 2 답변을 했는지 검사
정규식을 이용하여 1 또는 2인지 검사하고 true or false를 리턴

private String inputExit()
feat: 대답 입력을 받아 올바른 답이 아닐 경우 에러

private void readyToExit(ArrayNumber computerNumber)
feat: 게임을 다시 진행할 것인지 물어봄
2인지 검사하여 2이면 나갈 것이고 그것이 아니라면 컴퓨터 랜덤 숫자 다시 세팅 후 인트형 배열로 만들어줌

private void resetScore()
feat: strike와 ball 초기화

private void calScore()
feat: 점수 계산
3번 검사하여 strike or ball을 int로 받아오며
ball일 시 ball + 1, strike일 시 strike + 1을 하며
ball일 시에는 strike인지 검사하지 않고 넘어감.

public void start()
feat: Aplication.java에서 실행한 게임 시작 부분
플레이어, 컴퓨터 넘버 인스턴스 생성하여 랜덤한 숫자 3개를 만든 후 int형 배열로 받아옴
끝내지 않을 경우, 플레이어 넘버 인스턴스에서 숫자 3자리 받은다음에 인트형 배열로 변환 후 저장
점수 우선 0으로 초기화 - 점수 계산 - 점수 출력 - 3strike일 시 게임 종료 및 retry 여부를 물어보는 순으로 게임이 진행.

커밋 역순으로 게임이 진행되며 역순으로 커밋 한 이유는 가장 작은 메소드부터 커밋을 해야 오류가 뜨지 않음.

ArrayNumberTest.java
update: 전역변수 선언 및 test가 끝날 때마다 변수 초기화

나머지 메소드
feat: 직접 만든 예외 및 테스트 케이스
컴퓨터 숫자 검증, 올바른 숫자 입력, 문자 입력, 3자리가 아닌 길이의 숫자, 올바르지 않은 범위, 중복 존재인지 test