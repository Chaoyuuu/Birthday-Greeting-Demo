package tw.chaoyu.primitive;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
@AllArgsConstructor
public class Member {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Birthday birthday;
    private String mail;

    public enum Gender {
        Male, Female
    }
}
