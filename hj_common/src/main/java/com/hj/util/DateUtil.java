package com.hj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    //时间格式
    public static final String PATTERN_YYYYMMDDHH = "yyyyMMddHH";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    public static final String PATTERN_YYYY = "yyyy";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String PATTERN_YYYY_MM_DDHHMM = "yyyy-MM-dd HH:mm";

    /***
     * 从yyyy-MM-dd HH:mm格式转成yyyyMMddHH格式
     * @param dateStr
     * @return
     */
    public static String formatStr(String dateStr, String opattern, String npattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(opattern);
        try {
            Date date = simpleDateFormat.parse(dateStr);
            simpleDateFormat = new SimpleDateFormat(npattern);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 获取指定日期的凌晨
     * @return
     */
    public static Date toDayStartHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = calendar.getTime();
        return start;
    }


    /***
     * 时间增加N分钟
     * @param date
     * @param minutes
     * @return
     */
    public static Date addDateMinutes(Date date,int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);// 24小时制
        date = calendar.getTime();
        return date;
    }

    /***
     * 时间递增N小时
     * @param hour
     * @return
     */
    public static Date addDateHour(Date date,int hour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);// 24小时制
        date = calendar.getTime();
        return date;
    }

    /***
     * 获取时间菜单
     * @return
     */
    public static List<Date> getDateMenus(){
        //定义一个List<Date>集合，存储所有时间段
        List<Date> dates = getDates(12);
        //判断当前时间属于哪个时间范围
        Date now = new Date();
        for (Date cdate : dates) {
            //开始时间<=当前时间<开始时间+2小时
            if(cdate.getTime()<=now.getTime() && now.getTime()<addDateHour(cdate,2).getTime()){
                now = cdate;
                break;
            }
        }

        //当前需要显示的时间菜单
        List<Date> dateMenus = new ArrayList<Date>();
        for (int i = 0; i <5 ; i++) {
            dateMenus.add(addDateHour(now,i*2));
        }
        return dateMenus;
    }

    /***
     * 指定时间往后N个时间间隔
     * @param hours
     * @return
     */
    public static List<Date> getDates(int hours) {
        List<Date> dates = new ArrayList<Date>();
        //循环12次
        Date date = toDayStartHour(new Date()); //凌晨
        for (int i = 0; i <hours ; i++) {
            //每次递增2小时,将每次递增的时间存入到List<Date>集合中
            dates.add(addDateHour(date,i*2));
        }
        return dates;
    }

    /***
     * 时间转成yyyyMMddHH
     * @param date
     * @param pattern
     * @return
     */
    public static String data2str(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static java.sql.Timestamp getCurrentTimestamp() {
        return new java.sql.Timestamp(new Date().getTime());
    }

    /**
     * @return
     */
    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        Date dtNow = calNow.getTime();
        return dtNow;
    }

    /**
     * 获取当前时间：格式"yyyyMMddHHmmss"
     *
     * @return
     */
    public static String getCurrentDate() {
        // 获取当前时间的时间戳（毫秒数）
        long currentTimeMillis = System.currentTimeMillis();
        // 创建SimpleDateFormat对象，指定时间格式为YYYYMMDDHHMMSS
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
        // 使用SimpleDateFormat对象将时间戳格式化为指定格式的字符串
        String timestamp = sdf.format(currentTimeMillis);
        return timestamp;
    }

    /**
     * 获取当前时间 yyyy-MM-dd
     *
     * @return
     */
    public static String getCurrentDate(String formDate) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(formDate);
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    /**
     * 获取当前时间之前的日期
     *
     * @return
     */
    public static LocalDate getYesterday(Integer day) {
        LocalDate currentDate = LocalDate.now();
        // 获取前一天日期
        LocalDate previousDate = currentDate.minusDays(day);
        // 输出前一天日期
        return previousDate;
    }

    /**
     * 将"yyyy/MM/dd" 转换成 "yyyy-MM-dd"
     *
     * @param dateStr
     * @return
     */
    public static String parsFormatDate(String dateStr) {
        Date formatDat = null;
        try {
            formatDat = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String str = new SimpleDateFormat("yyyy-MM-dd").format(formatDat);
        return str;
    }

    public static void main(String[] args) {
    }
}
