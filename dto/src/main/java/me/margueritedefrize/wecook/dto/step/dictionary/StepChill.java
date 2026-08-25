package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.MeasureType;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;
import me.margueritedefrize.wecook.utils.StringFormats;

import java.math.BigDecimal;
import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepChill extends Step {
  Ingredient ingredient;
  Equipment equipment;
  Duration duration;

  private StepChill(Ingredient ingredient, Equipment equipment, Duration duration) {
    super(StepType.MISE_EN_PLACE);
    this.ingredient = ingredient;
    this.equipment = equipment;
    this.duration = duration;
  }

  @Override
  public String getDescription(String measureId) {
    return "Chill the %s in the %s for %s".formatted(ingredient.getName(), equipment.getName(), StringFormats.duration(duration));
  }

  public static StepChill of(Ingredient ingredient, Equipment equipment, Duration duration) {
    return new StepChill(ingredient, equipment, duration);
  }
}
