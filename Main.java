import java.io.*;
import java.util.*;
import java.text.*;

class Person{
    Person(String name,Vehicle v,Boolean x){
        this.name = name;
        this.v = v;
        this.Handicapped = x;
    }
    private String name;
    private Vehicle v;
    public Boolean Handicapped;

}
class Money{
    private int money;
    private String mode_of_payement;
    Money(int money,String mode_of_payement){
        this.money = money;
        this.mode_of_payement = mode_of_payement;
    }
    int get_money(){
      return this.money;  
    }

}
class Ticket{
    private Person p;
    private Vehicle v;
    private int arrival_time_h;
    private int arrival_time_m;
    Ticket(Person p,Vehicle v,int arrival_time_h,int arrival_time_m){
        this.p = p;
        this.v=v;
        this.arrival_time_h = arrival_time_h;
        this.arrival_time_m = arrival_time_m;
    }
    int  money_to_be_paid(int departure_time_h,int departure_time_m){
        int h = departure_time_h-arrival_time_h;
        if(v.Vehicle_fuel.equals("EV")){
        if((0<h && h<1)){
            return 30;
        }
        else if(1<h && h<3)return 20;
        else return 10;
    }
    else{
        if ((0 < h && h < 1)) {
            return 20;
        } else if (1 < h && h < 3)
            return 10;
        else
            return 5;
    }
    }
    void Transcation(int x){
        System.out.println("Pay the amount: "+x);
    }

}
class Parking_lot {
    private String name;
    private String area;
    private String city;

    void set_name_of_lot(String name) {
        this.name = name;
    }

    void set_name_of_area(String area) {
        this.area = area;
    }

    void set_name_of_city(String city) {
        this.city = city;
    }

    void details_of_lot() {
        System.out.println("Name of Parking Lot: " + this.name);
        System.out.println("area: " + this.area);
        System.out.println("city: " + this.city);
    }
}

class Parking_floor {
    private int floor_no;
    private int capacity_of_vehicles;
    private int vehicle_count = 0;

    void set_floor_no(int floor_no){
        this.floor_no = floor_no;
    }

    void set_capacity(int cap) {
        this.capacity_of_vehicles = cap;
    }

    void enter_the_floor() {
        System.out.println("Enter the vehicle to the floor " + this.floor_no);
        vehicle_count++;
    }

    void exit_the_floor() {
        System.out.println("exit the vehicle from the floor " + this.floor_no);
        vehicle_count--;
    }
    void emergency_exit(){
        System.out.println("Moving to the ground floor");
    }
    boolean capacity_is_full() {
        if (vehicle_count == capacity_of_vehicles)
            return true;
        return false;
    }

    void Display_board() {
        System.out.println("Floor No: " + this.floor_no);
        System.out.println("Empty Spots: " + (this.capacity_of_vehicles - this.vehicle_count));
    }
}

abstract class Parking_Spot {
    private String type_of_parking_spot;
    protected int Spot_number;
    public boolean Is_spot_free;

    abstract void assign_spot_to_vehicle(Vehicle v,Person p);
    abstract void remove_vehicle_from_spot();
    abstract void set_EV(Vehicle v);
}
class Compact_Spot extends Parking_Spot{
    void assign_spot_to_vehicle(Vehicle v,Person p){
        if(v.Vehicle_type.equals("van") || v.Vehicle_type.equals("car") ){
            Is_spot_free = false;
        }
    }
    void set_EV(Vehicle v){
        if(v.Vehicle_fuel.equals("EV")){
            System.out.println("Set a Electric Charger At the Spot");
        }
    }
    void remove_vehicle_from_spot(){
        Is_spot_free = false;
    }
}
class Large_Spot extends Parking_Spot {
    void assign_spot_to_vehicle(Vehicle v,Person p) {
        if (v.Vehicle_type.equals("Truck")) {
            Is_spot_free = false;
        }
    }
    
    void set_EV(Vehicle v) {
        if (v.Vehicle_fuel.equals("EV")) {
            System.out.println("Set a Electric Charger At the Spot");
        }
    }
    void remove_vehicle_from_spot() {
        Is_spot_free = false;
    }
}
class Handicapped_Spot extends Parking_Spot {
    void assign_spot_to_vehicle(Vehicle v,Person p) {
        if (p.Handicapped) {
            Is_spot_free = false;
        }
    }
    
    void set_EV(Vehicle v) {
        if (v.Vehicle_fuel.equals("EV")) {
            System.out.println("Set a Electric Charger At the Spot");
        }
    }
    void remove_vehicle_from_spot() {
        Is_spot_free = false;
    }
}
class Bike_Spot extends Parking_Spot {
    void assign_spot_to_vehicle(Vehicle v,Person p) {
        if (v.Vehicle_type.equals("Bike")) {
            Is_spot_free = false;
        }
    }
    
    void set_EV(Vehicle v) {
        if (v.Vehicle_fuel.equals("EV")) {
            System.out.println("Set a Electric Charger At the Spot");
        }
    }
    void remove_vehicle_from_spot() {
        Is_spot_free = false;
    }
}

class Vehicle {
    public String Vehicle_type;
    public String Vehicle_fuel; //EV or Normal vehicle
    public String Vehicle_no;

    Vehicle(String p) {
        this.Vehicle_type = p;
    }

    public void set_vehicle_no(String Vehicle_no) {
        this.Vehicle_no = Vehicle_no;
    }

    public void get_vehicle_type() {
        System.out.println(Vehicle_type);
    }

}

class Car extends Vehicle {
    Car(String p) {
        super(p);
    }
}
class Truck extends Vehicle {
    Truck(String p) {
        super(p);
    }
}
class Van extends Vehicle {
    Van(String p) {
        super(p);
    }
}
class Bike extends Vehicle {
    Bike(String p) {
        super(p);
    }
}
public class Main{
    public static void main(String[] args){
      
    }
}
    