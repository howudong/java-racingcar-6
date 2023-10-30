package racingcar.view.inputview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SettingInputViewTest2 {
    private static final List<String> INPUT_EXCEPTION_TEST_CASE =
            List.of("-1", "가", "", " ", ".가", "-3", "1-1", "1111111111111.111111", "11111-1111");

    private final Map<String, Object> model = new HashMap<>();
    private final InputView inputView = new SettingInputView(new InputValidator());

    private static void input(String target) {
        InputStream input = new ByteArrayInputStream(target.getBytes());
        System.setIn(input);
    }

    @Test
    @DisplayName("입력에서 발생할 수 있는 예외들을 테스트한다.")
    void 차_번호_입력_예외_테스트() {
        //given
        model.put("gameCount", null);
        input(String.join("\n", INPUT_EXCEPTION_TEST_CASE));
        Scanner scanner = new Scanner(System.in);
        //when,then
        INPUT_EXCEPTION_TEST_CASE.forEach((e) -> {
            model.put("gameCount", null);
            assertThrows(IllegalArgumentException.class, () -> {
                inputView.read(model);
            });
        });
    }
}