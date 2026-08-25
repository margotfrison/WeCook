package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.type.HeatMeasure;
import me.margueritedefrize.wecook.dto.measure.type.ReduceMeasure;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;
import me.margueritedefrize.wecook.utils.StringFormats;

import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepReduce extends Step {
  Ingredient ingredient;
  HeatMeasure heatMeasure;
  ReduceMeasure reduceMeasure;

  private StepReduce(Ingredient ingredient, HeatMeasure heatMeasure, ReduceMeasure reduceMeasure) {
    super(StepType.MISE_EN_PLACE);
    this.ingredient = ingredient;
    this.heatMeasure = heatMeasure;
    this.reduceMeasure = reduceMeasure;
  }

  @Override
  public String getDescription(String measureId) {
    if (heatMeasure != null) {
      return "Reduce the %s over %s until %s".formatted(ingredient.getName(), heatMeasure.getName(), reduceMeasure.getName());
    } else {
      return "Reduce the %s until %s".formatted(ingredient.getName(), reduceMeasure.getName());
    }
  }

  public static StepReduce of(Ingredient equipment, HeatMeasure heatMeasure, ReduceMeasure reduceMeasure) {
    return new StepReduce(equipment, heatMeasure, reduceMeasure);
  }

  public static StepReduce of(Ingredient equipment, ReduceMeasure reduceMeasure) {
    return new StepReduce(equipment, null, reduceMeasure);
  }
}
