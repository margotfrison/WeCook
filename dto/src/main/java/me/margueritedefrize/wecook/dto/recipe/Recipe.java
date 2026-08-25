package me.margueritedefrize.wecook.dto.recipe;

import lombok.Data;
import me.margueritedefrize.wecook.dto.equipment.Equipment;
import me.margueritedefrize.wecook.dto.ingredient.Ingredient;
import me.margueritedefrize.wecook.dto.step.Step;

import java.util.List;

@Data
public class Recipe {
  private String name;
  private String shortName;
  private String description;
  private List<Ingredient> ingredients;
  private List<Equipment> equipment;
  private List<Step> steps;
}
