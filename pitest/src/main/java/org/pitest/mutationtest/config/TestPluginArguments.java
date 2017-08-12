package org.pitest.mutationtest.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.pitest.junit.JUnitTestPlugin;
import org.pitest.testapi.TestGroupConfig;

public class TestPluginArguments implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private final String testPlugin;
  private TestGroupConfig groupConfig;
  private Collection<String> excludedRunners;
   
  public TestPluginArguments(String testPlugin,
      TestGroupConfig groupConfig,
      Collection<String> excludedRunners) {
    this.testPlugin = testPlugin;
    this.groupConfig = groupConfig;
    this.excludedRunners = excludedRunners;
  }

  public static TestPluginArguments defaults() {
    return new TestPluginArguments(JUnitTestPlugin.NAME, new TestGroupConfig(), Collections.<String>emptyList());
  }
  
  public TestPluginArguments withTestPlugin(String plugin) {
    return new TestPluginArguments(plugin, groupConfig, excludedRunners);
  }
  
  public TestGroupConfig getGroupConfig() {
    return groupConfig;
  }

  public Collection<String> getExcludedRunners() {
    return excludedRunners;
  }

  public String getTestPlugin() {
    return testPlugin;
  }
  
  
  
}
