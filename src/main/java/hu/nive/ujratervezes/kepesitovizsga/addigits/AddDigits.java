package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {
    public int addDigits(String input) {
        if (input == null || input.equals("")) {
            return -1;
        }
        int counter = 0;

        for (Character item : input.toCharArray()
        ) {
            if (Character.isDigit(item)) {
                counter += Character.getNumericValue(item);
            }
        }
        return counter;
    }
}
