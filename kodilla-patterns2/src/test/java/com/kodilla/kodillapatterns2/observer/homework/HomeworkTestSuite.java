package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void homeworkUpdate(){
        //Given
        HomeworkQueue johnSmithHomeworks = new HomeworkQueue("John Smith");
        HomeworkQueue johnBlackHomeworks = new HomeworkQueue("John Black");
        HomeworkQueue johnJohnsonHomeworks = new HomeworkQueue("John Johnson");
        HomeworkQueue johnWhiteHomeworks = new HomeworkQueue("John White");
        Mentor joannaSmith = new Mentor("Joanna Smith");
        Mentor joannaBlack = new Mentor("Joanna Black");
        johnSmithHomeworks.registerObserver(joannaSmith);
        johnBlackHomeworks.registerObserver(joannaBlack);
        johnJohnsonHomeworks.registerObserver(joannaSmith);
        johnWhiteHomeworks.registerObserver(joannaSmith);

        //When
        johnSmithHomeworks.addHomework("homework 1");
        johnSmithHomeworks.addHomework("homework 2");
        johnBlackHomeworks.addHomework("homework 1");
        johnBlackHomeworks.addHomework("homework 2");
        johnBlackHomeworks.addHomework("homework 3");
        johnJohnsonHomeworks.addHomework("homework 1");
        johnWhiteHomeworks.addHomework("homework 1");

        //Then
        assertEquals(4, joannaSmith.getUpdateCount());
        assertEquals("homework 1", johnBlackHomeworks.getHomeworks().peek());
        assertEquals(3, joannaBlack.getUpdateCount());
    }
}
