import java.io.*;
import java.util.*;
import java.text.*;

//class for person as that many people can park in lot
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
//parking attendant takes care of allocating spot for vehicles
class Parking_Attendant{
    private String name;

    Parking_Attendant(String name){
        this.name = name;
    }
    void Welcome(){
        System.out.println("Welcome to the lot");
    }
    void find_the_spot(Parking_floor f1,Vehicle v){
        if(v.Vehicle_type.equals("car")){
            if(!f1.bike_capacity_is_full()){
                System.out.println("You can park in the floor no: "+f1.get_floor_no());
            }
        }
        else if(v.Vehicle_type.equals("bike")){
            if(!f1.bike_capacity_is_full()){
                System.out.println("You can park in the floor no: " + f1.get_floor_no());
            }
        }
        else{
            System.out.println("No spots");
        }
    }
    void dept_msg(){
        System.out.println("Have a safe ride");
    }
}
//money for maintaining the different modes of payment
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
    void pay_money(int money){
        System.out.println("Payed Rs: "+money);
    }

}
//Ticket to be given to the Person when he enters the parking lot
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
//Parking lot
class Parking_lot {
    private String name;
    private String area;
    private String city;
    Parking_lot(String name, String area, String city){
        this.name = name;
        this.area = area;
        this.city = city;
    }

    void Welcome_To_Lot() {
        System.out.println("Welcome to the Amazing Parking lot");
        System.out.println("Name of Parking Lot: " + this.name);
        System.out.println("area: " + this.area);
        System.out.println("city: " + this.city);
    }
}
//Parking floor which takes care of diff types of spots,no of empty spots of diff types of spot,entering the floor,exiting the floor etc.
class Parking_floor {
    private int floor_no;
    private int capacity_of_vehicles;
    private int vehicle_count = 0;
    private int Compact_Spot = 0;
    private int Large_Spot = 0;
    private int Handicapped_Spot = 0;
    private int Bike_Spot = 0;



    void set_floor_no(int floor_no){
        this.floor_no = floor_no;
    }
    
    int get_floor_no() {
        return floor_no;
    }

    void set_capacity(int cap) {
        this.capacity_of_vehicles = cap;
    }

    void enter_the_floor(Vehicle v,Person p) {
        System.out.println("Enter the vehicle to the floor " + this.floor_no);
        vehicle_count++;
        if(v.Vehicle_type.equals("van") || v.Vehicle_type.equals("car"))Compact_Spot++;
        else if(v.Vehicle_type.equals("Truck"))Large_Spot++;
        else if(p.Handicapped==true)Handicapped_Spot++;
        else Bike_Spot++;
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
    boolean compact_capacity_is_full() {
        if (Compact_Spot == capacity_of_vehicles/4)
            return true;
        return false;
    }
    
    boolean large_capacity_is_full() {
        if (Large_Spot == capacity_of_vehicles / 4)
            return true;
        return false;
    }
    
    boolean handicapped_capacity_is_full() {
        if (Handicapped_Spot == capacity_of_vehicles / 4)
            return true;
        return false;
    }
    
    boolean bike_capacity_is_full() {
        if (Bike_Spot== capacity_of_vehicles / 4)
            return true;
        return false;
    }

    void Display_board() {
        System.out.println("Floor No: " + this.floor_no);
        System.out.println("Empty Spots: " + (this.capacity_of_vehicles - this.vehicle_count));
        System.out.println("Compact Spots: "+(capacity_of_vehicles/4 - Compact_Spot));
        System.out.println("Large Spots: " + (capacity_of_vehicles / 4 - Large_Spot));
        System.out.println("Handicapped Spots: " + (capacity_of_vehicles / 4 - Handicapped_Spot));
        System.out.println("Bike Spots: " + (capacity_of_vehicles / 4 - Bike_Spot));
    }
}
//abstract class for parking spot as their are many types of parking spots,it take care of vehicle type,Person has any disability,parking the vehicle,removing the vehicle etc.
abstract class Parking_Spot {
    private String type_of_parking_spot;
    protected int Spot_number;
    public boolean Is_spot_free;

    abstract void assign_spot_to_vehicle(Vehicle v,Person p);
    abstract void remove_vehicle_from_spot();
    abstract void set_EV(Vehicle v);

}
//compact spots created for purpose of van and car
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
//Large spots created for purpose of Truck
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
//Seperate Parking Spot for Handicapped person
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
//Bike Spot for Bikes
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
//Vehicle class take care vehicle type,Vehicle_fuel,Vehicle-no
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
    void set_vehicle_fuel(String Vehicle_fuel){
        this.Vehicle_fuel = Vehicle_fuel;
    }
    public void get_vehicle_type() {
        System.out.println(Vehicle_type);
    }

}
//Diff types of Vehicle like car,Truck,Van,Bike are allowed in Parking lot.
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
//Main function where we can test the basic mode of parking spot
public class Main{
    public static void main(String[] args){
      Parking_lot p1 = new Parking_lot("Xeno_lot","RajNagar","Hubli");
      p1.Welcome_To_Lot();
      Parking_floor f1 = new Parking_floor();
      f1.set_capacity(4);
      f1.set_floor_no(1);
      Parking_floor f2 = new Parking_floor();
      f2.set_capacity(4);
      f2.set_floor_no(2);
      Parking_floor f3 = new Parking_floor();
      f3.set_capacity(4);
      f3.set_floor_no(3);
      Vehicle v = new Vehicle("bike");
      v.set_vehicle_fuel("NV");
      v.set_vehicle_no("5456");

      Person prathik = new Person("prathik",v,false);
      /* For floor 1*/
      Compact_Spot f1c1 = new Compact_Spot();
      Large_Spot f1c2 = new Large_Spot();
      Handicapped_Spot f1c3 = new Handicapped_Spot();
      Bike_Spot f1c4 = new Bike_Spot();
      /* For floor 2 */
      Compact_Spot f2c1 = new Compact_Spot();
      Large_Spot f2c2 = new Large_Spot();
      Handicapped_Spot fc3 = new Handicapped_Spot();
      Bike_Spot f2c4 = new Bike_Spot();
      /* For floor 3 */
      Compact_Spot f3c1 = new Compact_Spot();
      Large_Spot f3c2 = new Large_Spot();
      Handicapped_Spot f3c3 = new Handicapped_Spot();
      Bike_Spot f3c4 = new Bike_Spot();
      
      Parking_Attendant xyz = new Parking_Attendant("Roshan");
      xyz.Welcome();
      if(f1c4.Is_spot_free){
          f1c4.assign_spot_to_vehicle(v,prathik);
      }
      else{
          System.out.println("you cant park");
      }
      Ticket t1 = new Ticket(prathik,v,2,30);
      f1c4.remove_vehicle_from_spot();
      int money = t1.money_to_be_paid(4, 50);
      Money m = new Money(money,"UPI");
      t1.Transcation(money);
      m.pay_money(money);
      xyz.dept_msg();

    }
}
    
