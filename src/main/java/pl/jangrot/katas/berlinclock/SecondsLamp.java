package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.LAMP_OFF;
import static pl.jangrot.katas.berlinclock.Constants.SECONDS_LAMP_ON;

class SecondsLamp {

    private final int seconds;

    SecondsLamp(int seconds) {
        this.seconds = seconds;
    }

    String get() {
        return seconds % 2 == 0 ? SECONDS_LAMP_ON : LAMP_OFF;
    }
}
