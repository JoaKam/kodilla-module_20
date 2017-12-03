package com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, Bookb> books);

    int medianPublicationYear(Map<BookSignature, Bookb> books);
}
