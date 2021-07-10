package tw.chaoyu.presenter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import tw.chaoyu.message.Message;
import tw.chaoyu.useCase.GreetBirthdayMembersUseCase;
import tw.chaoyu.view.MessageView;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<MessageView> present() {
        return messages.stream()
                .map(MessageView::toViewModel)
                .collect(toList());
    }
}

