package tw.chaoyu.primitive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void InvalidMail_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Mail("invalidMail.example.com"));
    }

    @Test
    void BirthdayInTheFuture_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Birthday(2200, 7, 7));
    }

    @Test
    void NameWithBlankFirstName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Name(" ", "lastName"));
    }

}