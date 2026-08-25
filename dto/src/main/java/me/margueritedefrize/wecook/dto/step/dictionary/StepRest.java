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
public class StepRest extends Step {
  Ingredient ingredient;
  Duration duration;

  private StepRest(Ingredient ingredient, Duration duration) {
    super(StepType.MISE_EN_PLACE);
    this.ingredient = ingredient;
    this.duration = duration;
  }

  @Override
  public String getDescription(String measureId) {
    return "Let the %s rest for %s".formatted(ingredient.getName(), StringFormats.duration(duration));
  }

  public static StepRest of(Ingredient equipment, Duration duration) {
    return new StepRest(equipment, duration);
  }
}
