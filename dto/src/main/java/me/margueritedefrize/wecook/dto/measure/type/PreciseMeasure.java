package me.margueritedefrize.wecook.dto.measure.type;

import me.margueritedefrize.wecook.dto.measure.Measure;
import me.margueritedefrize.wecook.utils.Pluralisable;
import me.margueritedefrize.wecook.utils.StringFormats;

import java.math.BigDecimal;

public abstract class PreciseMeasure extends Measure {
  protected final Pluralisable shortName;
  protected final BigDecimal conversionFromMetric;

  protected PreciseMeasure(String measureId, Pluralisable name, Pluralisable shortName, BigDecimal conversionFromMetric) {
    super(measureId, name);
    this.shortName = shortName;
    this.conversionFromMetric = conversionFromMetric;
  }

  @Override
  public BigDecimal convert(BigDecimal metric) {
    if (BigDecimal.ONE.equals(conversionFromMetric))
      return metric;
    return metric.multiply(conversionFromMetric);
  }

  @Override
  public String format(BigDecimal quantity) {
    return "%s %s".formatted(StringFormats.decimal(convert(quantity)), shortName);
  }
}
