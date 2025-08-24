package myFirstProject.raman.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class Addition {

    public int add(int a, int b){
        int sum = a + b;
        return sum;
    }
}
