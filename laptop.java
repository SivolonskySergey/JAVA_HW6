import java.util.ArrayList;

public class laptop {
    int id;
    String brand;
    String model;
    int ram;
    int hdd;
    String os;
    int price;

    public laptop(
            int id,
            String brand,
            String model,
            int ram,
            int hdd,
            String os,
            int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.price = price;
    }

    public String printLaptop() {
        return "id: " + id + ", brand: " + brand + ", model: " + model + ", ram: " + ram + ", hdd: " + hdd + ", os: "
                + os + ", price: " + price;
    }

    public ArrayList<laptop> findLaptopRam(ArrayList<laptop> lap_list, int u_criteria) {
        ArrayList<laptop> filtered_laptops = new ArrayList<>();
        for (laptop i : lap_list) {
            if (i.ram == u_criteria) {
                filtered_laptops.add(i);
            }
        }
        return filtered_laptops;
    }
}
