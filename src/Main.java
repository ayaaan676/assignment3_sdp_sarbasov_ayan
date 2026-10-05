public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Run with --demo");
        }
    }

    private static void runDemo() {
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();
        Renderer ascii = new AsciiRenderer();

        int passed = 0;

        // T1
        Circle circleVector = new Circle(1, 2, vector);
        String t1Actual = circleVector.execute();
        String t1Expected = "VECTOR circle radius=2";

        if (t1Actual.equals(t1Expected)) {
            System.out.println("T1 PASS | Circle + VectorRenderer | result=" + t1Actual);
            passed++;
        } else {
            System.out.println("T1 FAIL | expected=" + t1Expected + " | actual=" + t1Actual);
        }

        // T2
        Circle circleRaster = new Circle(1, 2, raster);
        String t2Actual = circleRaster.execute();
        String t2Expected = "RASTER circle radius=2";

        if (t2Actual.equals(t2Expected)) {
            System.out.println("T2 PASS | Circle + RasterRenderer | result=" + t2Actual);
            passed++;
        } else {
            System.out.println("T2 FAIL | expected=" + t2Expected + " | actual=" + t2Actual);
        }

        // T3
        Square squareVector = new Square(2, 3, vector);
        String t3Actual = squareVector.execute();
        String t3Expected = "VECTOR square side=3";

        if (t3Actual.equals(t3Expected)) {
            System.out.println("T3 PASS | Square + VectorRenderer | result=" + t3Actual);
            passed++;
        } else {
            System.out.println("T3 FAIL | expected=" + t3Expected + " | actual=" + t3Actual);
        }

        // T4
        Square squareRaster = new Square(2, 3, raster);
        String t4Actual = squareRaster.execute();
        String t4Expected = "RASTER square side=3";

        if (t4Actual.equals(t4Expected)) {
            System.out.println("T4 PASS | Square + RasterRenderer | result=" + t4Actual);
            passed++;
        } else {
            System.out.println("T4 FAIL | expected=" + t4Expected + " | actual=" + t4Actual);
        }

        // T5
        Circle sameCircle = new Circle(3, 2, vector);

        Circle originalReference = sameCircle;
        int originalId = sameCircle.getId();

        String before = sameCircle.execute();

        sameCircle.setImplementation(raster);

        Circle afterReference = sameCircle;
        String after = sameCircle.execute();

        boolean sameObject = originalReference == afterReference;
        boolean stateUnchanged = originalId == sameCircle.getId();

        if (sameObject
                && stateUnchanged
                && before.equals("VECTOR circle radius=2")
                && after.equals("RASTER circle radius=2")) {

            System.out.println("T5 PASS | sameObject=" + sameObject
                    + " | stateUnchanged=" + stateUnchanged);
            System.out.println("    before=" + before + " | after=" + after);
            passed++;

        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject
                    + " | stateUnchanged=" + stateUnchanged);
            System.out.println("    before=" + before + " | after=" + after);
        }

        // T6
        Circle circleAscii = new Circle(4, 2, ascii);
        String t6Actual = circleAscii.execute();
        String t6Expected = "ASCII circle radius=2";

        if (t6Actual.equals(t6Expected)) {
            System.out.println("T6 PASS | Circle + AsciiRenderer | result=" + t6Actual);
            passed++;
        } else {
            System.out.println("T6 FAIL | expected=" + t6Expected + " | actual=" + t6Actual);
        }

        // T7
        Square squareAscii = new Square(5, 3, ascii);
        String t7Actual = squareAscii.execute();
        String t7Expected = "ASCII square side=3";

        if (t7Actual.equals(t7Expected)) {
            System.out.println("T7 PASS | Square + AsciiRenderer | result=" + t7Actual);
            passed++;
        } else {
            System.out.println("T7 FAIL | expected=" + t7Expected + " | actual=" + t7Actual);
        }

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }
}