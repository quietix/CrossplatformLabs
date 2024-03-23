import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInteractionHandler {
    private static final Scanner in = new Scanner(System.in);
    private static List<Train> trains = new ArrayList<>();

    private static List<Train> getTrainsWithCommonSeats() {
        List<Train> filteredTrains = new ArrayList<>();

        for (Train train : UserInteractionHandler.trains) {
            if (train.getCommonSeats() > 0) {
                filteredTrains.add(train);
            }
        }

        return filteredTrains;
    }

    private static List<Train> filterTrainsByDestinationAndDepartureTime(String destination, LocalTime departTimeStart, LocalTime departTimeEnd) {
        List<Train> filteredTrains = new ArrayList<>();

        for (Train train : UserInteractionHandler.trains) {
            if (Objects.equals(train.getDestination(), destination)) {
                if (train.getDepartTime().isAfter(departTimeStart) && train.getDepartTime().isBefore(departTimeEnd)) {
                    filteredTrains.add(train);
                }
            }
        }

        return filteredTrains;
    }

    public static void printTrains(List<Train> trainsList) {
        System.out.println("Відфільтровані потяги:");
        System.out.println("--------------");
        for (Train train : trainsList) {
            System.out.println(train.getStrTrain());
            System.out.println("--------------");
        }
    }

    public static void handleThirdInteractionCase() {
        System.out.println("Фільтрація по місцю призначення та часу відправлення.");

        System.out.print("Введіть місце призначення: ");
        String destination = in.nextLine();

        System.out.println("Введіть початковий час відправлення.");
        LocalTime departTimeStart = TrainCreation.askTime();

        System.out.println("Введіть кінцевий час відправлення.");
        LocalTime departTimeEnd = TrainCreation.askTime();

        List<Train> filteredTrains = filterTrainsByDestinationAndDepartureTime(destination, departTimeStart, departTimeEnd);

        printTrains(filteredTrains);
    }

    public static void generateTrains() {
        trains = TrainCreation.generateTrainsList();
    }

    public static void sendMenu() {
        System.out.println("""
                Будь ласка, оберіть одну з опцій:

                1. Додати потяг
                2. Отримати список поїздів, які мають загальні
                місця.
                3. Отримати список поїздів, які слідують до
                заданого пункту призначення та відправляються
                після заданого часу.
                4. Автоматично згенерувати потяги.
                5. Показати увесь список потягів.
                0. Вихід""");
        String option = in.nextLine();

        switch (option) {
            case "1":
                Train t = TrainCreation.createTrain();
                if (!Objects.isNull(t)) {
                    trains.add(t);
                }
                sendMenu();
                break;
            case "2":
            {
                List<Train> filteredTrains = getTrainsWithCommonSeats();
                printTrains(filteredTrains);
                sendMenu();
                break;
            }
            case "3":
                handleThirdInteractionCase();
                sendMenu();
                break;
            case "4":
                generateTrains();
                sendMenu();
                break;
            case "5":
                printTrains(trains);
                sendMenu();
                break;
            case "0":
                System.out.println("Terminating...");
                break;
            default:
                System.out.println("Оберіть одну із запропонованих опцій.");
                sendMenu();
        }
    }
}
