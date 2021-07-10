package tw.chaoyu.editor;

import lombok.AllArgsConstructor;
import tw.chaoyu.message.Message.MessageBuilder;
import tw.chaoyu.primitive.Member;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */

@AllArgsConstructor
public abstract class Messaging {
    protected final Messaging nextMessaging;

    public void edit(MessageBuilder builder, Member member) {
        write(builder, member);
        next(builder, member);
    }

    public abstract void write(MessageBuilder builder, Member member);

    protected void next(MessageBuilder builder, Member member) {
        if (nextMessaging != null) {
            nextMessaging.edit(builder, member);
        }
    }

    public static Messaging dummy() {
        return new Messaging(null) {
            @Override
            public void write(MessageBuilder builder, Member member) {

            }
        };
    }
}
