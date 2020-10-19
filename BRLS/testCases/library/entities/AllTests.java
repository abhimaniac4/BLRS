package library.entities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CalendarTest.class, ReturnBookControlTest.class, LibraryMockTest.class})
public class AllTests {}
