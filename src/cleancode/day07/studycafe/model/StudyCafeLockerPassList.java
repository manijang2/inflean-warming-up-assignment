package cleancode.day07.studycafe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPassList {

    private final List<StudyCafeLockerPass> list = new ArrayList<>();

    public StudyCafeLockerPassList(List<String> lines, String delimeter) {
        for (String line : lines) {
            String[] values = line.split(delimeter);
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);

            StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
            list.add(lockerPass);
        }
    }

    public Optional<StudyCafeLockerPass> get(StudyCafePassType type, int duration) {
        return list.stream()
                .filter(option ->
                        option.getType() == type && option.getDuration() == duration
                )
                .findFirst();
    }
}
