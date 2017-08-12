package org.pitest.testng;

import java.util.Collection;

import org.pitest.classpath.TestClassIdentifier;
import org.pitest.classpath.TestIdentifierPlugin;
import org.pitest.testapi.TestGroupConfig;

public class TestNGIdentifierPlugin implements TestIdentifierPlugin {

  @Override
  public String description() {
    return "TestNG test identifier";
  }

  @Override
  public String name() {
    return "testng";
  }

  @Override
  public TestClassIdentifier create(TestGroupConfig config,
      Collection<String> excludedRunners) {
    return new TestNGTestClassIdentifier();
  }

}
