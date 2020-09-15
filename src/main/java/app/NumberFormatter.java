package app;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component
public class NumberFormatter {
    public String numberFormat(Long number){
        return NumberFormat.getInstance().format(number);
    }
}
