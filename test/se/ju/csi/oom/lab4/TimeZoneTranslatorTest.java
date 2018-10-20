package se.ju.csi.oom.lab4;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime todayInCET = new DateTime(2018, 10, 20, 11, 18, 00);
		String todayInUSEastern = "2018-10-20 05:18:00";
		
		todayInCET = TimeZoneTranslator.shiftTimeZone(todayInCET, 1, -5);
		
		assertEquals(todayInUSEastern, todayInCET.toString());
	}

	@Test
	public void testShiftTimeZone2() {
		DateTime janFirstCET = new DateTime(2016, 01, 01, 06, 00, 00);
		DateTime decLastUSP = new DateTime(2015, 12, 31, 21, 00, 00);
		
		janFirstCET = TimeZoneTranslator.shiftTimeZone(janFirstCET, 1, -8);
		
		assertEquals(decLastUSP.toString(), janFirstCET.toString());
	}
	
	@Test
	public void testShiftEventTimeZone() {
		Person Edvin = new Person("Edvin");
		Place myHouse = new Place("myHouse", 345.2344, 231.443, 125.4431);
		DateTime startTime = new DateTime(2018, 10, 27, 19, 00, 00);
		DateTime endTime = new DateTime(2018, 10, 28, 19, 00, 00);
		
		Set<Participant> attendees = new HashSet<Participant>();
		attendees.add(Edvin);
		
		Event party = new Event("party", startTime, endTime, attendees, myHouse);
		
		party = TimeZoneTranslator.shiftEventTimeZone(party, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN);
		
		String startTimeUSE = "2018-10-27 13:00:00";
		String endTimeUSE = "2018-10-28 13:00:00";
		
		assertEquals(startTimeUSE, party.getStartDate().toString());
		assertEquals(endTimeUSE, party.getEndDate().toString());
	}
	
	@Test
	public void testDateTime() {
		DateTime todayInINTs = new DateTime(2018, 10, 20, 13, 15, 00);
		DateTime todayInString = new DateTime("2018-10-20 13:15:00");
		
		String test ="2018-10-20 13:15:00";
		
		assertEquals(test, todayInINTs.toString());
		assertEquals(test, todayInString.toString());
	}

}
