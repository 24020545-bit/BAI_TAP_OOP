package Bai8;

import java.util.Scanner;

class Robot{
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName){
        this.id = id;
        this.modelName = modelName;
    }
    public void chargeBattery(){
        batteryLevel = 100;
    }
    public void showIdentity(){
        System.out.println("ID: "+id+", Model: "+modelName);
    }
    public void performMainTask(){}
}
class DroneRobot extends Robot implements Flyable, GPS{
    public DroneRobot(int id, String modelName){
        super(id,modelName);
    }
    @Override
    public void fly(){
        System.out.println("Fly Fly");
    }
    @Override
    public void getCoordinates(){
        System.out.println("Drone co GPS");
    }
}
class FishRobot extends Robot implements Swimmable{
    public FishRobot(int id, String modelName){
        super(id,modelName);
    }
    @Override
    public void swim(){
        System.out.println("Fish Robot co the boi");
    }
}
class AmphibiousRobot extends Robot implements Flyable, GPS, Swimmable{
    public AmphibiousRobot(int id, String modelName){
        super(id,modelName);
    }
    @Override
    public void fly(){
        System.out.println("Robot co the Fly");
    }
    @Override
    public void swim(){
        System.out.println("Robot co the Swim");
    }
    @Override
    public void getCoordinates(){
        System.out.println("Robot co GPS");
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            String type = scan.next();
            int id = scan.nextInt();
            String modelName = scan.next();

            if (type.equals("DR")) {
                robots[i] = new DroneRobot(id, modelName);
            }
            else if (type.equals("FR")) {
                robots[i] = new FishRobot(id, modelName);
            }
            else if (type.equals("AR")) {
                robots[i] = new AmphibiousRobot(id, modelName);
            }
        }

        for (Robot robot : robots) {

            robot.performMainTask();

            if (robot instanceof Flyable) {
                Flyable flyRobot = (Flyable) robot;
                flyRobot.fly();
            }

            if (robot instanceof Swimmable) {
                Swimmable swimRobot = (Swimmable) robot;
                swimRobot.swim();
            }

            if (robot instanceof GPS) {
                GPS gpsRobot = (GPS) robot;
                gpsRobot.getCoordinates();
            }

            System.out.println();
        }
    }
}
