import TrainExceptions.TrainArgumentException;
import TrainExceptions.TrainException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainCreation {
    private static final Scanner in = new Scanner(System.in);

    private static LocalTime tryParseTime(String time) {
        try {
            return LocalTime.parse(time);
        }
        catch (Exception err) {
            System.out.println("\nПомилка. Час введено у неправильному форматі. Спробуйте ще раз.\n");
        }
        return null;
    }

    public static LocalTime askTime() {
        System.out.print("Час відправлення (у форматі 00:00): ");
        String departTimeString = in.nextLine();
        LocalTime departTime = tryParseTime(departTimeString);

        while (departTime == null) {
            System.out.print("Час відправлення (у форматі 00:00): ");
            departTimeString = in.nextLine();
            departTime = tryParseTime(departTimeString);
        }

        return departTime;
    }

    private static int tryParseSeats(String seats) {
        int seatsInt = -1;
        try {
            seatsInt = Integer.parseInt(seats);
        }
        catch (Exception err) {
            System.out.println("\nПомилка. Місця вказано у неправильному форматі. Спробуйте ще раз.\n");
        }
        return seatsInt;
    }

    private static int askSeats(String askText) {
        System.out.print(askText);
        String seatsString = in.nextLine();
        int seatsInt = tryParseSeats(seatsString);

        while (seatsInt == -1) {
            System.out.print(askText);
            seatsString = in.nextLine();
            seatsInt = tryParseSeats(seatsString);
        }

        return seatsInt;
    }

    public static Train createTrain() {
        System.out.println("Створення потяга");

        System.out.print("Пунт призначення: ");
        String destination = in.nextLine();

        System.out.print("Номер поїзда: ");
        String trainNumber = in.nextLine();

        LocalTime departTime = askTime();

        int commonSeats = askSeats("Кількість загальних місць: ");
        int couchetteSeats = askSeats("Кількість купе місць: ");
        int compartmentSeats = askSeats("Кількість плацкартних місць: ");
        int luxurySeats = askSeats("Кількість СВ місць: ");

        try {
            Train train = new Train(destination, trainNumber, departTime, commonSeats, couchetteSeats, compartmentSeats, luxurySeats);
            System.out.println("\nYour train:");
            System.out.println(train.getStrTrain());
            return train;
        }
        catch (TrainException err) {
            System.out.println("\nНе вдалося створити потяг. Спробуйте ще раз.");
            return null;
        }
    }

    public static List<Train> generateTrainsList() {
        List<Train> trains = new ArrayList<>();
        try {
            trains.add(new Train("Київ", "123", LocalTime.parse("14:00"), 0, 10, 12, 14));
            trains.add(new Train("Київ", "412", LocalTime.parse("15:00"), 2, 10, 12, 14));
            trains.add(new Train("Київ", "563", LocalTime.parse("16:00"), 5, 10, 12, 14));
            trains.add(new Train("Одеса", "6476", LocalTime.parse("16:30"), 4, 10, 12, 14));
            trains.add(new Train("Одеса", "23ОА", LocalTime.parse("17:00"), 0, 10, 12, 14));
            trains.add(new Train("Харків", "888АВ", LocalTime.parse("18:00"), 17, 10, 12, 14));
            return trains;
        } catch (TrainArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
