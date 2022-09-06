package cheat_sheets;

public class StringFormatting {
    public static void main(String[] args) {
        int num = 37;
        String numBin = Integer.toBinaryString(num);
        int numBinInt = Integer.parseInt(numBin);

        System.out.println("numBin = " + numBin);
        System.out.println("numBinInt = " + numBinInt);
        System.out.println();

        formatSort(numBin);
        formatFill(numBinInt);
    }

    private static void formatFill(int num) {
        System.out.println("StringFormatting.formatFill");
        System.out.println(String.format("%016d", num));
    }

    private static void formatSort(String numBin) {
        System.out.println("StringFormatting.formatSort");
        String formatRight = String.format("%16s", numBin);
        String formatLeft = String.format("%-16s", numBin);

        System.out.println(formatRight);
        System.out.println(formatLeft);
        System.out.println();
    }
}
