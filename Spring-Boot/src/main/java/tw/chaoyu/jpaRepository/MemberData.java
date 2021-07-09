package tw.chaoyu.jpaRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import tw.chaoyu.primitive.Birthday;
import tw.chaoyu.primitive.Mail;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.primitive.Member.Gender;
import tw.chaoyu.primitive.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int birthYear;
    private int birthMonth;
    private int birthDate;
    private String email;

    public static MemberData toData(Member member) {
        return MemberData.builder()
                .firstName(member.getName().getFirstName())
                .lastName(member.getName().getLastName())
                .gender(member.getGender())
                .birthYear(member.getBirthday().getYear())
                .birthMonth(member.getBirthday().getMonth())
                .birthDate(member.getBirthday().getDay())
                .email(member.getMail().getMail())
                .build();
    }

    public Member toEntity() {
        return Member.builder()
                .id(this.id)
                .name(new Name(this.firstName, this.lastName))
                .gender(this.gender)
                .birthday(new Birthday(this.birthYear, this.birthMonth, this.birthDate))
                .mail(new Mail(this.email))
                .build();
    }
}
