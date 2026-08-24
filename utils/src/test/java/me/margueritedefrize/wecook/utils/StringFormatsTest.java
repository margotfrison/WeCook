package me.margueritedefrize.wecook.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFormatsTest {
  @Test
  void decimal() {
    // Given && When
    String lowDecimal = StringFormats.decimal(new BigDecimal("0.000008646"));
    String normalDecimal = StringFormats.decimal(new BigDecimal("15.35456"));
    String integer = StringFormats.decimal(new BigDecimal("651"));
    String decimalTwoDecimal = StringFormats.decimal(new BigDecimal("23.65"));
    String decimalOneDecimal = StringFormats.decimal(new BigDecimal("1.9"));
    String highDecimal = StringFormats.decimal(new BigDecimal("6541654156464564545645.6515645645"));
    // Then
    assertEquals("0", lowDecimal);
    assertEquals("15.35", normalDecimal);
    assertEquals("651", integer);
    assertEquals("23.65", decimalTwoDecimal);
    assertEquals("1.9", decimalOneDecimal);
    assertEquals("6541654156464564545645.65", highDecimal);
  }

  @Test
  void duration() {
    // Given
    Duration lowDuration = Duration.of(12, ChronoUnit.MILLIS);
    Duration secondDuration = Duration.of(1, ChronoUnit.SECONDS);
    Duration secondsDuration = Duration.of(56, ChronoUnit.SECONDS);
    Duration minuteDuration = Duration.of(1, ChronoUnit.MINUTES);
    Duration minutesDuration = Duration.of(32, ChronoUnit.MINUTES);
    Duration hourDuration = Duration.of(1, ChronoUnit.HOURS);
    Duration hoursDuration = Duration.of(5, ChronoUnit.HOURS);
    Duration dayDuration = Duration.of(1, ChronoUnit.DAYS);
    Duration daysDuration = Duration.of(23, ChronoUnit.DAYS);
    Duration highDuration = Duration.of(7002, ChronoUnit.DAYS);
    // When
    String lowDurationString = StringFormats.duration(lowDuration);
    String secondDurationString = StringFormats.duration(secondDuration);
    String secondsDurationString = StringFormats.duration(secondsDuration);
    String minuteDurationString = StringFormats.duration(minuteDuration);
    String minutesDurationString = StringFormats.duration(minutesDuration);
    String hourDurationString = StringFormats.duration(hourDuration);
    String hoursDurationString = StringFormats.duration(hoursDuration);
    String dayDurationString = StringFormats.duration(dayDuration);
    String daysDurationString = StringFormats.duration(daysDuration);
    String highDurationString = StringFormats.duration(highDuration);
    // Then
    assertEquals("0 second", lowDurationString);
    assertEquals("1 second", secondDurationString);
    assertEquals("56 seconds", secondsDurationString);
    assertEquals("1 minute", minuteDurationString);
    assertEquals("32 minutes", minutesDurationString);
    assertEquals("1 hour", hourDurationString);
    assertEquals("5 hours", hoursDurationString);
    assertEquals("1 day", dayDurationString);
    assertEquals("23 days", daysDurationString);
    assertEquals("7002 days", highDurationString);
  }
}
