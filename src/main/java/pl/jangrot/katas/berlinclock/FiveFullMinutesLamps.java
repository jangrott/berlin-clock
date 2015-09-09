package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.*;
import static pl.jangrot.katas.berlinclock.Utils.replaceNFirstOccurrences;

class FiveFullMinutesLamps {

    private final int minutes;

    FiveFullMinutesLamps(int minutes) {
        this.minutes = minutes;
    }

    String get() {
        return denoteQuarters(
                replaceNFirstOccurrences(minutes / 5, FIVE_FULL_MINUTES_LAMPS_OFF, MINUTES_LAMP_ON)
        );
    }

    private String denoteQuarters(String value) {
        return value.replaceAll(QUARTERS_TARGET, QUARTERS_REPLACEMENT);
    }
}
