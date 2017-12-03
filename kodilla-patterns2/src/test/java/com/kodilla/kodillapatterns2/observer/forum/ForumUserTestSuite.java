package com.kodilla.kodillapatterns2.observer.forum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser jackBlack = new ForumUser("Jack Black");
        javaHelpForum.registerObserver(johnSmith);
        javaToolsForum.registerObserver(jackBlack);
        javaToolsForum.registerObserver(johnSmith);

        //When
        javaHelpForum.addPost("Hi! Help");
        javaToolsForum.addPost("How to deal with tool");
        javaToolsForum.addPost("you can do it like that");

        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, jackBlack.getUpdateCount());
    }
}
