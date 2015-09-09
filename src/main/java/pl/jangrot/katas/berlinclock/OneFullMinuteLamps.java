package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.MINUTES_LAMP_ON;
import static pl.jangrot.katas.berlinclock.Constants.ONE_FULL_MINUTES_LAMPS_OFF;
import static pl.jangrot.katas.berlinclock.Utils.replaceNFirstOccurrences;

class OneFullMinuteLamps {

    private final int minutes;

    OneFullMinuteLamps(int minutes) {
        this.minutes = minutes;
    }

    String get() {
        return replaceNFirstOccurrences(minutes % 5, ONE_FULL_MINUTES_LAMPS_OFF, MINUTES_LAMP_ON);
    }
}
