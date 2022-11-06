package custom.service;

import camp.nextstep.edu.missionutils.Randoms;
import custom.dto.Response;
import custom.service.vo.ReTry;
import custom.table.Table;

public class BaseBallService {

    private final Table table;

    public BaseBallService(Table table) {
        this.table = table;
    }

    public Response init() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 3; ++i) {
            int temp = Randoms.pickNumberInRange(0, 9);
            number.append(temp);
        }
        table.setNumber(number.toString());
        return Response.endOf("데이터 생성 완료");
    }




}
