package me.margueritedefrize.wecook.dto.measure.types;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class TemperatureMeasure extends PreciseMeasure {
  private TemperatureMeasure(String measureId, Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    super(measureId, name, shortName, conversionFromMetric);
  }

  public static TemperatureMeasure of(Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return new TemperatureMeasure(name.getSingle(), name, shortName, conversionFromMetric);
  }

  public static TemperatureMeasure of(Pluralisable name, String shortName, BigDecimal conversionFromMetric) {
    return of(name, Pluralisable.of(shortName), conversionFromMetric);
  }

  public static TemperatureMeasure of(String name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), shortName, conversionFromMetric);
  }

  public static TemperatureMeasure of(String name, String shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), Pluralisable.of(shortName), conversionFromMetric);
  }
}
