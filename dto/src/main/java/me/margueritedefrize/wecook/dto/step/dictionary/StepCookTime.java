package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.*;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.type.HeatMeasure;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;
import me.margueritedefrize.wecook.utils.StringFormats;

import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepCookTime extends Step {
  Equipment equipment;
  Ingredient ingredient;
  HeatMeasure heat;
  Duration duration;

  private StepCookTime(Equipment equipment, Ingredient ingredient, HeatMeasure heat, Duration duration) {
    super(StepType.MISE_EN_PLACE);
    this.equipment = equipment;
    this.ingredient = ingredient;
    this.heat = heat;
    this.duration = duration;
  }

  @Override
  public String getDescription(String measureId) {
    return "Cook %s in the %s at %s heat for %s".formatted(ingredient.getName(), equipment.getName(), heat, StringFormats.duration(duration));
  }

  public static StepCookTime of(Equipment equipment, Ingredient ingredient, HeatMeasure heat, Duration duration) {
    return new StepCookTime(equipment, ingredient, heat, duration);
  }
}
