package pl.jangrot.katas.berlinclock;

import static pl.jangrot.katas.berlinclock.Constants.LAMP_OFF;

class Utils {

    static String replaceNFirstOccurrences(int n, String in, String replacement) {
        while (n-- > 0) {
            in = in.replaceFirst(LAMP_OFF, replacement);
        }

        return in;
    }
}
