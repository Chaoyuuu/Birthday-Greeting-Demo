package tw.chaoyu.primitive;

import lombok.Getter;

import javax.validation.constraints.Email;

import static tw.chaoyu.utils.ValidationUtils.validate;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
public class Mail {
    @Email
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
        validate(this);
    }

}
