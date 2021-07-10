package tw.chaoyu.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Getter
@AllArgsConstructor
public class Message {
    private final String subject;
    private final String topContent;
    private final String bottomContent;

    public static class MessageBuilder {
        private String subject;
        private String topContent;
        private String bottomContent;

        public MessageBuilder editSubject(String editedSubject) {
            subject = "Subject: " + editedSubject + "\n";
            return this;
        }

        public MessageBuilder editTopContent(String editedTopContent) {
            topContent = editedTopContent + "\n";
            return this;
        }

        public MessageBuilder editBottomContent(String editedBottomContent) {
            bottomContent = editedBottomContent;
            return this;
        }

        public Message build() {
            return new Message(subject, topContent, bottomContent);
        }

    }
}
