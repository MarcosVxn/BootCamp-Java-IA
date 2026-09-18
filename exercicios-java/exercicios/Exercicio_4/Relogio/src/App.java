public class App {
    public static void main(String[] args) throws Exception {
        Clock brlClock = new BRLClock();

        brlClock.setSecond(20);
        brlClock.setMinute(30);
        brlClock.setHour(25);

        System.out.println(brlClock.getTime());

        System.out.println(new USClock().convert(brlClock).getTime());
    }
}
