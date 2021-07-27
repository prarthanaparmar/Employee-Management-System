package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.empmanagement.domain.Notification;

import org.junit.Test;
import java.time.LocalDate;


public class NotificationServiceTest {
    
    @Test
    void getNotifications() {
        NotificationService t = new NotificationService();
        assertNotNull(t.getNotifications(0));
    }

    @Test
    void getNotification() {
        NotificationService t = new NotificationService();
        assertNotNull(t.getNotification(0));
    }

    @Test
    void createOrUpdateNotification() {
        NotificationService t = new NotificationService();
        Notification tt = new Notification(1, 12345678910L, "aaa", LocalDate.now());

        assertTrue(t.createOrUpdateNotification(tt));
    }

    @Test
    void createNotification() {
        NotificationService t = new NotificationService();
        assertTrue(t.createNotification(0, "aaa"));
    }
}
