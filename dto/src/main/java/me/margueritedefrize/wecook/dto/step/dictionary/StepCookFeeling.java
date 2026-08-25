package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.type.HeatMeasure;
import me.margueritedefrize.wecook.dto.measure.type.LookMeasure;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;

@EqualsAndHashCode(callSuper = true)
@Value
public class StepCookFeeling extends Step {
  Equipment equipment;
  Ingredient ingredient;
  HeatMeasure heat;
  LookMeasure look;

  private StepCookFeeling(Equipment equipment, Ingredient ingredient, HeatMeasure heat, LookMeasure look) {
    super(StepType.MISE_EN_PLACE);
    this.equipment = equipment;
    this.ingredient = ingredient;
    this.heat = heat;
    this.look = look;
  }

  @Override
  public String getDescription(String measureId) {
    return "Cook %s in the %s at %s heat until %s".formatted(ingredient.getName(), equipment.getName(), heat, look);
  }

  public static StepCookFeeling of(Equipment equipment, Ingredient ingredient, HeatMeasure heat, LookMeasure look) {
    return new StepCookFeeling(equipment, ingredient, heat, look);
  }
}
