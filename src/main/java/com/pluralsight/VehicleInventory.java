package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    private static Vehicle[] vehicles = new Vehicle[20];
    private static int vehicleCount = 0;
    public static void main(String[] args) {
        vehicles[vehicleCount++] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500f);
        vehicles[vehicleCount++] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000f);
        vehicles[vehicleCount++] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700f);
        vehicles[vehicleCount++] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500f);
        vehicles[vehicleCount++] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500f);
        vehicles[vehicleCount++] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16500f);

        Scanner myScanner = new Scanner(System.in);

        menuList(myScanner);
        myScanner.close();

    }
    public static void menuList(Scanner scanner){
        boolean isDone = false;
        while(!isDone){
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println("Enter your command: ");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch(command){
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByMakeModel(scanner);
                    break;
                case 3:
                    findVehiclesByPriceRange(scanner);
                    break;
                case 4:
                    findVehiclesByColor(scanner);
                    break;
                case 5:
                    addAVehicle(scanner);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command");
                    isDone = true;
                    break;
            }
        }
    }
    public static void listAllVehicles(){
        for(int i = 0; i < vehicleCount; i++){
            System.out.println(vehicles[i].toString());
        }
    }
    public static void findVehiclesByMakeModel(Scanner scanner){
        System.out.println("Enter make/model: ");
        String makeModel = scanner.nextLine();
        for(int i = 0; i < vehicleCount; i++){
            if(vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)){
                System.out.println(vehicles[i].toString());
            }
        }
    }
    public static void findVehiclesByPriceRange(Scanner scanner){
        System.out.println("Enter lower price: ");
        double lowestPrice = scanner.nextInt();
        System.out.println("Enter highest price: ");
        double highestPrice = scanner.nextInt();
        for(int i = 0; i < vehicleCount; i++){
            if((float) lowestPrice <= vehicles[i].getPrice() && vehicles[i].getPrice() <= (float) highestPrice){
                System.out.println(vehicles[i].toString());
            }
        }
    }
    public static void findVehiclesByColor(Scanner scanner){
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        for(int i = 0; i < vehicleCount; i++){
            if(vehicles[i].getColor().equalsIgnoreCase(color)){
                System.out.println(vehicles[i].toString());
                break;
            }
        }
    }
    public static void addAVehicle(Scanner scanner){
        Vehicle vehicle = new Vehicle();
        System.out.println("Type the Vehicle ID: ");
        vehicle.setVehicleId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Model: ");
        vehicle.setMakeModel(scanner.nextLine());
        System.out.println("Color: ");
        vehicle.setColor(scanner.nextLine());
        System.out.println("Miles: ");
        vehicle.setOdometerReading(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Price: ");
        vehicle.setPrice((float) scanner.nextDouble());
        if(vehicleCount < 20) vehicles[vehicleCount++] = vehicle;

    }
}
