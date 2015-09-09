package pl.jangrot.katas.berlinclock

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.assertj.core.api.Assertions.assertThat

@Unroll
class BerlinClockConverterSpec extends Specification {

    def "The BerlinClockConverter converts time"() {
        expect:
        assertThat(new BerlinClockConverter().convert("13:03:13")).isNotNull()
    }

    def "The BerlinClock conversion of #inputTime is #outputTime"() {
        expect:
        new BerlinClockConverter().convert(inputTime) == outputTime
        where:
        inputTime  || outputTime
        "00:00:00" || String.format("Y%nOOOO%nOOOO%nOOOOOOOOOOO%nOOOO")
        "13:17:01" || String.format("O%nRROO%nRRRO%nYYROOOOOOOO%nYYOO")
        "23:59:59" || String.format("Y%nRRRR%nRRRO%nYYRYYRYYRYY%nYYYY")
        "24:00:00" || String.format("Y%nRRRR%nRRRR%nOOOOOOOOOOO%nOOOO")
    }
}
