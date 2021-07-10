package tw.chaoyu.primitive;

import lombok.Getter;

import javax.validation.constraints.Past;
import java.time.LocalDate;

import static tw.chaoyu.date.DateProvider.now;
import static tw.chaoyu.utils.ValidationUtils.validate;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
public class Birthday {
    @Past
    private final LocalDate date;

    public Birthday(int year, int month, int date) {
        this.date = LocalDate.of(year, month, date);
        validate(this);
    }

    public int getYear() {
        return date.getYear();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public int getAge() {
        var today = now();
        return today.getYear() - date.getYear();
    }
}
