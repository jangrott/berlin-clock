package pl.jangrot.katas.berlinclock

import spock.lang.Specification
import spock.lang.Unroll

import static org.assertj.core.api.Assertions.assertThat

class BerlinClockConverterSpec extends Specification {

    def "The BerlinClockConverter converts time"() {
        expect:
        assertThat(new BerlinClockConverter().convert("13:03:13")).isNotNull()
    }

    @Unroll
    def "The BerlinClock conversion of #inputTime is #outputTime"() {
        expect:
        new BerlinClockConverter().convert(inputTime) == outputTime
        where:
        inputTime  || outputTime
        "00:00:00" || String.format("Y%nOOOO%nOOOO%nOOOOOOOOOOO%nOOOO")
        "13:17:01" || String.format("O%nRROO%nRRRO%nYYROOOOOOOO%nYYOO")
        "23:59:59" || String.format("O%nRRRR%nRRRO%nYYRYYRYYRYY%nYYYY")
        "24:00:00" || String.format("Y%nRRRR%nRRRR%nOOOOOOOOOOO%nOOOO")
    }

    def "The conversion of time with value equal to null throws exception"() {
        when:
        new BerlinClockConverter().convert(null)
        then:
        thrown IllegalArgumentException
    }

    def "The conversion of time with empty value throws exception"() {
        when:
        new BerlinClockConverter().convert("")
        then:
        thrown IllegalArgumentException
    }

    def "The conversion of invalid time throws exception"() {
        when:
        new BerlinClockConverter().convert(time)
        then:
        thrown IllegalArgumentException
        where:
        time << ["00:60:00", "25:00:00", "01:12:60", "0:0:0"]
    }
}
