package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Booka;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Bookb;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Booka> bookSet) {
        Map<BookSignature, Bookb> bookMap = new HashMap();

        for (Booka book : bookSet) {
            bookMap.put(new BookSignature(book.getSignature()), new Bookb(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }

        return medianPublicationYear(bookMap);
    }
}
