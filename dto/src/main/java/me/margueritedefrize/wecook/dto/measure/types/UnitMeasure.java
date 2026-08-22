package me.margueritedefrize.wecook.dto.measure.types;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class UnitMeasure extends PreciseMeasure {
  private UnitMeasure(String measureId, Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    super(measureId, name, shortName, conversionFromMetric);
  }

  public static UnitMeasure of(Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return new UnitMeasure(name.getSingle(), name, shortName, conversionFromMetric);
  }

  public static UnitMeasure of(Pluralisable name, String shortName, BigDecimal conversionFromMetric) {
    return of(name, Pluralisable.of(shortName), conversionFromMetric);
  }

  public static UnitMeasure of(String name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), shortName, conversionFromMetric);
  }

  public static UnitMeasure of(String name, String shortName, BigDecimal conversionFromMetric) {
    return of(Pluralisable.of(name), Pluralisable.of(shortName), conversionFromMetric);
  }
}
