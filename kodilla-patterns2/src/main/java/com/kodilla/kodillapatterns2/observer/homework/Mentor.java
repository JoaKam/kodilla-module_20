package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor implements Observer{
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println(mentorName + ": New homework from " + homeworkQueue.getStudentName() +
                ", (total number of homeworks: " + homeworkQueue.getHomeworks().size());

        updateCount++;
    }

    public String getUsername() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
