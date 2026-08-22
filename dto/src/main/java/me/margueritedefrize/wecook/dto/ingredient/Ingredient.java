package me.margueritedefrize.wecook.dto.ingredient;

import lombok.Data;
import me.margueritedefrize.wecook.dto.measure.MeasureType;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

@Data
public class Ingredient {
  private String name;
  private String description;
  private MeasureType measureType;
  private BigDecimal quantity;
  private List<Month> seasons;
}
