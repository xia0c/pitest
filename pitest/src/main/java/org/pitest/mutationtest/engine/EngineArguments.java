package org.pitest.mutationtest.engine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class EngineArguments implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private final String name;
  private final Collection<String> mutators;
  private final Collection<String> excludedMethods;
  
  public EngineArguments(String name, Collection<String> mutators, Collection<String> excludedMethods) {
    this.name = name;
    this.mutators = mutators;
    this.excludedMethods = excludedMethods;
  }
  
  public static EngineArguments forEngine(String name) {
    return new EngineArguments(name, Collections.<String>emptyList(), Collections.<String>emptyList());
  }

  public EngineArguments withMutators(Collection<String> mutators) {
    return new EngineArguments(name, mutators, excludedMethods);
  }
  
  public EngineArguments withExcludedMethods(Collection<String> excludedMethods) {
    return new EngineArguments(name, mutators, excludedMethods);
  }  
  
  public String name() {
    return name;
  }

  public Collection<String> mutators() {
    return mutators;
  }

  public Collection<String> excludedMethods() {
    return excludedMethods;
  }
  
  
  
}
