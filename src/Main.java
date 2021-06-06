public class Main {
    public static void main(String[] args) {
        Technics[] technics = new Technics[3];
        technics[0] = new Plane(true, 2778, 2000, "Су-35");
        technics[1] = new Tank(true,54, "Т-34", false, 76);
        technics[2] = new BTR(false, 100,"БТР-82", 7);
        for (Technics one: technics) {
            one.printCharacteristics();
        }
    }
}

class Technics {
    boolean canShoot;
    int speed;
    String model;

    public Technics(boolean canShoot, int speed, String model) {
        this.canShoot = canShoot;
        this.speed = speed;
        this.model = model;
    }

    void printCharacteristics() {
        System.out.print(model);
        if (canShoot) {
            System.out.print(". Данная модель может стрелять.");
        }
        System.out.print(" Максимальная скорость: " + speed);
    }
}

class Plane extends Technics {
    int flightAltitude;


    public Plane(boolean canShoot, int speed, int flightAltitude, String model) {
        super(canShoot, speed, "Самолет " + model);
        this.flightAltitude = flightAltitude;
    }

    @Override
    void printCharacteristics() {
        super.printCharacteristics();
        System.out.printf(". Максимальная высота полета: %d. \n", flightAltitude);
    }
}

class Tank extends Technics {
    boolean canSwim;
    int caliber;

    public Tank(boolean canShoot, int speed, String model, boolean canSwim, int caliber) {
        super(canShoot, speed, model);
        this.canSwim = canSwim;
        this.caliber = caliber;
    }

    @Override
    void printCharacteristics() {
        super.printCharacteristics();
        if (canSwim) {
            System.out.print(". Также может плавать");
        }
        System.out.printf(". Вооружен следующим калибром: %d-мм. \n", caliber);
    }
}

class BTR extends Technics {
    int maximumPassengers;

    public BTR(boolean canShoot, int speed, String model, int maximumPassengers) {
        super(canShoot, speed, model);
        this.maximumPassengers = maximumPassengers;
    }

    @Override
    void printCharacteristics() {
        super.printCharacteristics();
        System.out.printf(". Может перевозить до %d человек. \n", maximumPassengers);
    }
}