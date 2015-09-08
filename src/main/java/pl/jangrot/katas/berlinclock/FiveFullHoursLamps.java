package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.FIVE_FULL_HOURS_LAMPS_OFF;

class FiveFullHoursLamps {

    private final int hours;

    FiveFullHoursLamps(int hours) {
        this.hours = hours;
    }

    String get() {
        return replaceNFirstOccurrences(hours / 5, FIVE_FULL_HOURS_LAMPS_OFF);
    }

    private String replaceNFirstOccurrences(int n, String in) {
        while (n-- > 0) {
            in = in.replaceFirst("O", "R");
        }

        return in;
    }

}
