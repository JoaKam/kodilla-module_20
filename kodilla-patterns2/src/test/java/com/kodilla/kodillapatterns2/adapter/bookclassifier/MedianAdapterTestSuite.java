package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Booka;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        Set<Booka> books = new HashSet<>();
        books.add(new Booka ("Paulo Coelho", "Alchemist", 1990, "AA6768"));
        books.add(new Booka ("Paulo Coelho", "Alchemist2", 1991, "AA6771"));
        books.add(new Booka ("Paulo Coelho", "Alchemist3", 1992, "AA6778"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int booksPublicationMedian = medianAdapter.publicationYearMedian(books);

        //Then
        System.out.println(booksPublicationMedian);
        Assert.assertEquals(booksPublicationMedian, 1991,0);
    }
}
