package pl.jangrot.katas.berlinclock;

import java.util.stream.Stream;

import static pl.jangrot.katas.berlinclock.BerlinClockConverter.BerlinClock.BerlinClockBuilder.berlinClock;

public class BerlinClockConverter implements TimeConverter {

    @Override
    public String convert(String time) {
        int[] partsOfTime = Stream.of(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BerlinClock berlinClock = berlinClock()
                .withSecondsLamp(new SecondsLamp(partsOfTime[2]))
                .withFiveFullHoursLamps(new FiveFullHoursLamps(partsOfTime[0]))
                .withOneFullHourLamps(new OneFullHourLamps(partsOfTime[0]))
                .withFiveFullMinutesLamps(new FiveFullMinutesLamps(partsOfTime[1]))
                .withOneFullMinuteLamps(new OneFullMinuteLamps(partsOfTime[1]))
                .build();

        return berlinClock.time();
    }


    @FunctionalInterface
    interface Clock {
        String time();
    }

    static final class BerlinClock implements Clock {

        private static final String NEW_LINE = System.lineSeparator();

        private final SecondsLamp secondsLamp;
        private final FiveFullHoursLamps fiveFullHoursLamps;
        private final OneFullHourLamps oneFullHourLamps;
        private final FiveFullMinutesLamps fiveFullMinutesLamps;
        private final OneFullMinuteLamps oneFullMinuteLamps;

        private BerlinClock(SecondsLamp secondsLamp,
                            FiveFullHoursLamps fiveFullHoursLamps,
                            OneFullHourLamps oneFullHourLamps,
                            FiveFullMinutesLamps fiveFullMinutesLamps,
                            OneFullMinuteLamps oneFullMinuteLamps) {

            this.secondsLamp = secondsLamp;
            this.fiveFullHoursLamps = fiveFullHoursLamps;
            this.oneFullHourLamps = oneFullHourLamps;
            this.fiveFullMinutesLamps = fiveFullMinutesLamps;
            this.oneFullMinuteLamps = oneFullMinuteLamps;
        }

        @Override
        public String time() {
            return new StringBuilder()
                    .append(secondsLamp.get())
                    .append(NEW_LINE)
                    .append(fiveFullHoursLamps.get())
                    .append(NEW_LINE)
                    .append(oneFullHourLamps.get())
                    .append(NEW_LINE)
                    .append(fiveFullMinutesLamps.get())
                    .append(NEW_LINE)
                    .append(oneFullMinuteLamps.get())
                    .toString();
        }

        static final class BerlinClockBuilder {
            private SecondsLamp secondsLamp;
            private FiveFullHoursLamps fiveFullHoursLamps;
            private OneFullHourLamps oneFullHourLamps;
            private FiveFullMinutesLamps fiveFullMinutesLamps;
            private OneFullMinuteLamps oneFullMinuteLamps;

            private BerlinClockBuilder() {
            }

            static BerlinClockBuilder berlinClock() {
                return new BerlinClockBuilder();
            }

            BerlinClockBuilder withSecondsLamp(SecondsLamp secondsLamp) {
                this.secondsLamp = secondsLamp;
                return this;
            }

            BerlinClockBuilder withFiveFullHoursLamps(FiveFullHoursLamps fiveFullHoursLamps) {
                this.fiveFullHoursLamps = fiveFullHoursLamps;
                return this;
            }

            BerlinClockBuilder withOneFullHourLamps(OneFullHourLamps oneFullHourLamps) {
                this.oneFullHourLamps = oneFullHourLamps;
                return this;
            }

            BerlinClockBuilder withFiveFullMinutesLamps(FiveFullMinutesLamps fiveFullMinutesLamps) {
                this.fiveFullMinutesLamps = fiveFullMinutesLamps;
                return this;
            }

            BerlinClockBuilder withOneFullMinuteLamps(OneFullMinuteLamps oneFullMinuteLamps) {
                this.oneFullMinuteLamps = oneFullMinuteLamps;
                return this;
            }

            BerlinClock build() {
                return new BerlinClock(secondsLamp,
                        fiveFullHoursLamps,
                        oneFullHourLamps,
                        fiveFullMinutesLamps,
                        oneFullMinuteLamps);
            }
        }
    }

}
