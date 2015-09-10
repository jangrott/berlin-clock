package pl.jangrot.katas.berlinclock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static pl.jangrot.katas.berlinclock.BerlinClockConverter.BerlinClock.BerlinClockBuilder.berlinClock;

public class BerlinClockConverter implements TimeConverter {

    public static final Pattern TIME_PATTERN = Pattern.compile("^([0-1]\\d|2[0-4]):([0-5]\\d):([0-5]\\d)$");

    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public String convert(String time) {
        validateTime(time);
        extractPartsOfTime(time);

        BerlinClock berlinClock = berlinClock()
                .setHours(hours)
                .setMinutes(minutes)
                .setSeconds(seconds)
                .build();

        return berlinClock.time();
    }

    private static void validateTime(String time) {
        checkAgainstNullOrEmpty(time);
        checkAgainstFormat(time);
    }

    private static void checkAgainstNullOrEmpty(String time) {
        checkArgument(!isNullOrEmpty(time), "Time can not be null or empty");
    }

    private static void checkAgainstFormat(String time) {
        checkArgument(TIME_PATTERN.matcher(time).matches(), "Time has to be in format of HH:mm:ss or kk:mm:ss");
    }

    private void extractPartsOfTime(String time) {
        Matcher matcher = TIME_PATTERN.matcher(time);

        hours = Integer.parseInt(matcher.group(1));
        minutes = Integer.parseInt(matcher.group(2));
        seconds = Integer.parseInt(matcher.group(3));
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
            return String.join(NEW_LINE,
                    secondsLamp.get(),
                    fiveFullHoursLamps.get(),
                    oneFullHourLamps.get(),
                    fiveFullMinutesLamps.get(),
                    oneFullMinuteLamps.get());
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
