package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Bookb;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int medianPublicationYear(Map<BookSignature, Bookb> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Bookb> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }
}
