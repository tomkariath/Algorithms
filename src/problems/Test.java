package problems;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		ZonedDateTime zoneDateTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
		System.out.println(zoneDateTime);
	}
}
