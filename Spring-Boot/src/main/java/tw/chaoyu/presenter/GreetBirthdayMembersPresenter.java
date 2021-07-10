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
    private List<String> products;

    @Override
    public void showMessages(List<String> messages) {
        this.products = messages;
    }

    public String present() {
        return String.join("\n", products);
    }
}

