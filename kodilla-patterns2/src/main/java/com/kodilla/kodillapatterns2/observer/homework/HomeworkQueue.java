package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<Observer> observers;
    private final ArrayDeque<String> homeworks;
    private final String studentName;

    public HomeworkQueue(String studentName) {
        observers = new ArrayList<>();
        homeworks = new ArrayDeque<>();
        this.studentName = studentName;
    }

    public ArrayDeque<String> getHomeworks() {
        return homeworks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addHomework(String homework) {
        homeworks.offer(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
