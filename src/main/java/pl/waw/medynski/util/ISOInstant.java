/**
 * History:
 *
 * 2 (2019-08-30) - Fixed millisecond decimal places count (1 to 9 digits).
 * 1 (2019-04-16) - Initial release.
 */
package pl.waw.medynski.util;




/**
 * Imports.
 */
import java.time.DateTimeException;
import java.time.Instant;
import java.util.regex.Pattern;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;




/**
 * ISOInstant class.
 *
 * @author Maciej Medyński
 * @version 2
 */
public class ISOInstant
{
    /**
     * Parse string according to ISO8601 date-time with timezone format.
     * Format: (YYYY[-]MM[-]DD)'T'(HH[:]MM[:]SS[.SSS])(Z|±00[:00])
     * where [] - optional, () - group (date/time/timezone), | - or, 'x' - literal
     * milliseconds [.SSS] can be from 1 to 9 decimal places
     * For details see {@link #ISO_PATTERN}.
     * 
     * @param text
     * @return 
     * @see #ISO_PATTERN
     */
    public static Instant parse(final String text)
    {
        if (null == text) return null;
        final String dateTime = text.trim();
        if (!ISO_PATTERN.matcher(dateTime).matches())
        {
            throw new DateTimeException("Failed to match ISO8601 full DateTime with Timezone format");
        }
        final long epochMillis = org.joda.time.Instant.parse(dateTime, DATETIME_FORMATTER).getMillis(); // to epoch UTC
        return Instant.ofEpochMilli(epochMillis); // from epoch UTC
    }
    
    
    /**
     * ISO-8601 supported variants pattern.
     */
    private static final Pattern ISO_PATTERN = Pattern
            .compile("^((\\d{8})|(\\d{4}-\\d{2}-\\d{2}))T((\\d{6})|(\\d{2}:\\d{2}:\\d{2}))(\\.\\d{1,9})?(([+-]\\d{2}(:?\\d{2})?)|Z)$");
    
    
    /**
     * Date separator parser.
     */
    private static final DateTimeParser DATE_SEPARATOR_PARSER = new DateTimeFormatterBuilder()
            .appendLiteral('-')
            .toParser();
    
    
    /**
     * Time separator parser.
     */
    private static final DateTimeParser TIME_SEPARATOR_PARSER = new DateTimeFormatterBuilder()
            .appendLiteral(':')
            .toParser();
    
    
    /**
     * Decimal point parser (took from Joda).
     */
    private static final DateTimeParser DECIMAL_POINT_PARSER = new DateTimeFormatterBuilder()
            .append(null, new DateTimeParser[]
            {
                new DateTimeFormatterBuilder().appendLiteral('.').toParser(),
                new DateTimeFormatterBuilder().appendLiteral(',').toParser()
            })
            .toParser();
    
    
    /**
     * Milliseconds parser.
     */
    private static final DateTimeParser MILLIS_PARSER = new DateTimeFormatterBuilder()
            .append(DECIMAL_POINT_PARSER)
            .appendFractionOfSecond(1, 9)
            .toParser();
    
    
    /**
     * Date-time parser.
     */
    private static final DateTimeParser DATETIME_PARSER = new DateTimeFormatterBuilder()
            .appendYear(4, 4)
            .appendOptional(DATE_SEPARATOR_PARSER)
            .appendMonthOfYear(2)
            .appendOptional(DATE_SEPARATOR_PARSER)
            .appendDayOfMonth(2)
            .appendLiteral('T')
            .appendHourOfDay(2)
            .appendOptional(TIME_SEPARATOR_PARSER)
            .appendMinuteOfHour(2)
            .appendOptional(TIME_SEPARATOR_PARSER)
            .appendSecondOfMinute(2)
            .appendOptional(MILLIS_PARSER)
            .appendTimeZoneOffset("Z", true, 2, 4)
            .toParser();
    
    
    /**
     * Date-time formatter.
     */
    private static final DateTimeFormatter DATETIME_FORMATTER = new DateTimeFormatterBuilder()
            .append(null, new DateTimeParser[] { DATETIME_PARSER })
            .toFormatter();
}
