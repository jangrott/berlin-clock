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
                .setHours(partsOfTime[0])
                .setMinutes(partsOfTime[1])
                .setSeconds(partsOfTime[2])
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
            private int hours;
            private int minutes;
            private int seconds;

            private BerlinClockBuilder() {
            }

            static BerlinClockBuilder berlinClock() {
                return new BerlinClockBuilder();
            }


            BerlinClockBuilder setHours(int hours) {
                this.hours = hours;
                return this;
            }


            BerlinClockBuilder setMinutes(int minutes) {
                this.minutes = minutes;
                return this;
            }

            BerlinClockBuilder setSeconds(int seconds) {
                this.seconds = seconds;
                return this;
            }

            BerlinClock build() {
                return new BerlinClock(new SecondsLamp(seconds),
                        new FiveFullHoursLamps(hours),
                        new OneFullHourLamps(hours),
                        new FiveFullMinutesLamps(minutes),
                        new OneFullMinuteLamps(minutes));
            }
        }
    }

}
