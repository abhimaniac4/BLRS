package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.entities.helpers.BookHelper;
import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;
import library.entities.helpers.LoanHelper;
import library.entities.helpers.PatronHelper;

class LibraryTest {
	
	Library library;
	static IBookHelper bookHelper;
	static IPatronHelper patronHelper;
	static ILoanHelper loanHelper;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookHelper = new BookHelper();
		patronHelper = new PatronHelper();
		loanHelper = new LoanHelper();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		library = new Library(bookHelper, patronHelper, loanHelper);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPatronAllParams() {
		//arrange
		String ln = "Bhat";
		String fn = "Abhi";
		String email = "abhibhat@gmail.com";
		long phone = 272487287;
		
		//act
		IPatron patron = library.addPatron(ln, fn, email, phone);
		
		//assert
		assertNotNull(patron); 
		List<IPatron> pList = library.getPatronList();
		assertTrue(pList.size() == 1);
				 
	
	}

}
