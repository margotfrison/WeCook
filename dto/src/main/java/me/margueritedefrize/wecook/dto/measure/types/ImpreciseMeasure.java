package me.margueritedefrize.wecook.dto.measure.types;

import me.margueritedefrize.wecook.dto.measure.Measure;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

import java.math.BigDecimal;

public abstract class ImpreciseMeasure extends Measure {
  protected ImpreciseMeasure(String id, Pluralisable name) {
    super(id, name);
  }

  @Override
  public BigDecimal convert(BigDecimal metric) {
    return metric;
  }

  @Override
  public String toString() {
    return format();
  }

  public String format() {
    return format(null);
  }

  @Override
  public String format(BigDecimal quantity) {
    return name.getSingle();
  }
}
