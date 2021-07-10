package tw.chaoyu.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
@AllArgsConstructor
public class Message {
    private final String subject;
    private final String topContent;
    private final String bottomContent;
    private final Optional<Picture> picture;

    public static class MessageBuilder {
        private String subject;
        private String topContent;
        private String bottomContent;
        private Picture picture;

        public MessageBuilder editSubject(String editedSubject) {
            subject = "Subject: " + editedSubject;
            return this;
        }

        public MessageBuilder editTopContent(String editedTopContent) {
            topContent = editedTopContent;
            return this;
        }

        public MessageBuilder editBottomContent(String editedBottomContent) {
            bottomContent = editedBottomContent;
            return this;
        }

        public MessageBuilder editPicture(Picture editPicture) {
            picture = editPicture;
            return this;
        }

        public Message build() {
            return new Message(subject, topContent, bottomContent, Optional.ofNullable(picture));
        }

    }
}
