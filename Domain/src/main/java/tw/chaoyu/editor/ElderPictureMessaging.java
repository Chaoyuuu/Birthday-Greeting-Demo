package tw.chaoyu.editor;

import tw.chaoyu.message.Message;
import tw.chaoyu.message.Picture;
import tw.chaoyu.primitive.Member;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class ElderPictureMessaging extends Messaging {

    private ElderPictureMessaging(Messaging nextMessaging) {
        super(nextMessaging);
    }

    public static ElderPictureMessaging greetElderWithPicture(Messaging nextMessaging) {
        return new ElderPictureMessaging(nextMessaging);
    }

    @Override
    public void write(Message.MessageBuilder builder, Member member) {
        if (ageOver49(member)) {
            builder.editPicture(new Picture("(A greeting picture here)\n"));
        }
    }

    private boolean ageOver49(Member member) {
        return member.getBirthday().getAge() >= 49;
    }
}
