package Assignment4;

class Odometer {

    int MAXIMUM_MILEAGE = 999999;
    int MPG = 24;
    int initialMileage;
    int mileage;
    FuelGauge fuelGauge;

    public Odometer(int mileage, FuelGauge fuelGauge) {
        this.initialMileage = mileage;
        this.mileage = mileage;
        this.fuelGauge = fuelGauge;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage() {
        if (mileage < MAXIMUM_MILEAGE) {
            mileage++;
        } else {
            mileage = 0;
        }
        int driven = initialMileage - mileage;
        if (driven % MPG == 0) {
            fuelGauge.burnGallons();
        }
    }
}