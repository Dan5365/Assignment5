package org.example;

public class VideoDelivery implements DeliveryMethod {
    @Override
    public void deliver(String courseName, Student student) {
        System.out.println("[VideoDelivery] Playing video lesson for " + courseName + " to " + student.getName());
    }
}
