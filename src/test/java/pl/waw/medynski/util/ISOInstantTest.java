/**
 * History:
 *
 * 1 (2019-04-16) - Initial release.
 */
package pl.waw.medynski.util;




/**
 * Imports.
 */
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




/**
 * ISOInstantTest class.
 *
 * @author Maciej Medyński
 * @version 1
 */
public class ISOInstantTest
{
    @Test
    public void parse_full()
    {
        Instant d1 = ISOInstant.parse("1970-01-01T00:00:01.000Z");
        Instant d2 = ISOInstant.parse("1970-01-01T00:00:01Z");
        Instant d3 = ISOInstant.parse("1970-01-01T00:00:01.000+00:00");
        Instant d4 = ISOInstant.parse("1970-01-01T00:00:01+00:00");
        Instant d5 = ISOInstant.parse("1970-01-01T01:00:01+01:00");
        Instant d6 = ISOInstant.parse("1970-01-01T05:30:01.0+05:30");
        Instant d7 = ISOInstant.parse("1970-01-01T05:30:01.000+05:30");
        Instant d8 = ISOInstant.parse("1970-01-01T05:30:01.000000000+05:30");
        Date date = new Date(1000);
        
        Assertions.assertEquals(d1, d2);
        Assertions.assertEquals(d1, d3);
        Assertions.assertEquals(d1, d4);
        Assertions.assertEquals(d1, d5);
        Assertions.assertEquals(d1, d6);
        Assertions.assertEquals(d1, d7);
        Assertions.assertEquals(d1, d8);
        Assertions.assertEquals(d1.toEpochMilli(), date.getTime());
    }
    
    
    @Test
    public void parse_dateshort()
    {
        Instant d1 = ISOInstant.parse("19700101T00:00:01.000Z");
        Instant d2 = ISOInstant.parse("19700101T00:00:01Z");
        Instant d3 = ISOInstant.parse("19700101T00:00:01.000+00:00");
        Instant d4 = ISOInstant.parse("19700101T00:00:01+00:00");
        Instant d5 = ISOInstant.parse("19700101T01:00:01+01:00");
        Instant d6 = ISOInstant.parse("19700101T05:30:01.0+05:30");
        Instant d7 = ISOInstant.parse("19700101T05:30:01.000+05:30");
        Instant d8 = ISOInstant.parse("19700101T05:30:01.000000000+05:30");
        Date date = new Date(1000);
        
        Assertions.assertEquals(d1, d2);
        Assertions.assertEquals(d1, d3);
        Assertions.assertEquals(d1, d4);
        Assertions.assertEquals(d1, d5);
        Assertions.assertEquals(d1, d6);
        Assertions.assertEquals(d1, d7);
        Assertions.assertEquals(d1, d8);
        Assertions.assertEquals(d1.toEpochMilli(), date.getTime());
    }
    
    
    @Test
    public void parse_timeshort()
    {
        Instant d1 = ISOInstant.parse("1970-01-01T000001.000Z");
        Instant d2 = ISOInstant.parse("1970-01-01T000001Z");
        Instant d3 = ISOInstant.parse("1970-01-01T000001.000+00:00");
        Instant d4 = ISOInstant.parse("1970-01-01T000001+00:00");
        Instant d5 = ISOInstant.parse("1970-01-01T010001+01:00");
        Instant d6 = ISOInstant.parse("1970-01-01T053001.0+05:30");
        Instant d7 = ISOInstant.parse("1970-01-01T053001.000+05:30");
        Instant d8 = ISOInstant.parse("1970-01-01T053001.000000000+05:30");
        Date date = new Date(1000);
        
        Assertions.assertEquals(d1, d2);
        Assertions.assertEquals(d1, d3);
        Assertions.assertEquals(d1, d4);
        Assertions.assertEquals(d1, d5);
        Assertions.assertEquals(d1, d6);
        Assertions.assertEquals(d1, d7);
        Assertions.assertEquals(d1, d8);
        Assertions.assertEquals(d1.toEpochMilli(), date.getTime());
    }
    
    
    @Test
    public void parse_short()
    {
        Instant d1 = ISOInstant.parse("19700101T000001.000Z");
        Instant d2 = ISOInstant.parse("19700101T000001Z");
        Instant d3 = ISOInstant.parse("19700101T000001.000+00:00");
        Instant d4 = ISOInstant.parse("19700101T000001+00:00");
        Instant d5 = ISOInstant.parse("19700101T010001+01:00");
        Instant d6 = ISOInstant.parse("19700101T053001.0+05:30");
        Instant d7 = ISOInstant.parse("19700101T053001.000+05:30");
        Instant d8 = ISOInstant.parse("19700101T053001.000000000+05:30");
        Date date = new Date(1000);
        
        Assertions.assertEquals(d1, d2);
        Assertions.assertEquals(d1, d3);
        Assertions.assertEquals(d1, d4);
        Assertions.assertEquals(d1, d5);
        Assertions.assertEquals(d1, d6);
        Assertions.assertEquals(d1, d7);
        Assertions.assertEquals(d1, d8);
        Assertions.assertEquals(d1.toEpochMilli(), date.getTime());
    }
}
