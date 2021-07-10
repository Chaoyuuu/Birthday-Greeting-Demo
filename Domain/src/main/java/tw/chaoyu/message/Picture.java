package tw.chaoyu.message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static java.util.Objects.requireNonNullElse;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private String image;

    public static Picture dummy() {
        return new Picture();
    }

    public String getImage() {
        return requireNonNullElse(image, "");
    }
}
