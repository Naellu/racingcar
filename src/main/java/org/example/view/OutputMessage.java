package org.example.view;

import org.example.service.RacingService;

import java.util.List;

public class OutputMessage {

    private static final String HYPHEN = "-";

    public void toStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void enterTurnNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void runResult() {
        System.out.println("실행 결과");
    }

    public void resultLoopPrint(RacingService racingService) {
        racingService.getPlayerConditions()
                .entrySet()
                .stream()
                .forEach(car -> {
                    System.out.println(car.getKey() + " : " + changeHYPHEN(car.getValue()));
                });
        System.out.println();
    }

        public static String changeHYPHEN(int position) {
        String str = "";
        for (int i = 0; i < position; i++) {
            str += HYPHEN;
        }
        return str;
    }

    public void printWinner(List<String> winner) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 :");
        for (String carName : winner) {
            sb.append(" ").append(carName + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb);
    }

}
