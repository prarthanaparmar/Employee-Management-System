//package com.empmanagement;
//
//import com.empmanagement.dao.IPeerReviewDAO;
//import com.empmanagement.dao.IReviewsDAO;
//import com.empmanagement.domain.TimeSheetDetail;
//import com.empmanagement.service.IPeerReviewsService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class PeerReviewsImplTests {
//    private static final String EMP_ID = "1";
//    private static final String DATE = "22-07-2021";
//    private static final String DAY = "THURSDAY";
//    private static final String START_TIME = "09:00:00";
//    private static final String END_TIME = "20:00:00";
//    private static final String HOURS_WORKED = "11";
//    private static final String FUTURE_DATE = "22-07-2022";
//
//    @Autowired
//    IPeerReviewsService peerReviews;
//
//    @MockBean
//    private IPeerReviewDAO peerReviewDAO;
//    @MockBean
//    private IReviewsDAO reviewsDAO;
//
//    @Test
//    void getTimeSheetDetailsTest() {
//
//        TimeSheetDetail timeSheetDetail=setTimeSheeet();
//
//        when(timeSheetDAO.getTimeSheetDetail("1")).thenReturn(Stream
//                .of(timeSheetDetail).collect(Collectors.toList()));
//        assertEquals(1, timeSheetService.getTimeSheetDetails("1").size());
//    }
//}
