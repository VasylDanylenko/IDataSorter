package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IDateSorterImplTest {

    private final List<LocalDate> localDateList = List.of(
            LocalDate.of(2005, 7, 1), LocalDate.of(2005, 1, 2),
            LocalDate.of(2005, 1, 1), LocalDate.of(2005, 5, 3));

    @Test
    void sortDates_ListOfDate_SortedListOfDate() {

        Collection<LocalDate> actual = List.of(
                LocalDate.of(2005, 1, 1), LocalDate.of(2005, 1, 2),
                LocalDate.of(2005, 7, 1), LocalDate.of(2005, 5, 3));

        IDateSorterImpl iDateSorter = new IDateSorterImpl();

        Collection<LocalDate> expected = iDateSorter.sortDates(localDateList);

        assertEquals(actual, expected);

    }

}