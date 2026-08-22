package me.margueritedefrize.wecook.dto.step;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Step {
  private final StepType type;

  public abstract String getDescription(String measureId);
}
