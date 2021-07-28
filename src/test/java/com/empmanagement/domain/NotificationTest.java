package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Neel Patel
 */
@DisplayName("Test suites for Notification class")
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
        assertNotNull(t.getMessage());
        assertEquals("aaa", t.getMessage());
    }

    @Test
    void getCreateDate() {
        Notification t = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        assertNotNull(t.getCreateDate());
        assertEquals(LocalDate.now(), t.getCreateDate());
    }
}
