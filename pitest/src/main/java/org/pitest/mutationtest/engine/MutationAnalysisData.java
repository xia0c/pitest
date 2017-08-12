package org.pitest.mutationtest.engine;

import java.util.ArrayList;
import java.util.List;

import org.pitest.coverage.TestInfo;

public class MutationAnalysisData {
  private final MutationIdentifier  id;
  private final ArrayList<TestInfo> testsInOrder;
  
  public MutationAnalysisData(MutationIdentifier id,
      ArrayList<TestInfo> testsInOrder) {
    this.id = id;
    this.testsInOrder = testsInOrder;
  }

  public MutationIdentifier getId() {
    return id;
  }

  public List<TestInfo> getTestsInOrder() {
    return testsInOrder;
  }
  
  
}
