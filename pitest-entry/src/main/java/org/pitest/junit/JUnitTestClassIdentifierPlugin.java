package org.pitest.junit;

import java.util.Collection;

import org.pitest.classpath.TestClassIdentifier;
import org.pitest.classpath.TestIdentifierPlugin;
import org.pitest.testapi.TestGroupConfig;

public class JUnitTestClassIdentifierPlugin implements TestIdentifierPlugin {

  @Override
  public String description() {
    return "JUnit test class identifier";
  }

  @Override
  public String name() {
    return "junit";
  }
  
  @Override
  public TestClassIdentifier create(TestGroupConfig config,
      Collection<String> excludedRunners) {
    return new JUnitTestClassIdentifier(config, excludedRunners);
  }

}
