/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class DateFormatter implements Formatter<Date>{

    final String defaultDateFormat = "yyyy-MM-dd'T'HH:mm";
    
    @Override
    public String print(Date t, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormat);
        return sdf.format(t);
    }

    @Override
    public Date parse(String string, Locale locale) throws ParseException {
        return DateUtils.parseDate(string, defaultDateFormat);
    }
    
}
