FuelGauge.class
FuelGauge(): first constructor
FuelGauge(int gallons): second constructor, check not too many gallons
getGallons() and setGallons(): typical setter-getter to handle gallons.
burnGallons(): Gallons decrease

Odometer.class
Odometer(int mileage, FuelGauge fuelGauge): constructor. 
getMillage() and setMillage(): typical setter-getter to handle Mileage. And burnGallons() with instance created from FuelGauge.class 


a4main.class
Create 2 instances of Odometer and FuelGauge.
FuelGauge
	addGallons()
	getGallons()
Odometer
	addMileage()
	getMileage()