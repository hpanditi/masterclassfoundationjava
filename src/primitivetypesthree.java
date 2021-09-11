public class primitivetypesthree {

    public static void main(String[] args) {

        System.out.println("Hello there");

        int myValue = 10000;

        int myMinIntValue = Integer.MIN_VALUE;

        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("The value of myValue is " + myValue);

        System.out.println("The value of myMinIntValue is " + myMinIntValue);

        System.out.println("The value of myMaxIntValue is " + myMaxIntValue);

        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));

        System.out.println("Busted MIN value = " + (myMinIntValue - 1));

        int myMaxIntTest = 2_147_483_647;

        byte myMinByteValue = Byte.MIN_VALUE;

        byte myMaxByteValue = Byte.MAX_VALUE;

        System.out.println("Byte Minimum Value = " + myMinByteValue);

        System.out.println("Byte Maximum Value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;

        short myMaxShortValue = Short.MAX_VALUE;

        System.out.println("Short Minimum Value = " + myMinShortValue);

        System.out.println("Short Maximum Value = " + myMaxShortValue);

        long myLongValue = 100L;

        long myMinLongValue = Long.MIN_VALUE;

        long myMaxLongValue = Long.MAX_VALUE;

        System.out.println("Long Minimum Value = " + myMinLongValue);

        System.out.println("Long Maximum Value = " + myMaxLongValue);

        long bigLongLiteralValue = 2_147_483_647_234L;

        System.out.println("The value of the bigLongLiteralValue is " + bigLongLiteralValue);

        short bigShortLiteralValue = 32767;

        int myTotal = (myMinIntValue / 2);

        byte myNewByteValue = (byte)(myMinByteValue / 2);

        short myNewShortValue = (short)(myMinShortValue / 2);

        // Challenge

        byte myFirstByteValue = 10;

        short myFirstShortValue = 20;

        int myFirstIntValue = 50;

        long myFirstLongValue = 50000L + (10L * (myFirstByteValue + myFirstShortValue + myFirstIntValue));

        System.out.println("The value of myFirstLongValue = " + myFirstLongValue);

        short shortTotal = (short) (1000 + 10 * (myFirstByteValue + myFirstShortValue + myFirstIntValue));

    }
}
