class ResistorColorTrio {
    String label(String[] colors) {
        var numericValue = (value(colors[0]) * 10 + value(colors[1])) * Math.pow(10, value(colors[2]));
        String descriptor;

        if (numericValue > 1000000000) {
            numericValue /= 1000000000;
            descriptor = "gigaohms";
        } else if (numericValue > 1000000){
            numericValue /= 1000000;
            descriptor = "megaohms";
        } else if (numericValue > 1000) {
            numericValue /= 1000;
            descriptor = "kiloohms";
        } else descriptor = "ohms";

        return "%.0f %s".formatted(numericValue, descriptor);
    }

    private int value(String color) {
        return switch(color.toLowerCase()) {
            case "black" -> 0;
            case "brown" -> 1;
            case "red" -> 2;
            case "orange" -> 3;
            case "yellow" -> 4;
            case "green" -> 5;
            case "blue" -> 6;
            case "violet" -> 7;
            case "grey" -> 8;
            case "white" -> 9;
            default -> throw new IllegalArgumentException("Invalid color: " + color);
        };
    }
}
