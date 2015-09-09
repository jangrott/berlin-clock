package pl.jangrot.katas.berlinclock

import spock.lang.Specification

class FiveFullMinutesLampsSpec extends Specification {

    def "The next FiveFullMinutesLamp lights up every 5 minutes"() {
        expect:
        new FiveFullMinutesLamps(minutes).get() == result
        where:
        minutes || result
        0       || "OOOOOOOOOOO"
        4       || "OOOOOOOOOOO"
        5       || "YOOOOOOOOOO"
        9       || "YOOOOOOOOOO"
        10      || "YYOOOOOOOOO"
        14      || "YYOOOOOOOOO"
        19      || "YYROOOOOOOO"
        20      || "YYRYOOOOOOO"
        24      || "YYRYOOOOOOO"
        25      || "YYRYYOOOOOO"
        29      || "YYRYYOOOOOO"
        34      || "YYRYYROOOOO"
        35      || "YYRYYRYOOOO"
        39      || "YYRYYRYOOOO"
        40      || "YYRYYRYYOOO"
        44      || "YYRYYRYYOOO"
        49      || "YYRYYRYYROO"
        50      || "YYRYYRYYRYO"
        54      || "YYRYYRYYRYO"
        55      || "YYRYYRYYRYY"
        59      || "YYRYYRYYRYY"
    }

    def "The FiveFullMinutesLamps denote quarters"() {
        expect:
        new FiveFullMinutesLamps(minutes).get() == result
        where:
        minutes || result
        15      || "YYROOOOOOOO"
        30      || "YYRYYROOOOO"
        45      || "YYRYYRYYROO"
    }
}
