package FinalExam;

public class Main {

	
	    public static void main(String[] args) {
	        Date date = new Date(6,1,1999);
	        Guest guest1 = new Guest("Joseph Cuevas", "(714) 714-7147", "joseph@gmail.com", "AMEX 0000 XXXX", date, "12:00", "Deluxe Meal Plan", "extraInfo" );
	        Guest guest2 = new Guest("Tristan Nguyen", "(714) 715-7147", "tristan@gmail.com", "AMEX 0001 XXXX", date, "12:00", "Basic Meal Plan", "extraInfo" );
	        AquaWorld aW = new AquaWorld();
	        Reservation r = new Reservation(aW,date,guest2,true, 1);
	        FrontDeskAgent.getWaitList().add(r);
	        FrontDeskAgent.getGuests().add(guest1);
	        new EditReservationFrame();
	    }

	
}
