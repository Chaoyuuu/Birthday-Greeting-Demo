package tw.chaoyu.editor;

import tw.chaoyu.discount.Discount;
import tw.chaoyu.discount.DiscountPolicy;
import tw.chaoyu.message.Message;
import tw.chaoyu.primitive.Member;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class DiscountOfferMessaging extends Messaging {
    private final DiscountPolicy discountPolicy;

    private DiscountOfferMessaging(DiscountPolicy discountPolicy, Messaging nextMessaging) {
        super(nextMessaging);
        this.discountPolicy = discountPolicy;
    }

    public static DiscountOfferMessaging offerDiscount(DiscountPolicy policy, Messaging nextMessaging) {
        return new DiscountOfferMessaging(policy, nextMessaging);
    }

    public static DiscountOfferMessaging offerDiscount(DiscountPolicy policy) {
        return new DiscountOfferMessaging(policy, dummy());
    }

    @Override
    public void write(Message.MessageBuilder builder, Member member) {
        Discount discount = discountPolicy.getDiscount(member);
        builder.editBottomContent("We offer special discount " + discount.getPercentageOff() + "% off for the following items:\n"
                        + String.join(", ", discount.getItems()));
    }
}
