동작 순서도
1. console의 readline을 통해 숫자를 입력받고 random pickNumberInRange를 통해 상대방 숫자를 정한다.
2. 입력받은 숫자(getNum)을 enhanced for문을 통해 상대방숫자인(yourNum)에 contains를 통해 포함여부를 확인한다.
3. 포함여부가 0개이면 "낫싱"을 출력, Ball(cntBall)이 1개 이상 3개 이하인 경우에 한해 Strike 여부를 확인한다.
4. Strike 여부는 for문을 통해 숫자와 위치가 일치할 경우 cntStrike에 그 개수만큼 추가한다.
5. 출력을 할 때에는 볼과 스트라이크의 개수로 표시하며, 볼의 경우는 cntBall-cntStrike, 스트라이크의 경우는 cnt_Strike이다.
6. 3 Strike가 도출될때까지 무한반복되며, 3 Strike인 경우 "3개의 숫자를 모두 맞히셨습니다! 게임 종료
                                                    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."라는 문구를 출력한다.


구현 예정 기능 목록:
-> 위치와 상관없이 getNum에 있는 숫자가 yourNum에도 포함되어 있을 때 그 개수를 count 하는 기능(cntBall)
-> cntBall의 크기만큼 루프하며 위치와 숫자 모두 동일할 경우 그 개수를 count 하는 기능(cntStrike)
    ㄴ단, count가 끝난 경우 cntBall에서 cntStrike를 감산해도 되고, 후에 출력부분에서 감산해도 상관없다.
-> 3 Strike가 도출될때까지 무한반복되며, 3 Strike인 경우 특정 문자열을 출력하는 기능
-> 게임이 끝난 경우 게임을 새로 시작할지 종료할지 입력받는 기능