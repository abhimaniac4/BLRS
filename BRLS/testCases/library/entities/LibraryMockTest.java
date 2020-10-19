package library.entities;

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

import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;


@ExtendWith(MockitoExtension.class) 

class LibraryMockTest {
	
	@Mock IBookHelper mockBookHelper;
	@Mock IPatronHelper mockPatronHelper;
	@Mock ILoanHelper mockLoanHelper;
	
	@Mock IPatron mockPatron;
	@Mock ILoan mockLoan;
	@Mock IBook mockBook;
	
	@InjectMocks
	
	Library library;
	
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
	void testLibraryAllParamsOK() {
		//arrange
	    String ln = "Bhat";
		String fn = "Abhi";
		String email = "abhibhat@gmail.com";
		long phone = 272487287;
		int id = 1;
				
		when(mockPatronHelper.makePatron(ln, fn, email, phone, id)).thenReturn(mockPatron);
				
		//act
		IPatron patron = library.addPatron(ln, fn, email, phone);
				
		//assert
		assertNotNull(patron); 
		List<IPatron> pList = library.getPatronList();
		assertTrue(pList.size() == 1);
	}
	
	@Test 
	void testDischargeLoan() {
		//arrange
		 String ln = "Doe";
			String fn = "John";
			String email = "jonedoe@gmail.com";
			long phone = 123456789;
			int id = 2;
			int bookId = 1;
			boolean isDamaged = false;
					
			when(mockLoan.getBook()).thenReturn(mockBook);
			when(mockBook.getId()).thenReturn(bookId);
			when(mockPatronHelper.makePatron(ln, fn, email, phone, id)).thenReturn(mockPatron);
			when(mockLoan.getPatron()).thenReturn(mockPatron);

		//act
		 library.dischargeLoan(mockLoan, isDamaged);
		//assert
		 ILoan loan = library.getCurrentLoanByBookId(bookId);
		 assertEquals(loan, mockLoan);
	}

}
