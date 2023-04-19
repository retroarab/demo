package benchmark.cpu.fixedpoint;

public class GlobalVariables extends DhrystoneConstants {
    static RecordType          recordGlob,
                               nextRecordGlob;
    static int                 intGlob;
    static boolean             boolGlob;
    static char                charGlob1,
                               charGlob2;
    static int[]               arrayGlob1    = new int[128];
    static int[][]             arrayGlob2    = new int[128][128];
    static RecordType          firstRecord    = new RecordType(),
                               secondRecord   = new RecordType();
}
