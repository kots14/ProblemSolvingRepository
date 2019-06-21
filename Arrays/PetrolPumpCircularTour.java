import java.io.*;
import java.util.*;
public class PetrolPumpCircularTour {
    static class PetrolPump {
        int petrol = Integer.MIN_VALUE;
        int distance = Integer.MIN_VALUE;
        public PetrolPump(){
            petrol = distance = 1;
        }
        public PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    public static int petrolPumpCircularTour(PetrolPump[] a) {
        int start = 0; 
        int end =  1; 
        int N = a.length;
        int petrol = a[start].petrol - a[start].distance; 
    
        while (end != start || petrol < 0) { 
            while (petrol < 0 && start != end) { 
                // Remove starting petrol pump. Change start 
                petrol -= a[start].petrol - a[start].distance; 
                start = (start + 1) % N; 
    
                if (start == 0) 
                    return -1; 
            } 
    
            //refuelling
            petrol += a[end].petrol - a[end].distance; 
    
            end = (end + 1) % N; 
        } 
    
        // Return starting point 
        return start; 
    }
    public static void main(String[] args) {
        PetrolPump[] a = new PetrolPump[3];
        a[0] = new PetrolPump(6, 4);
        a[1] = new PetrolPump(3, 6);
        a[2] = new PetrolPump(7, 3);

        int output = petrolPumpCircularTour(a);
        System.out.println("Output : " + output);
    }
}