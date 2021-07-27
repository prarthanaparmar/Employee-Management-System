package com.empmanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;  

public class NotificationTest {
    @Test
    void getEmpId() {
        Notification t = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        assertEquals(12345678910L, t.getEmpId());
    }

    @Test
    void getNotificationId() {
        Notification t = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        assertEquals(1, t.getNotificationId());
    }

    @Test
    void getMessage() {
        Notification t = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        assertEquals("aaa", t.getMessage());
    }

    @Test
    void getCreateDate() {
        Notification t = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        assertEquals(LocalDate.now(), t.getCreateDate());
    }
}
