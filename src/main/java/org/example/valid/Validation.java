package org.example.valid;

import org.example.GameConfig;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {

    private static final String ERROR_HEADER = "[ERROR]";
    private static final int NAME_LENGTH_LIMIT = 5;

    static GameConfig gameConfig = new GameConfig();

    public static boolean insertCarNames(List<String> carNames) {
        isRightInput(carNames);
        return false;
    }

    private static void isRightInput(List<String> carNames) {
        for (String carName : carNames) {
            isNull(carName);
            isString(carName);
            isLength(carName);
        }
    }


//  비어있는지 확인
    private static void isNull(String carName) {
        if (carName.equals(null) || carName.equals("")) {
            throw new IllegalArgumentException(ERROR_HEADER + "빈 값입니다");
        }
    }

//  문자열 확인
    private static void isString(String carName) {
        if (!Pattern.matches("^[a-zA-Z]*$", carName)) {
            throw new IllegalArgumentException(ERROR_HEADER + "영문자가 아닙니다");
        }
    }

//  길이 5자리 이하 확인
    private static void isLength(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER + "5자리 이하로 입력하세요");
        }
    }

}
