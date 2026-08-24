package me.margueritedefrize.wecook.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class Pluralisable {
  String single;
  String plural;

  public static Pluralisable of(String single, String plural) {
    return new Pluralisable(single, plural);
  }

  public static Pluralisable of(String single) {
    return of(single, single);
  }

  public static Pluralisable s(String single) {
    return of(single, single + "s");
  }

  public static Pluralisable es(String single) {
    return of(single, single + "es");
  }
}
