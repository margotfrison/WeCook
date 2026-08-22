package me.margueritedefrize.wecook.dto.measure.types;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class WeightMeasure extends PreciseMeasure {
  private WeightMeasure(String measureId, Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    super(measureId, name, shortName, conversionFromMetric);
  }

  public static WeightMeasure of(Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return new WeightMeasure(name.getSingle(), name, shortName, conversionFromMetric);
  }

  public static WeightMeasure of(Pluralisable name, String shortName, BigDecimal conversionFromMetric) {
    return of(name, Pluralisable.of(shortName), conversionFromMetric);
  }

  public static WeightMeasure of(String name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), shortName, conversionFromMetric);
  }

  public static WeightMeasure of(String name, String shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), Pluralisable.of(shortName), conversionFromMetric);
  }
}
