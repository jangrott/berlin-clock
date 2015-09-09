package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.HOURS_LAMPS_OFF;
import static pl.jangrot.katas.berlinclock.Constants.HOURS_LAMP_ON;
import static pl.jangrot.katas.berlinclock.Utils.replaceNFirstOccurrences;

class OneFullHourLamps {

    private final int hours;

    OneFullHourLamps(int hours) {
        this.hours = hours;
    }

    String get() {
        return replaceNFirstOccurrences(hours % 5, HOURS_LAMPS_OFF, HOURS_LAMP_ON);
    }

}
