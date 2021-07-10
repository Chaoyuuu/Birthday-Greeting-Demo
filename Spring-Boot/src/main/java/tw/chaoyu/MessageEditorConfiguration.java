package tw.chaoyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.chaoyu.discount.DiscountPolicy;
import tw.chaoyu.editor.Messaging;

import static tw.chaoyu.editor.DiscountOfferMessaging.offerDiscount;
import static tw.chaoyu.editor.ElderPictureMessaging.greetElderWithPicture;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Configuration
public class MessageEditorConfiguration {
    @Bean
    public Messaging defaultMessaging(DiscountPolicy discountPolicy) {
        return greetElderWithPicture(offerDiscount(discountPolicy));
    }
}
