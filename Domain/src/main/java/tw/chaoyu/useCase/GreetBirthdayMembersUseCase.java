package tw.chaoyu.useCase;

import tw.chaoyu.editor.Messaging;
import tw.chaoyu.message.Message;
import tw.chaoyu.message.Message.MessageBuilder;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.repository.MemberRepository;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static tw.chaoyu.date.DateProvider.now;
import static tw.chaoyu.editor.BirthdayMessaging.greetWithBirthdayMessage;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Named
public class GreetBirthdayMembersUseCase {
    private final MemberRepository memberRepository;
    private final Messaging messaging;

    public GreetBirthdayMembersUseCase(MemberRepository memberRepository, Messaging messaging) {
        this.memberRepository = memberRepository;
        this.messaging = greetWithBirthdayMessage(messaging);
    }

    public void execute(Presenter presenter) {
        List<Member> members = memberRepository.getBirthdayMembers(now());
        presenter.showMessages(greet(members));
    }

    private List<Message> greet(List<Member> members) {
        return members.stream()
                .map(this::greet)
                .collect(toList());
    }

    private Message greet(Member member) {
        var messageBuilder = new MessageBuilder();
        messaging.edit(messageBuilder, member);
        return messageBuilder.build();
    }

    public interface Presenter {
        void showMessages(List<Message> messages);
    }
}
