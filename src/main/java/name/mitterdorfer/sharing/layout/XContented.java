package name.mitterdorfer.sharing.layout;

import sun.misc.Contended;

public final class XContented {
    //assume f1 is written to...
    @Contended
    public volatile int f1;
    // ... and f2 is only read
    public volatile int f2;
}