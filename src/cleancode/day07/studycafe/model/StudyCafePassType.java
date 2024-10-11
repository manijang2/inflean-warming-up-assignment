package cleancode.day07.studycafe.model;

import cleancode.day07.studycafe.act.FixActor;
import cleancode.day07.studycafe.act.HourActor;
import cleancode.day07.studycafe.act.Actor;
import cleancode.day07.studycafe.act.WeeklyActor;
import cleancode.day07.studycafe.exception.AppException;
import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;

public enum StudyCafePassType implements DisplayAble, ActCreateAble {

    HOURLY("시간 단위 이용권", "1") {
        @Override
        public String toDisplayString(int duration, int price) {
            return String.format("%s시간권 - %d원", duration, price);
        }

        @Override
        public Actor getStudyCafePassActor(InputHandler inputHandler, OutputHandler outputHandler) {
            return new HourActor(inputHandler, outputHandler);
        }
    },
    WEEKLY("주 단위 이용권", "2") {
        @Override
        public String toDisplayString(int duration, int price) {
            return String.format("%s주권 - %d원", duration, price);
        }

        @Override
        public Actor getStudyCafePassActor(InputHandler inputHandler, OutputHandler outputHandler) {
            return new WeeklyActor(inputHandler, outputHandler);
        }
    },
    FIXED("1인 고정석", "3") {
        @Override
        public String toDisplayString(int duration, int price) {
            return String.format("%s주권 - %d원", duration, price);
        }

        @Override
        public Actor getStudyCafePassActor(InputHandler inputHandler, OutputHandler outputHandler) {
            return new FixActor(inputHandler, outputHandler);
        }
    };

    private final String description;
    private final String inputNum;

    StudyCafePassType(String description, String inputNum) {
        this.description = description;
        this.inputNum = inputNum;
    }

    public static StudyCafePassType from(String inputNum) {
        for (StudyCafePassType type : StudyCafePassType.values()) {
            if (type.inputNum.equals(inputNum)) {
                return type;
            }
        }

        throw new AppException("잘못된 입력입니다.");
    }
}
