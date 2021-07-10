package tw.chaoyu.useCase;


import lombok.AllArgsConstructor;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.repository.MemberRepository;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

import static tw.chaoyu.date.DateProvider.now;
import static tw.chaoyu.primitive.Member.Gender.Male;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Named
@AllArgsConstructor
public class GreetBirthdayMembersUseCase {
    private final MemberRepository memberRepository;

    public void execute(Presenter presenter) {
        List<Member> members = memberRepository.getBirthdayMembers(now());
        presenter.showMessages(greet(members));
    }

    private List<String> greet(List<Member> members) {
        return members.stream()
                .map(this::getGreetingMessage)
                .collect(Collectors.toList());
    }

    private String getGreetingMessage(Member member) {
        String subject = "Subject: Happy birthday!\n";
        if (Male == member.getGender()) {
            return subject + "Happy birthday, dear " + member.getName().getFirstName() + "!\n" +
                    "We offer special discount 20% off for the following items:\nWhite Wine, iPhone X";
        } else {
            return subject + "Happy birthday, dear " + member.getName().getFirstName() + "!\n" +
                    "We offer special discount 50% off for the following items:\nCosmetic, LV Handbags";
        }
    }

    public interface Presenter {
        void showMessages(List<String> messages);
    }
}
