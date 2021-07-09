package tw.chaoyu.presenter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.useCase.GreetBirthdayMembersUseCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@RequestScope
@Component
public class GreetBirthdayMembersPresenter implements GreetBirthdayMembersUseCase.Presenter {
    private List<Member> members;

    @Override
    public void showMembers(List<Member> members) {
        this.members = members;
    }

    public String present() {
        return members.stream()
                .map(m -> getGreetingMsg(m.getName().getFirstName()))
                .collect(Collectors.joining("\n"));
    }

    private String getGreetingMsg(String name) {
        return "Subject: Happy birthday!\nHappy birthday, dear " + name + "!";
    }

}

