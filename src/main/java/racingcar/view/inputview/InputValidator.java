package racingcar.view.inputview;

import java.util.Arrays;
import java.util.List;

import static racingcar.view.inputview.SettingInputView.DELIMITER;

public class InputValidator {
    void isSameNameSizeToDelimiter(String input) {
        int carSize = splitToListByDelimiter(input).size();
        int delimiterSize = (int) input.chars()
                .filter(e -> e == DELIMITER)
                .count();

        if (carSize - 1 != delimiterSize) {
            throw new IllegalArgumentException();
        }
    }

    void isOnlyNaturalNumber(String input) {
        boolean isAllNatural = input.chars()
                .allMatch(number -> '0' <= number && number <= '9');

        if (!isAllNatural) {
            throw new IllegalArgumentException();
        }
    }

    void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitToListByDelimiter(String input) {
        return Arrays
                .stream(input.split(String.valueOf(DELIMITER)))
                .filter(e -> !e.isEmpty())
                .toList();
    }
}
