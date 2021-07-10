package tw.chaoyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.chaoyu.editor.Messaging;

import static tw.chaoyu.editor.Messaging.dummy;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Configuration
public class MessageEditorConfiguration {
    @Bean
    public Messaging defaultMessaging() {
        return dummy();
    }
}
