package perscholas.service;

import org.springframework.stereotype.Component;

@Component
public class ExtraService {

    interface Addable {
        int add(int a, int b);
    }
    public String doMath(String answer) {
        Addable ad1 = (a, b) -> (a + b);
        answer = String.valueOf(ad1.add(10,20));

        return "The answer is "+answer;
    }
}
