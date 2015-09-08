package pl.jangrot.katas.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockConverterTest {

    @Test
    public void convertsTime() {
        assertThat(new BerlinClockConverter().convert("13:11:03")).isNotNull();
    }
}