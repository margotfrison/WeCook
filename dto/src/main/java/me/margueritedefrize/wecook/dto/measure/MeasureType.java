package me.margueritedefrize.wecook.dto.measure;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import me.margueritedefrize.wecook.dto.measure.type.*;
import me.margueritedefrize.wecook.utils.Pluralisable;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class MeasureType<T extends Measure> {
  public static final MeasureType<UnitMeasure> UNIT = new MeasureType<>(
      UnitMeasure.of(Pluralisable.s("Unit"), "u", BigDecimal.ONE),
      List.of()
  );
  public static final MeasureType<VolumeMeasure> VOLUME = new MeasureType<>(
      VolumeMeasure.of(Pluralisable.s("Milliliter"), "ml", BigDecimal.ONE),
      List.of(
          VolumeMeasure.of(Pluralisable.s("Centiliter"), "cl", new BigDecimal("10")),
          VolumeMeasure.of(Pluralisable.s("Liter"), "l", new BigDecimal("1000"))
      )
  );
  public static final MeasureType<WeightMeasure> WEIGHT = new MeasureType<>(
      WeightMeasure.of(Pluralisable.s("Gram"), "g", BigDecimal.ONE),
      List.of(
          WeightMeasure.of(Pluralisable.s("Kilogram"), "kg", new BigDecimal("1000"))
      )
  );
  public static final MeasureType<LengthMeasure> LENGTH = new MeasureType<>(
      LengthMeasure.of(Pluralisable.s("Millimeter"), "mm", BigDecimal.ONE),
      List.of(
          LengthMeasure.of(Pluralisable.s("Centimeter"), "cm", new BigDecimal("10")),
          LengthMeasure.of(Pluralisable.s("Meter"), "mm", new BigDecimal("1000"))
      )
  );
  public static final MeasureType<TemperatureMeasure> TEMPERATURE = new MeasureType<>(
      TemperatureMeasure.of("Celsius", "°C", BigDecimal.ONE),
      List.of()
  );
  public static final MeasureType<HeatMeasure> HEAT = new MeasureType<>(
      HeatMeasure.of("Minimum"),
      List.of(
          HeatMeasure.of("Low"),
          HeatMeasure.of("Medium low"),
          HeatMeasure.of("Medium"),
          HeatMeasure.of("Medium high"),
          HeatMeasure.of("High"),
          HeatMeasure.of("Maximum")
      )
  );
  public static final MeasureType<LookMeasure> LOOK = new MeasureType<>(
      LookMeasure.of("Golden"),
      List.of(
          LookMeasure.of("Charred"),
          LookMeasure.of("Thawed"),
          LookMeasure.of("Smoked"),
          LookMeasure.of("Pale gray"),
          LookMeasure.of("Crusty")
      )
  );
  public static final MeasureType<ReduceMeasure> REDUCE = new MeasureType<>(
      ReduceMeasure.of("Reduced"),
      List.of(
          ReduceMeasure.of("Half reduced"),
          ReduceMeasure.of("Demi glace"),
          ReduceMeasure.of("Glace"),
          ReduceMeasure.of("Syrup"),
          ReduceMeasure.of("Napé")
      )
  );

  T metric;
  List<T> conversions;

  public String getDescription(BigDecimal quantity, String measureId) {
    if (!metric.getId().equals(measureId)) {
      for (T conversion : conversions) {
        if (conversion.getId().equals(measureId)) {
          return conversion.format(quantity);
        }
      }
      // Fallback is metric if we didn't find the measure with the measureId
    }
    return metric.format(quantity);
  }
}
