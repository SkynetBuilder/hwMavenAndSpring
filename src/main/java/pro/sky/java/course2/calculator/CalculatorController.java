package pro.sky.java.course2.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {
    public final String noParamError = "Нужны 2 числа для обработки";
    public final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String showPlus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return noParamError;
        } else {
            return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
        }
    }

    @GetMapping("/minus")
    public String showMinus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return noParamError;
        } else {
            return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
        }
    }

    @GetMapping("/multiply")
    public String showMultiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return noParamError;
        } else {
            return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
        }
    }

    @GetMapping("/divide")
    public String showDivide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return noParamError;
        } else if (num2 == 0) {
            return "Нельзя делить на ноль!";
        } else {
            return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
        }
    }
}
