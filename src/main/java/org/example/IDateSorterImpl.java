package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IDateSorterImpl implements IDateSorter {

    private final List<Integer> rMonths = List.of(1, 2, 3, 4, 9, 10, 11, 12);

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        Map<Boolean, List<LocalDate>> collect = unsortedDates.stream()
                .collect(Collectors.partitioningBy(a -> rMonths.contains(a.getMonthValue())));

        List<LocalDate> withR = collect.get(true);
        List<LocalDate> withoutR = collect.get(false);


        return Stream.concat(withR.stream().sorted(), withoutR.stream().sorted(Comparator.reverseOrder()))
                .collect(Collectors.toList());

    }

}
