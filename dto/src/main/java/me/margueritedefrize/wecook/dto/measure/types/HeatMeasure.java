package me.margueritedefrize.wecook.dto.measure.types;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

@EqualsAndHashCode(callSuper = true)
@Value
public class HeatMeasure extends ImpreciseMeasure {
  private HeatMeasure(String measureId, Pluralisable name) {
    super(measureId, name);
  }

  public static HeatMeasure of(Pluralisable name) {
    return new HeatMeasure(name.getSingle(), name);
  }

  public static HeatMeasure of(String name) {
    return of(Pluralisable.of(name));
  }
}
