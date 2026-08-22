package me.margueritedefrize.wecook.dto.measure;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.margueritedefrize.wecook.dto.strings.Pluralisable;

import java.math.BigDecimal;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Measure {
  protected final String id;
  protected final Pluralisable name;

  public abstract BigDecimal convert(BigDecimal metric);

  public abstract String format(BigDecimal quantity);
}
