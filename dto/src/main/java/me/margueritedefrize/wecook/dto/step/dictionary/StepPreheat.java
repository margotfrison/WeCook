package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.measure.MeasureType;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepPreheat extends Step {
  Equipment equipment;
  BigDecimal preheatTemperature;

  private StepPreheat(Equipment equipment, BigDecimal preheatTemperature) {
    super(StepType.MISE_EN_PLACE);
    this.equipment = equipment;
    this.preheatTemperature = preheatTemperature;
  }

  @Override
  public String getDescription(String measureId) {
    if (preheatTemperature == null) {
      return "Preheat the %s".formatted(equipment.getName());
    } else {
      return "Preheat the %s to %s".formatted(equipment.getName(), MeasureType.TEMPERATURE.getDescription(preheatTemperature, measureId));
    }
  }

  public static StepPreheat of(Equipment equipment, BigDecimal preheatTemperature) {
    return new StepPreheat(equipment, preheatTemperature);
  }

  public static StepPreheat of(Equipment equipment) {
    return new StepPreheat(equipment, null);
  }
}
