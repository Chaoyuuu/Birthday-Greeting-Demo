package tw.chaoyu.jpaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Component
@AllArgsConstructor
public class MemberJpaRepository implements MemberRepository {
    private final MemberDAO memberDAO;

    @Override
    public Member save(Member member) {
        return memberDAO.save(MemberData.toData(member)).toEntity();
    }

    @Override
    public List<Member> getBirthdayMembers(int month, int date) {
        return memberDAO.findByBirthMonthAndBirthDate(month, date).stream()
                .map(MemberData::toEntity)
                .collect(Collectors.toList());
    }
}
