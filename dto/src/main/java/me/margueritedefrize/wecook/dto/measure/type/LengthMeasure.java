package me.margueritedefrize.wecook.dto.measure.type;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.utils.Pluralisable;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class LengthMeasure extends PreciseMeasure {
  private LengthMeasure(String measureId, Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    super(measureId, name, shortName, conversionFromMetric);
  }

  public static LengthMeasure of(Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return new LengthMeasure(name.getSingle(), name, shortName, conversionFromMetric);
  }

  public static LengthMeasure of(Pluralisable name, String shortName, BigDecimal conversionFromMetric) {
    return of(name, Pluralisable.of(shortName), conversionFromMetric);
  }

  public static LengthMeasure of(String name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), shortName, conversionFromMetric);
  }

  public static LengthMeasure of(String name, String shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), Pluralisable.of(shortName), conversionFromMetric);
  }
}
