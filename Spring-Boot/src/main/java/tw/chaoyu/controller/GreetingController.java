package tw.chaoyu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.chaoyu.presenter.GreetBirthdayMembersPresenter;
import tw.chaoyu.useCase.GreetBirthdayMembersUseCase;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@RestController
@AllArgsConstructor
public class GreetingController {
    private final GreetBirthdayMembersPresenter greetBirthdayMembersPresenter;
    private final GreetBirthdayMembersUseCase greetBirthdayMembersUseCase;

    @GetMapping("/api/greeting/birthday")
    public String getBirthdayGreetingMessage() {
        greetBirthdayMembersUseCase.execute(greetBirthdayMembersPresenter);
        return greetBirthdayMembersPresenter.present();
    }
}

