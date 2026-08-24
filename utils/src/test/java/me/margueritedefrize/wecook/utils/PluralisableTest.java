package me.margueritedefrize.wecook.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PluralisableTest {
  @Test
  void of() {
    // Given && When
    Pluralisable pluralisable1 = Pluralisable.of("city", "cities");
    Pluralisable pluralisable2 = Pluralisable.of("sheep");
    // Then
    assertNotNull(pluralisable1);
    assertEquals("city", pluralisable1.getSingle());
    assertEquals("cities", pluralisable1.getPlural());
    assertNotNull(pluralisable2);
    assertEquals("sheep", pluralisable2.getSingle());
    assertEquals("sheep", pluralisable2.getPlural());
  }

  @Test
  void s() {
    // Given && When
    Pluralisable pluralisable = Pluralisable.s("spoon");
    // Then
    assertNotNull(pluralisable);
    assertEquals("spoon", pluralisable.getSingle());
    assertEquals("spoons", pluralisable.getPlural());
  }

  @Test
  void es() {
    // Given && When
    Pluralisable pluralisable = Pluralisable.es("bush");
    // Then
    assertNotNull(pluralisable);
    assertEquals("bush", pluralisable.getSingle());
    assertEquals("bushes", pluralisable.getPlural());
  }
}
