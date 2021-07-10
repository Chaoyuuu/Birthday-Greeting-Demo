package tw.chaoyu.presenter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import tw.chaoyu.message.Message;
import tw.chaoyu.message.Picture;
import tw.chaoyu.useCase.GreetBirthdayMembersUseCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@RequestScope
@Component
public class GreetBirthdayMembersPresenter implements GreetBirthdayMembersUseCase.Presenter {
    private List<Message> messages;

    @Override
    public void showMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String present() {
        return messages.stream().map(this::typeSet).collect(Collectors.joining("\n"));
    }

    private String typeSet(Message message) {
        return message.getSubject() + message.getTopContent() +
                message.getPicture().orElseGet(Picture::dummy).getImage() +
                message.getBottomContent();
    }
}

