package Java_Core.Module_4;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {
}


class DateDemo {
    public static void main(String args[]) {
        Date date = new Date();
        // вывести дату и время методом toString()
        System.out.println(date);
        // вывести количество миллисекунд, прошедших
        // с 1 января 1970 г. по Гринвичу
        long msec = date.getTime();
        System.out.println("Koличecтвo миллисекунд, прошедших с "
                + "1 января 1970 г. по Гринвичу = " + msec);
    }
}

class CalendarDemo {
    public static void main(String args[]) {
        String months[] = {"Jan", "Feb", "Mar", "Apr",
                "Мау", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};

        // создать календарь, инициализируемый
        //текущими датой и временем с учетом региональных
        // настроек и часового пояса по умолчанию
        Calendar calendar = Calendar.getInstance();

        // вывести текущую дату и время
        System.out.print("Дата: ");
        System.out.print(months[calendar.get(Calendar.MONTH)]);
        System.out.print(" " + calendar.get(Calendar.DATE) + " ");
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.print("Время: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));

        //установить дату и время и вывести их
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);
        System.out.print("Измeнeннoe время: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));
    }
}

class GregorianCalendarDemo {
    public static void main(String args[]) {
        String months[] = {"Jan", "Feb", "Mar", "Apr",
                "Мау", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        int year;

        // создать григорианский календарь, инициализируемый
        // текущими датой и временем с учетом региональных
        // настроек и часового пояса по умолчанию
        GregorianCalendar gcalendar = new GregorianCalendar();

        // вывести текущие время и дату
        System.out.print("Дaтa: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE)
                + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Bpeмя: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // проверить, является ли текущий год високосным
        if (gcalendar.isLeapYear(year)) {
            System.out.println("Teкyщий год високосный");
        } else {
            System.out.println("Teкyщий год не високосный");
        }
    }
}
