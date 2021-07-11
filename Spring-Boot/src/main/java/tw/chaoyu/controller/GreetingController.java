package tw.chaoyu.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.chaoyu.presenter.GreetBirthdayMembersPresenter;
import tw.chaoyu.useCase.GreetBirthdayMembersUseCase;
import tw.chaoyu.view.MessageView;

import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@RestController
@AllArgsConstructor
public class GreetingController {
    private final GreetBirthdayMembersPresenter greetBirthdayMembersPresenter;
    private final GreetBirthdayMembersUseCase greetBirthdayMembersUseCase;

    @GetMapping(value = "/api/greeting/birthday", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<MessageView> getBirthdayGreetingMessage() {
        greetBirthdayMembersUseCase.execute(greetBirthdayMembersPresenter);
        return greetBirthdayMembersPresenter.present();
    }
}

