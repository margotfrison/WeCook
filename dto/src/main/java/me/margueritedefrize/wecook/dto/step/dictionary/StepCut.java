package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.*;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.MeasureType;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepCut extends Step {
  @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
  public enum StepCutType {
    DICE("Dice"),
    SLICE("Slice"),
    JULIENNE("Julienne"),
    BATONNET("Batonnet"),
    MINCE("Mince"),
    BRUNOISE("Brunoise"),
    CHIFFONADE("Chiffonade");

    private final String word;
  }

  StepCutType stepCutType;
  Ingredient ingredient;
  BigDecimal cutDimension;
  Equipment equipment;

  private StepCut(StepCutType stepCutType, Ingredient ingredient, BigDecimal cutDimension, Equipment equipment) {
    super(StepType.MISE_EN_PLACE);
    this.stepCutType = stepCutType;
    this.ingredient = ingredient;
    this.cutDimension = cutDimension;
    this.equipment = equipment;
  }

  @Override
  public String getDescription(String measureId) {
    if (cutDimension != null) {
      if (equipment != null) {
        return "%s (%s) the %s with the %s".formatted(stepCutType.word, MeasureType.LENGTH.getDescription(cutDimension, measureId), ingredient.getName(), equipment.getName());
      } else {
        return "%s (%s) the %s".formatted(stepCutType.word, MeasureType.LENGTH.getDescription(cutDimension, measureId), ingredient.getName());
      }
    } else {
      if (equipment != null) {
        return "%s the %s with the %s".formatted(stepCutType.word, ingredient.getName(), equipment.getName());
      } else {
        return "%s the %s".formatted(stepCutType.word, ingredient.getName());
      }
    }
  }

  public static StepCut of(StepCutType stepCutType, Ingredient ingredient, BigDecimal cutDimension, Equipment equipment) {
    return new StepCut(stepCutType, ingredient, cutDimension, equipment);
  }

  public static StepCut of(StepCutType stepCutType, Ingredient ingredient, BigDecimal cutDimension) {
    return of(stepCutType, ingredient, cutDimension, null);
  }

  public static StepCut of(StepCutType stepCutType, Ingredient ingredient) {
    return of(stepCutType, ingredient, null, null);
  }
}
