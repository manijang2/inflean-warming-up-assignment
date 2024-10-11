package cleancode.day07.studycafe.model;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePassList {

    private List<StudyCafePass> list = new ArrayList<>();

    public StudyCafePassList(List<String> lines, String delimeter) {

        for (String line : lines) {
            String[] values = line.split(delimeter);
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);
            double discountRate = Double.parseDouble(values[3]);

            StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
            list.add(studyCafePass);
        }
    }

    public  List<StudyCafePass> extractCafePasses(StudyCafePassType type) {
        return list.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == type)
                .toList();
    }
}
