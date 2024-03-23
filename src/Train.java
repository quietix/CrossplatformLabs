import TrainExceptions.TrainArgumentException;

import java.time.LocalTime;

public class Train {
    public Train(String destination,
                 String trainNumber,
                 LocalTime departTime,
                 int commonSeats,
                 int couchetteSeats,
                 int compartmentSeats,
                 int luxurySeats) throws TrainArgumentException {
        setDestination(destination);
        setTrainNumber(trainNumber);
        setDepartTime(departTime);
        setCommonSeats(commonSeats);
        setCouchetteSeats(couchetteSeats);
        setCompartmentSeats(compartmentSeats);
        setLuxurySeats(luxurySeats);
    }

    private String _destination;
    public String getDestination() {
        return _destination;
    }
    private void setDestination(String destination) throws TrainArgumentException {
        if (destination == null || destination.isEmpty() || destination.isBlank()) {
            throw new TrainArgumentException("Train destination cannot be empty or null.");
        }
        _destination = destination;
    }

    private String _trainNumber;
    public String getTrainNumber() {
        return _trainNumber;
    }
    private void setTrainNumber(String trainNumber) throws TrainArgumentException {
        if (trainNumber == null || trainNumber.isEmpty() || trainNumber.isBlank()) {
            throw new TrainArgumentException("Train number cannot be empty or null.");
        }
        _trainNumber = trainNumber;
    }

    private LocalTime _departTime;
    public LocalTime getDepartTime() {
        return _departTime;
    }
    public void setDepartTime(LocalTime departTime) throws TrainArgumentException {
        if (departTime.isBefore(LocalTime.now())) {
            throw new TrainArgumentException("Train departure time cannot be earlier than now.");
        }
        _departTime = departTime;
    }


    // загальні місця
    private int _commonSeats;
    public int getCommonSeats() {
        return _commonSeats;
    }
    public void setCommonSeats(int commonSeats) throws TrainArgumentException {
        if (commonSeats < 0 || commonSeats > 10000) {
            throw new TrainArgumentException("Train cannot contain common seats less than 0 or more than 10000.");
        }
        _commonSeats = commonSeats;
    }


    // купе місця
    private int _compartmentSeats;
    public int getCompartmentSeats() {
        return _compartmentSeats;
    }
    public void setCompartmentSeats(int compartmentSeats) throws TrainArgumentException {
        if (compartmentSeats < 0 || compartmentSeats > 10000) {
            throw new TrainArgumentException("Train cannot contain compartment seats less than 0 or more than 10000.");
        }
        _compartmentSeats = compartmentSeats;
    }


    // плацкартні місця
    private int _couchetteSeats;
    public int getCouchetteSeats() {
        return _couchetteSeats;
    }
    public void setCouchetteSeats(int couchetteSeats) throws TrainArgumentException {
        if (couchetteSeats < 0 || couchetteSeats > 10000) {
            throw new TrainArgumentException("Train cannot contain couchette seats less than 0 or more than 10000.");
        }
        _couchetteSeats = couchetteSeats;
    }


    // СВ місця
    private int _luxurySeats;
    public int getLuxurySeats() {
        return _luxurySeats;
    }
    public void setLuxurySeats(int luxurySeats) throws TrainArgumentException {
        if (luxurySeats < 0 || luxurySeats > 10000) {
            throw new TrainArgumentException("Train cannot contain luxury seats less than 0 or more than 10000.");
        }
        _luxurySeats = luxurySeats;
    }

    public String getStrTrain() {
        String str = "Пункт призначення: " + getDestination() +
                "\nНомер потяга: " + getTrainNumber() +
                "\nЧас відправлення: " + getDepartTime() +
                "\nЗагальні місця: " + getCommonSeats() +
                "\nКупе місця: " + getCouchetteSeats() +
                "\nПлацкарт місця: " + getCompartmentSeats() +
                "\nСВ місця: " + getLuxurySeats();

        return str;
    }
}
