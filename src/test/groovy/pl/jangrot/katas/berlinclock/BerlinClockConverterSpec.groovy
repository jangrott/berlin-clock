package pl.jangrot.katas.berlinclock

import spock.lang.Specification
import spock.lang.Unroll

import static org.assertj.core.api.Assertions.assertThat

@Unroll
class BerlinClockConverterSpec extends Specification {

    def "The BerlinClockConverter converts time"() {
        expect:
        assertThat(new BerlinClockConverter().convert("13:03:13")).isNotNull()
    }
}
