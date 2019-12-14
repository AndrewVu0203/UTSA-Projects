package Assignment4;

class FuelGauge {

    int MAXIMUM_GALLONS = 10;
    private int gallons;

    public FuelGauge() {
        gallons = 0;
    }

    public FuelGauge(int gallons) {
        if (gallons <= MAXIMUM_GALLONS) {
            this.gallons = gallons;
        } else {
            gallons = MAXIMUM_GALLONS;
        }
    }

    public int getGallons() {
        return gallons;
    }

    public void setGallons() {
        if (gallons < MAXIMUM_GALLONS) {
            gallons++;
        } else {
            System.out.println("Fuel overflowing!");
        }
    }

    public void burnGallons() {
        if (gallons > 0) {
            gallons--;
        } else {
            System.out.println("Out of fuel.");
        }
    }
}