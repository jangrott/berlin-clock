package pl.jangrot.katas.berlinclock

import spock.lang.Specification

class SecondsLampSpec extends Specification {

    def "The SecondsLamp lights when the seconds value is even"() {
        expect:
        new SecondsLamp(seconds).get() == result
        where:
        seconds || result
        0       || "Y"
        2       || "Y"
        4       || "Y"
        16      || "Y"
        22      || "Y"
        30      || "Y"
        38      || "Y"
        58      || "Y"
    }

    def "The SecondsLamp doesn't light when the seconds value is odd"() {
        expect:
        new SecondsLamp(seconds).get() == result
        where:
        seconds || result
        1       || "O"
        3       || "O"
        9       || "O"
        13      || "O"
        19      || "O"
        25      || "O"
        31      || "O"
        59      || "O"
    }
}
