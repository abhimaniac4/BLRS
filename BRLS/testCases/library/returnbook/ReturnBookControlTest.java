package library.returnbook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.IBook;
import library.entities.ILoan;
import library.entities.IPatron;
import library.entities.Library;
import library.returnbook.ReturnBookControl;
import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;


@ExtendWith(MockitoExtension.class) 

class ReturnBookControlTest {
	@Mock IBookHelper mockBookHelper;
	@Mock IPatronHelper mockPatronHelper;
	@Mock ILoanHelper mockLoanHelper;
	
	@Mock IPatron mockPatron;
	@Mock ILoan mockCurrentLoan;
	@Mock IBook mockBook;
	
	@InjectMocks
	
	Library library;
	ReturnBookControl returnBookControl;

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
	void testBookScanned() {
		//arrange
		String ln = "Smith";
		String fn = "Peter";
		String email = "petersmith@gmail.com";
		long phone = 173456789;
		int bookId = 4;
		double overDueFine = 0.0;
		
		when(mockCurrentLoan.getBook()).thenReturn(mockBook);
		when(mockBook.getId()).thenReturn(bookId);
		//act
		
		returnBookControl.bookScanned(bookId);
		//assert
		assertTrue(mockCurrentLoan.isOverDue());
	}

}
