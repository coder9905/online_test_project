package uz.zako.online_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DateConfig {

//    @Bean
//    public Date convertToLocalDateTimeViaInstant(Date dateToConvert) {
//        LocalDateTime localDateTime = dateToConvert.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime().plusMinutes(5);
//        return java.sql.Timestamp.valueOf(localDateTime);
//    }
}
