package name.mitterdorfer.sharing.layout;

import org.openjdk.jol.info.ClassLayout;

/**
 * Simple demo to show the memory layout of a class with and without the @Contented annotation.
 *
 * Remember to provide the JVM argument "-XX:-RestrictContended" to have the JVM consider @Contended.
 */
public class ObjectLayoutMain {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(X.class).toPrintable());
        System.out.println(ClassLayout.parseClass(XPadding.class).toPrintable());
        System.out.println(ClassLayout.parseClass(XContented.class).toPrintable());
    }
}
