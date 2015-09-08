package pl.jangrot.katas.berlinclock;

class SecondsLamp {

    private final int seconds;

    SecondsLamp(int seconds) {
        this.seconds = seconds;
    }

    String get() {
        return seconds % 2 == 0 ? "Y" : "O";
    }
}
