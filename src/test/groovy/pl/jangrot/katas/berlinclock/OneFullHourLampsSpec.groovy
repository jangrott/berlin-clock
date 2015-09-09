package pl.jangrot.katas.berlinclock

import spock.lang.Specification

class OneFullHourLampsSpec extends Specification {

    def "The next OneFullHourLamp lights up every 1 hour"() {
        expect:
        new OneFullHourLamps(hours).get() == result
        where:
        hours || result
        0     || "OOOO"
        1     || "ROOO"
        2     || "RROO"
        3     || "RRRO"
        4     || "RRRR"
        5     || "OOOO"
        6     || "ROOO"
        7     || "RROO"
        8     || "RRRO"
        9     || "RRRR"
        10    || "OOOO"
        11    || "ROOO"
        12    || "RROO"
        13    || "RRRO"
        14    || "RRRR"
        15    || "OOOO"
        16    || "ROOO"
        17    || "RROO"
        18    || "RRRO"
        19    || "RRRR"
        20    || "OOOO"
        21    || "ROOO"
        22    || "RROO"
        23    || "RRRO"
        24    || "RRRR"
    }
}
