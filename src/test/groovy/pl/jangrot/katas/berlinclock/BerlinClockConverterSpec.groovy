package pl.jangrot.katas.berlinclock

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.assertj.core.api.Assertions.assertThat

@Unroll
class BerlinClockConverterSpec extends Specification {

    @Shared
    def newLine = System.lineSeparator()

    def "The BerlinClockConverter converts time"() {
        expect:
        assertThat(new BerlinClockConverter().convert("13:03:13")).isNotNull()
    }

    def "The BerlinClock conversion of #inputTime is #outputTime"() {
        expect:
        new BerlinClockConverter().convert(inputTime) == outputTime
        where:
        inputTime  || outputTime
        "00:00:00" || "Y" + newLine + "OOOO" + newLine + "OOOO" + newLine + "OOOOOOOOOOO" + newLine + "OOOO"
        "13:17:01" || "O" + newLine + "RROO" + newLine + "RRRO" + newLine + "YYROOOOOOOO" + newLine + "YYOO"
        "23:59:59" || "Y" + newLine + "RRRR" + newLine + "RRRO" + newLine + "YYRYYRYYRYY" + newLine + "YYYY"
        "24:00:00" || "Y" + newLine + "RRRR" + newLine + "RRRR" + newLine + "OOOOOOOOOOO" + newLine + "OOOO"
    }
}
