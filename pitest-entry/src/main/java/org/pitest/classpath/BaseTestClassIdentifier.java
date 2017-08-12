package org.pitest.classpath;

import org.pitest.classinfo.ClassInfo;

public abstract class BaseTestClassIdentifier implements TestClassIdentifier {

  @Override
  public boolean isIncluded(ClassInfo a) {
    return true;
  }

}
