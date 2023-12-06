public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    // add method that takes in another time object
    public void add(Time otherTime) {
        seconds += otherTime.seconds;
        minutes += otherTime.minutes;
        hours += otherTime.hours;

        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds %= 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
        if (hours >= 24) {
            hours %= 24;
        }
    }

    // overloaded method with string param
    public void add(String otherTime) {
        int firstColon = otherTime.indexOf(':');
        int secondColon = otherTime.lastIndexOf(':');

        int addHours = Integer.parseInt(otherTime.substring(0, firstColon));
        int addMinutes = Integer.parseInt(otherTime.substring(firstColon + 1, secondColon));
        int addSeconds = Integer.parseInt(otherTime.substring(secondColon + 1));

        seconds += addSeconds;
        minutes += addMinutes;
        hours += addHours;

        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds %= 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
        if (hours >= 24) {
            hours %= 24;
        }
    }

    // formats the time so that if the value is less than zero, we add a zero in front of it to make it two digits
    public String format(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return String.valueOf(value);
    }

    // returns string with info
    public String info() {
        return format(hours) + ":" + format(minutes) + ":" + format(seconds);
    }
}