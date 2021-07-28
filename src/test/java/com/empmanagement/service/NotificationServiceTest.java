package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.empmanagement.dao.NotificationDAO;
import com.empmanagement.domain.Notification;
import com.empmanagement.serviceimpl.NotificationService;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * 
 * @author Neel Patel
 *
 */
@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {
    
    @Mock
	NotificationDAO notificationDAO;

    @InjectMocks
	INotificationService notificationService;


    @Test
    void getNotifications() {
        Mockito.when(notificationDAO.getNotifications(1L))
        .thenReturn(new ArrayList<Notification>());
        
        assertNotNull(notificationService.getNotifications(0));
    }

    @Test
    void getNotification() {
        Mockito.when(notificationDAO.getNotification(1))
        .thenReturn(new Notification(1, 1, "Test Notification", LocalDate.now()));
        assertNotNull(notificationService.getNotification(1));
    }

    @Test
    void createOrUpdateNotification() {
        Notification tt = new Notification(1, 12345678910L, "aaa", LocalDate.now());
        
        Mockito.when(notificationDAO.createOrUpdateNotification(tt))
        .thenReturn(true);
        
        assertTrue(notificationService.createOrUpdateNotification(tt));
    }

    @Test
    void createNotification() {
        Notification tt = new Notification(1, 1L, "aaa", LocalDate.now());
        Mockito.when(notificationDAO.createOrUpdateNotification(tt))
        .thenReturn(true);
        assertTrue(notificationService.createNotification(1L, "aaa"));
    }
}
