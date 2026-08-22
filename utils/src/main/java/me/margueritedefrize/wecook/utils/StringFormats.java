package me.margueritedefrize.wecook.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;

public class StringFormats {
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");
  private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("0.");

  public static String decimal(BigDecimal bigDecimal) {
    return DECIMAL_FORMAT.format(bigDecimal);
  }

  public static String duration(Duration duration) {
    if (duration.toDays() > 0) {
      long days = duration.toDays();
      return INTEGER_FORMAT.format(duration.toDays()) + " day" + (days > 1 ? "s" : "");
    } else if (duration.toHours() > 0) {
      long hours = duration.toHours();
      return INTEGER_FORMAT.format(duration.toHours()) + " hour" + (hours > 1 ? "s" : "");
    } else if (duration.toMinutes() > 0) {
      long minutes = duration.toMinutes();
      return INTEGER_FORMAT.format(duration.toMinutes()) + " minute" + (minutes > 1 ? "s" : "");
    } else {
      long seconds = duration.toSeconds();
      return INTEGER_FORMAT.format(duration.toSeconds()) + " second" + (seconds > 1 ? "s" : "");
    }
  }
}
