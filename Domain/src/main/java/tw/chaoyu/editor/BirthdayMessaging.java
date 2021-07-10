package tw.chaoyu.editor;

import tw.chaoyu.message.Message;
import tw.chaoyu.primitive.Member;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class BirthdayMessaging extends Messaging {
    private BirthdayMessaging(Messaging nextMessaging) {
        super(nextMessaging);
    }

    public static BirthdayMessaging greetWithBirthdayMessage(Messaging nextMessaging) {
        return new BirthdayMessaging(nextMessaging);
    }

    @Override
    public void write(Message.MessageBuilder builder, Member member) {
        builder.editSubject("Happy birthday!")
                .editTopContent("Happy birthday, dear " + member.getName().getFirstName() + "!");
        next(builder, member);
    }
}
