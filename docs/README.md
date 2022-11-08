##구현할 함수
play()
-난수를 발생시켜 저장하고 guess 함수를 호출하여 일치할때까지 게임 진행
guess()
-숫자가 일치하는지 여부 확인하고 스트라이크/볼/낫싱 출력
isNewGame()
-새 게임을 할 것인지 여부 확인
-input이 1이면 play() 2이면 프로그램 종료


##main함수 흐름
0.game함수 호출

##game함수 흐름
0.play함수 호출
1.isNewGame함수 호출


##play함수 흐름
숫자 야구 게임을 시작합니다.
0.컴퓨터가 세자리 난수(com)를 만들고 저장한다.
    -String으로 변환후 저장하기
1.guess 함수 호출. 파라미터로 com 전달  guess(com)


##guess함수 흐름
0.사용자로부터 세자리 숫자(usr)의 문자열을 받는다.(숫자를 입력해주세요 : input)
1.com과 usr을 비교한다.
    -각 String을 한자씩 잘라서 Map형식으로 저장후 ballAndStrike함수에 넘긴다.
2.ballAndStrike함수 호출
    -key&value가 모두 같으면 스트라이크 개수 +1
    -value값만 같으면 볼 +1
3.비교한 결과를 출력한다. (1볼 1스트라이크/2볼.....)
    -스트라이크 == 볼 == 0이면 낫싱 출력
4.만약 정답이라면 return

##ballAndStrike흐름
    -while 문에서 0부터 2까지 key값으로 value값을 얻고 볼과 스트라이크 개수를 센 후 반환


##isNewGame함수 흐름
게임 종료후 계속할것인지 물어본다.(게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.: input)
input이 1이면 game()호출 2이면 return



