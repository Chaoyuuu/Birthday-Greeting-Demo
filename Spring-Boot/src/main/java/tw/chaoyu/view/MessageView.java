package tw.chaoyu.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import tw.chaoyu.message.Message;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Builder
@AllArgsConstructor
public class MessageView {
    public final String title;
    public final String content;

    public static MessageView toViewModel(Message message) {
        return MessageView.builder()
                .title(message.getSubject())
                .content(message.getTopContent())
                .build();
    }
}
