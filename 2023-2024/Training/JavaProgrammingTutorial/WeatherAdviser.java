public class WeatherAdviser {

    public static void main(String[] args) {
        System.out.println(provideWeatherAdvisory(0));
        System.out.println(provideWeatherAdvisory(5));
        System.out.println(provideWeatherAdvisory(15));
        System.out.println(provideWeatherAdvisory(25));
    }

    public static String provideWeatherAdvisory(int temperature) {
        if(temperature < 0)
            return "It's freezing! Wear a heavy coat.";
        if(temperature >= 0 && temperature <= 10 )
            return "It's cold! Bundle up.";
        if(temperature >=11 && temperature <=20 )
            return"It's cool! A light jacket will do.";
        return "It's warm! Enjoy the day.";
    }
}