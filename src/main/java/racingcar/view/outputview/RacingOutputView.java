package racingcar.view.outputview;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Map;

public class RacingOutputView implements OutputView {
    static {
        System.out.println("실행 결과");
    }

    private static final String CAR_MOVE_UNIT = "-";

    @Override
    public void display(Map<String, Object> displayEntities) {
        if (displayEntities.get("cars") instanceof Cars cars) {
            printRacingResult(cars.getCars());
        }
        System.out.println();
    }

    private void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName()
                    + convertDistance(car.getDistance()));
        }
    }

    private String convertDistance(int distance) {
        return CAR_MOVE_UNIT
                .repeat(Math.max(0, distance));
    }
}
