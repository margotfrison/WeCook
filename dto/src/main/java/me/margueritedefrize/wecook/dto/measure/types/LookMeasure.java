package me.margueritedefrize.wecook.dto.measure.types;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

@EqualsAndHashCode(callSuper = true)
@Value
public class LookMeasure extends ImpreciseMeasure {
  private LookMeasure(String measureId, Pluralisable name) {
    super(measureId, name);
  }

  public static LookMeasure of(Pluralisable name) {
    return new LookMeasure(name.getSingle(), name);
  }

  public static LookMeasure of(String name) {
    return of(Pluralisable.of(name));
  }
}
