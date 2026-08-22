package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.types.HeatMeasure;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;
import me.margueritedefrize.wecook.utils.StringFormats;

import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Data
public class StepCookTime extends Step {
  private Equipment equipment;
  private Ingredient ingredient;
  private HeatMeasure heat;
  private Duration duration;

  private StepCookTime(Equipment equipment, HeatMeasure heat) {
    super(StepType.MISE_EN_PLACE);
    this.equipment = equipment;
    this.heat = heat;
  }

  @Override
  public String getDescription(String measureId) {
    return "Cook %s in the %s at %s heat for %s".formatted(ingredient.getName(), equipment.getName(), heat, StringFormats.duration(duration));
  }
}
