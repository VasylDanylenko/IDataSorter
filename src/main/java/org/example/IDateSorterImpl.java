package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IDateSorterImpl implements IDateSorter {

    private final List<Integer> month = List.of(5, 6, 7, 8);
    private final List<Integer> rMonth = List.of(1, 2, 3, 4, 9, 10, 11, 12);

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> rMonthSortedList = unsortedDates.stream()
                .filter(e -> rMonth.contains(e.getMonthValue())).sorted().toList();

        List<LocalDate> monthReverseSortedList = unsortedDates.stream()
                .filter(e -> month.contains(e.getMonthValue())).sorted(Comparator.reverseOrder()).toList();

        return Stream.concat(rMonthSortedList.stream(), monthReverseSortedList.stream()).collect(Collectors.toList());

    }

}
