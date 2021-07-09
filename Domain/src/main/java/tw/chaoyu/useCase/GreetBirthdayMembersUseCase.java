package tw.chaoyu.useCase;


import lombok.AllArgsConstructor;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.repository.MemberRepository;

import javax.inject.Named;
import java.util.List;

import static tw.chaoyu.date.DateProvider.now;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Named
@AllArgsConstructor
public class GreetBirthdayMembersUseCase {
    private final MemberRepository memberRepository;

    public void execute(Presenter presenter) {
        List<Member> members = memberRepository.getBirthdayMembers(now());
        presenter.showMembers(members);
    }

    public interface Presenter {
        void showMembers(List<Member> members);
    }
}
