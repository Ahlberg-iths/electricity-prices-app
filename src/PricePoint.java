public record PricePoint(String timeInterval, int price) implements Comparable<PricePoint> {

    public static String formatTimeInterval(int lowerBound, int length) {
//        return String.format("%02d:00-%02d:00", lowerBound, (lowerBound < 23) ? (lowerBound + 1) : 0);
        return String.format("%02d:00-%02d:00", lowerBound, ((lowerBound+length) % 24) );
    }

    public static double calcAverage(PricePoint[] array) {
        double sum = 0;
        for (PricePoint pricePoint : array) {
            sum += pricePoint.price();
        }
        return sum / array.length;
    }

    public static PricePoint[] findMinMax(PricePoint[] array) {

        PricePoint min = array[0];
        PricePoint max = array[0];

        for (PricePoint pricePoint : array) {

            int i = pricePoint.price();

            if ( i < min.price() )
                min = pricePoint;
            if ( i > max.price() )
                max = pricePoint;
        }
        return new PricePoint[] {min, max};
    }

    @Override
    public int compareTo(PricePoint o) { return Integer.compare(this.price(), o.price()); }
}
