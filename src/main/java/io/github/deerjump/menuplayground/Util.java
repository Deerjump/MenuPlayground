package io.github.deerjump.menuplayground;

public class Util {
    private static final double DAYS_IN_TICKS = 1728000;
    private static final int HOURS_IN_TICKS = 72000;
    private static final int MINUTES_IN_TICKS = 1200;

    public static String formatTime(int ticks) {
        int days = (int) Math.floor(ticks / DAYS_IN_TICKS);
        int hours = (int) Math.floor(ticks - (days * DAYS_IN_TICKS)) / HOURS_IN_TICKS;
        int minutes = (int) Math.floor(ticks - (days * DAYS_IN_TICKS) - (hours * HOURS_IN_TICKS)) / MINUTES_IN_TICKS;
        return String.format("%sD %sHr %sMin", days, hours, minutes);
    }
}
