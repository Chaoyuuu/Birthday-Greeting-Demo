package tw.chaoyu.repository;

import tw.chaoyu.primitive.Member;

import java.time.LocalDate;
import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public interface MemberRepository {
    Member save(Member member);

    default List<Member> getBirthdayMembers(LocalDate today) {
        return getBirthdayMembers(today.getMonthValue(), today.getDayOfMonth());
    }

    List<Member> getBirthdayMembers(int month, int date);
}
