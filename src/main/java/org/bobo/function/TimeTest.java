package org.bobo.function;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description java8中新引入的时间类使用用例
 */
@Log4j2
public class TimeTest {

    @Test
    public void oldTime(){
        // 线程不安全
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.format(new Date());
        // 时间不对
        Date date = new Date(2020, Calendar.MARCH, 22);
        log.info(date);
        // 报错
        java.sql.Date date1 = new java.sql.Date(new Date().getTime());
        try {
            log.info(date1.getHours());
        }catch (IllegalArgumentException e){
            log.info("IllegalArgumentException");
        }
    }
    @Test
    public void period(){
        LocalDate today = LocalDate.now();
        log.info("Today : " + today);
        LocalDate birthDate = LocalDate.of(1993, Month.OCTOBER, 19);
        log.info("BirthDate : " + birthDate);
        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日",Math.abs( p.getYears()), Math.abs(p.getMonths()) , p.getDays());
    }

    @Test
    public  void duration() {
        Instant inst1 = Instant.now();
        log.info("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        log.info("Inst2 : " + inst2);
        log.info("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());
        log.info("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }
    @Test
    public  void chronoUnit() {
        LocalDateTime startTime = LocalDateTime.of(2020, 6, 11,22,22);
        log.info("开始时间  : " + startTime);
        LocalDateTime endTime = LocalDateTime.of(2020, 12, 12,12,23,23);
        log.info("结束时间 : " + endTime);
        long minsDiff = ChronoUnit.MINUTES.between(startTime, endTime);
        log.info("两天之间的差在分钟 : " + minsDiff);
        long daysDiff = ChronoUnit.DAYS.between(startTime, endTime);
        log.info("两天之间的差在天数 : " + daysDiff);
        long monthsDiff = ChronoUnit.MONTHS.between(startTime, endTime);
        log.info("两天之间的差在月份 : " + monthsDiff);
    }
    @Test
    public void dateTimeFormatter(){
        String format = "20200609";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate formatted = LocalDate.parse(format,formatter);
        log.info("格式化 :"+formatted);
    }
    @Test
    public void transfer(){
        Instant instant  = Instant.now();
        log.info("instant :"+instant.toString());
        Date date = Date.from(instant);
        log.info("date :"+date.toString());
        Instant instant2 = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
        log.info("localDateTime :"+localDateTime.toString());
    }

}
