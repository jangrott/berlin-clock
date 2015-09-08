package pl.jangrot.katas.berlinclock

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FiveFullHoursLampsSpec extends Specification {

    def "The next FiveFullHoursLamp lights up every 5 hours"() {
        expect:
        new FiveFullHoursLamps(hours).get() == result
        where:
        hours || result
        0     || "OOOO"
        4     || "OOOO"
        5     || "ROOO"
        9     || "ROOO"
        10    || "RROO"
        14    || "RROO"
        15    || "RRRO"
        19    || "RRRO"
        20    || "RRRR"
        24    || "RRRR"
    }
}
