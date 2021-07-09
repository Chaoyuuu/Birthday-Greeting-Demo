package tw.chaoyu.primitive;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

import static tw.chaoyu.utils.ValidationUtils.validate;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
public class Name {
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;

    public Name(@NotBlank String firstName, @NotBlank String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        validate(this);
    }
}
