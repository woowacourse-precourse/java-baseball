구현할 기능 목록

main() : isEnd, StartBaseballGame 두 개의 메소드를 이용하여 야구 게임을 진행한다.

isEnd() : 숫자를 입력받아 1이면 새로시작(true), 2이면 종료(false)를 반환한다.
그 외에는 오류를 발생시킨다.

StartBaseballGame() : CheckInput, GetHint, PrintHint, MakeRandomNum 을 사용하여
야구 게임을 구현한다. 

CheckInput() : 3개의 임의의 숫자를 입력 받았는 지 체크하여 아닐 경우 오류를 발생시킨다. 

GetHint() : 숫자를 입력받아 볼 스트라이크를 
Arraylist 형태 [볼 개수, 스트라이크 개수] 로 반환한다.

PrintHint() : Arraylist[볼 개수, 스트라이크 개수]를 입력 받아 적절한
양식을 출력한다.

MakeRandomNum() : 컴퓨터가 랜덤한 임의의 숫자 3개를 정한다.