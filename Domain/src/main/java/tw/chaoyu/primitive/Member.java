package tw.chaoyu.primitive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static tw.chaoyu.utils.ValidationUtils.validate;


/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Member {
    private Integer id;
    @NotNull
    private Name name;
    @NotNull
    private Gender gender;
    @NotNull
    private Birthday birthday;
    @NotNull
    private Mail mail;

    public Member(Name name, Gender gender, Birthday birthday, Mail mail) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.mail = mail;
        validate(this);
    }

    public enum Gender {
        Male, Female
    }
}
