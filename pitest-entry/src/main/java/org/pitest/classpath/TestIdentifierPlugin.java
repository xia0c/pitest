package org.pitest.classpath;

import java.util.Collection;

import org.pitest.plugin.ToolClasspathPlugin;
import org.pitest.testapi.TestGroupConfig;

public interface TestIdentifierPlugin extends ToolClasspathPlugin {
  String name();
  TestClassIdentifier create(TestGroupConfig config, Collection<String> excludedRunners);

}
