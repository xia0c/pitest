package org.pitest.coverage.execute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.pitest.classinfo.ClassByteArraySource;
import org.pitest.classinfo.ClassName;
import org.pitest.coverage.BlockLocation;
import org.pitest.coverage.LineMap;
import org.pitest.coverage.analysis.Block;
import org.pitest.coverage.analysis.ControlFlowAnalyser;
import org.pitest.functional.Option;
import org.pitest.mutationtest.engine.Location;
import org.pitest.mutationtest.engine.MethodName;

public class LineMapper implements LineMap {

  private final ClassByteArraySource source;

  public LineMapper(final ClassByteArraySource source) {
    this.source = source;
  }

  @Override
  public Map<BlockLocation, Set<Integer>> mapLines(final ClassName clazz) {

    final Map<BlockLocation, Set<Integer>> map = new HashMap<BlockLocation, Set<Integer>>();

    final Option<byte[]> maybeBytes = this.source.getBytes(clazz.asJavaName());
    // classes generated at runtime eg by mocking frameworks
    // will be instrumented but not available on the classpath
    for (final byte[] bytes : maybeBytes) {
      final ClassReader cr = new ClassReader(bytes);
      final ClassNode classNode = new ClassNode();

      cr.accept(classNode, ClassReader.EXPAND_FRAMES);
      for (final Object m : classNode.methods) {
        final MethodNode mn = (MethodNode) m;
        final Location l = Location.location(clazz,
            MethodName.fromString(mn.name), mn.desc);
        final List<Block> blocks = ControlFlowAnalyser.analyze(mn);
        for (int i = 0; i != blocks.size(); i++) {
          final BlockLocation bl = new BlockLocation(l, i);
          map.put(bl, blocks.get(i).getLines());
        }

      }
    }

    return map;
  }

}
