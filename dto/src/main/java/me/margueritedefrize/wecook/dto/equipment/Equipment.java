package me.margueritedefrize.wecook.dto.equipment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Equipment {
  private EquipmentType equipmentType;
  private String name;
  private String description;

  public static Equipment of(EquipmentType equipmentType, String name, String description) {
    return new Equipment(equipmentType, name, description);
  }
}
