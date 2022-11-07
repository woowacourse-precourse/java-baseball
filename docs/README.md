기능 초안
1. 상대방의 숫자를 생성하는 기능
2. 나의 입력을 받는기능
3. 나의입력 오류체크
4. 스트라이크/볼 count하는 기능
5. 결과를 출력하는 기능
6. 게임 종료하면 더할지말지 결정하는 기능
7. 게임의 종료조건 판단하는기능

---------------
기능목록
StartGame : 상대방의 숫자를 생성하고 게임을 진행하는 기능
getNumberBaseball : 상대방의 숫자를 랜덤하게 생성
checkDuplicate : 상대방의 숫자가 중복하게 생성되었는지 check하는 기능
getInput: 사용자의 입력을 받는 기능
checkError: 사용자의 입력한 문자열이 길이가 3인지,숫자인지아닌지, 서로다른숫자인지 check하는 기능
transfromInteger : 사용자가 입력한 문자열을 정수형 Arraylist로 반환
checkNum: ballcheck strikecheck 기능을 통해 ball strike 개수를 파악후 결과를 출력해주고 스트라이크가 3이면 게임을 더할지말지 결정하는 기능
gameSwitch,reGame:사용자의 입력을 받아 게임을 더 할지 말지 결정하는 기능
