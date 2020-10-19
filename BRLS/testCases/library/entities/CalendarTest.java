package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.ICalendar;


@ExtendWith(MockitoExtension.class) 


class CalendarTest {
	
    @Mock IBook mockBook;
	
	@InjectMocks

	Calendar mockCalendar;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetDaysDifference() {
		//arrange
		mockCalendar.getDate();
		//act
		mockCalendar.incrementDate(3);
		Date targetDate = mockCalendar.getDate();
		//assert
		assertEquals(3,mockCalendar.getDaysDifference(targetDate));
	}

}
