package me.margueritedefrize.wecook.dto.step.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.measure.types.HeatMeasure;
import me.margueritedefrize.wecook.dto.measure.types.LookMeasure;
import me.margueritedefrize.wecook.dto.step.Step;
import me.margueritedefrize.wecook.dto.step.StepType;

@EqualsAndHashCode(callSuper = true)
@Data
public class StepCookFeeling extends Step {
  private Equipment equipment;
  private Ingredient ingredient;
  private HeatMeasure heat;
  private LookMeasure look;

  private StepCookFeeling(Equipment equipment, HeatMeasure heat, LookMeasure look) {
    super(StepType.MISE_EN_PLACE);
    this.equipment = equipment;
    this.heat = heat;
    this.look = look;
  }

  @Override
  public String getDescription(String measureId) {
    return "Cook %s in the %s at %s heat until %s".formatted(ingredient.getName(), equipment.getName(), heat, look);
  }
}
