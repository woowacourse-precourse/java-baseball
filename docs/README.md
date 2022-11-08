💻 컴퓨터 기능 구현

1부터 9 사이의 수 중에서 1개를 랜덤으로 중복이 되지 않게 3개를 뽑는다.
1부터 9까지 랜덤 수를 리턴해주는 함수
Method Name : randomPickNumber
1부터 9까지 랜덤 수인 int computerRanNum을 return.
중복 여부를 체크하는 함수
Method Name : uniqueNumber
Parameter : int computerRanNum, List computerRanNumList
computerRanNumList에 컴퓨터가 랜덤으로 리턴해 준 값이 있어 중복된다면, boolean false 리턴.
computerRanNumList에 없다면 boolean true를 return.
List에 넣는 함수
Method Name : checkToInputcheckToInput
Parameter : int computerRanNum, List computerRanNumList
uniqueNumber에 리턴 값이 True라면, computerRanNumList에 computerRanNum을 넣어준다.
computerRanNumList를 return 해주는 함수
Method Name : computerNumberList
while문을 통해서 computerRanNumList의 size가 3개될 때까지 돈다.
checkToInput을 통해서 랜덤으로 생성해준 수가 중복이 되지 않는 값들을 넣는다.
중복되지 않는 랜덤 수를 넣은 List computerRanNumList를 return.
👩 사용자 기능 구현

사용자에게 입력받는 함수
Method Name : playerInputNumber
Console.readLine()을 통해서 입력을 받아 String으로 return.
사용자가 입력한 수가 3자리인지 확인하는 함수
Method Name : checkLen
Parameter : String inputNumber
inputNumber의 length가 3이 아니면 IllegalArgumentException 예외 처리.
3자리가 맞으면 true를 return.
사용자가 입력한 수가 Integer인지 확인하는 함수
Method Name : checkNum
Parameter : String inputNumber
try - catch에서 try 안에서 String을 Integer로 변환해줌.
만약 Integer로 변환이 안되면 catch에서 IllegalArgumentException 예외 처리.
사용자가 입력한 수에 0이 있는 확인하는 함수
Method Name : checkNum
Parameter : int stringToInt
stringToInt에 0이 있으면 IllegalArgumentException 예외 처리.
0이 없으면 true를 return.
inputNumList를 return 해주는 함수
Method Name : inputNumberList
Parameter : String inputNumber
길이가 3인지 확인한 후에, String inputNumber를 split으로 나눔.
split된 String inputNumber이 모두 Integer가 맞는지 확인한 후, 0이 있는지 확인한다.
모두 통과되면 inputNumList에 값을 넣어준다.
그리고 List inputNumreturn.
🕹게임 기능 구현

컴퓨터가 랜덤으로 뽑은 값과 사용자가 입력한 값을 비교하여 게임을 진행한다.
strike 함수
Method Name : strikeCnt
Parameter : List computer, List player
computer의 listd와 player의 list에서 i번째가 같은지 확인.
같은 자리에 있으면 strikeCount를 증가해준다.
strikeCount를 return.
리스트에 같은 수가 있는지 확인하는 함수
Method Name : inListCnt
Parameter : List computer, List player
computer의 listd와 player의 list에서 같은 수가 있는지 확인해준다.
같은 수가 있으면 inListCount를 증가해준다.
inListCount를 return.
게임을 다시 시작할건지 받는 함수
Method Name : checkAgainNumber
Parameter : String inputAgainNumber
1을 입력하면 true를 return.
2를 입력하면 false를 return.
그 외의 값은 IllegalArgumentException 예외 처리.
결과를 출력하는 함수
Method Name : printScore
Parameter : int ballCount, int strikeCount
ballCount와 strikeCount가 둘 다 0이면 아무것도 겹치지 않은 거니까 낫싱을 출력.
ballCount가 0이고 strikeCount가 1과 3사이에 있으면 스트라이크가 몇인지 출력.
ballCount가 1과 3사이에 있고 strikeCount가 0이면 볼이 몇인지 출력.
만약 ballCount와 strikeCount에 모두 값이 있으면 모두 출력
❗️ main 기능 구현

Application의 변수 선언을 한 후에 게임을 시작한다.
while문이 true면 계속 돌 수 있도록 boolean again을 선언.
게임을 다시 시작할 때만 컴퓨터가 랜덤 수를 뽑을 수 있도록 설정하기 위해 boolean inGame을 선언.
again을 먼저 true로 설정하여 while문 안으로 들어온다.
먼저 if문을 만나서 true였던 ingame을 먼저 false로 바꿔주고, 컴퓨터 랜덤 값 생성.
다음, 사용자가 수 입력
두 개의 입력 list를 비교하여 strike와 inList의 값을 바꿔준다.
이때, inList에는 strike의 경우까지 포함하고 있어, ball을 inList - strike의 값으로 선언.
결과를 출력한 다음 strike가 3이었다면, if문을 들어오게 한다.
1을 입력하면 again이 true가 되어 while문을 계속 실행할 것이다.
2를 입력하면 while문 탈출.
1을 입력하면 다시 랜덤수를 만들어줘야 하므로 inGame을 true로 바꿔준다.