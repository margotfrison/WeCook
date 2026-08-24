package me.margueritedefrize.wecook.dto.measure.type;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.utils.Pluralisable;

@EqualsAndHashCode(callSuper = true)
@Value
public class ReduceMeasure extends ImpreciseMeasure {
  private ReduceMeasure(String measureId, Pluralisable name) {
    super(measureId, name);
  }

  public static ReduceMeasure of(Pluralisable name) {
    return new ReduceMeasure(name.getSingle(), name);
  }

  public static ReduceMeasure of(String name) {
    return of(Pluralisable.of(name));
  }
}
