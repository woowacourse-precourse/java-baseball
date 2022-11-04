# 기능 목록


| 구현 여부 | 번호  | 기능 코드                       | Depth1         | Depth2         | Depth3 | method                                                        | 설명                                                                   |
|-------|-----|-----------------------------|----------------|----------------|--------|---------------------------------------------------------------|----------------------------------------------------------------------|
| O     | 1   | baseBall-makeThreeNumber-01 | 유효한 3자리 숫자 만들기 |                |        | public List<Integer> get()                                    | 서로 다른 3자리 숫자를 만들어 list로 반환한다 index 0은 일의 자리                          |
| O     | 2   | baseBall-makeThreeNumber-02 | 유효한 3자리 숫자 만들기 | 유효한 1자리 숫자 만들기 |        | private int getValidateNumber(List<Integer> randomNumberList) | 앞에 숫자와 다른 숫자를 찾아서 반환 한다.                                             |
| X     | 3   | baseBall-getInputNunmber-01 | 3자리 입력값을 받는다   | 입력값 반환         |        |                                                               | 숫자를 받아서 list로 변환하여 반환한다  index 0은 1의자리                               |
| X     | 4   | baseBall-getInputNunmber-02 | 3자리 입력값을 받는다   | 유효성 검사         |        |                                                               | 숫자를 받아서 list로 변환한 것을 유효성검사한다 반환한다 잘못된 값일 경우 IllegalArgumentException |
| X     | 5   | baseBall-compare-01         | 컴퓨터와 유저 숫자비교   |                |        |                                                               | 유저의 수와 컴퓨터 수를 비교하여 스트라이크와 볼의 갯수를 map으로 반환                            |
| X     | 6   | baseBall-compare-02         | 컴퓨터와 유저 숫자비교   | 스트라이크          |        |                                                               | 동일위치 동일숫자일 경우 스트라이크로 취급하며 스트라이크 횟수 반환                                |
| X     | 7   | baseBall-compare-03         | 컴퓨터와 유저 숫자비교   | 볼              |        |                                                               | 동일위치 다른숫자일 경우 볼로 취급하며 볼 횟수 반환                                        |
| X     | 8   | baseBall-outputString-01    | String 출력      | 게임 결과          |        |                                                               | map 으로 저장된 게임 결과를 유저 친화적인 String으로 변환                                |
