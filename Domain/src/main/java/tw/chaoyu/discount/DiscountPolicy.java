package tw.chaoyu.discount;

import tw.chaoyu.primitive.Member;

import javax.inject.Named;

import static tw.chaoyu.primitive.Member.Gender.Male;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Named
public class DiscountPolicy {
    public Discount getDiscount(Member member) {
        if (Male == member.getGender()) {
            return new Discount(20, "White Wine", "iPhone X");
        } else {
            return new Discount(50, "Cosmetic", "LV Handbags");
        }
    }
}