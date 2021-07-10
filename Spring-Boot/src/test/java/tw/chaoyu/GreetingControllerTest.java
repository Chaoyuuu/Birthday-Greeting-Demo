package tw.chaoyu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tw.chaoyu.date.DateProvider;
import tw.chaoyu.primitive.Birthday;
import tw.chaoyu.primitive.Mail;
import tw.chaoyu.primitive.Member;
import tw.chaoyu.primitive.Name;
import tw.chaoyu.repository.MemberRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tw.chaoyu.primitive.Member.Gender.Female;
import static tw.chaoyu.primitive.Member.Gender.Male;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("Given today is 8/8 and five members: two of them (Robert and Sherry) born on 8/8, " +
            "When greet the birthday members, Should greet Robert and Sherry with different messages.")
    @Test
    void GivenTodayIs0808AndFiveMembers_WhenGreetBirthdayMembers_ShouldGreetRobertAndSherryWithDifferentMessages() throws Exception {
        today(2021, 8, 8);

        saveMember("Robert", "Yen", Male, 1975, 8, 8, "robert.yen@linecorp.com");
        saveMember("Cid", "Change", Male, 1990, 10, 10, "cid.change@linecorp.com");
        saveMember("Miki", "Lai", Female, 1993, 4, 5, "miki.lai@linecorp.com");
        saveMember("Sherry", "Chen", Female, 1993, 8, 8, "sherry.lai@linecorp.com");
        saveMember("Peter", "Wang", Male, 1950, 12, 22, "peter.wang@linecorp.com");

        mockMvc.perform(get("/api/greeting/birthday"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("Subject: Happy birthday!\nHappy birthday, dear Robert!\n" +
                                "We offer special discount 20% off for the following items:\nWhite Wine, iPhone X\n" +
                                "Subject: Happy birthday!\nHappy birthday, dear Sherry!\n" +
                                "We offer special discount 50% off for the following items:\nCosmetic, LV Handbags"));
    }

    @DisplayName("Given today is 12/22 and five members: Peter born on 12/22, " +
            "When greet the birthday members, Should greet Peter with elder picture and messages.")
    @Test
    void GivenTodayIs1222AndFiveMembers_WhenGreetBirthdayMembers_ShouldGreetPeterWithElderPictureAndMessage() throws Exception {
        today(2021, 12, 22);

        saveMember("Robert", "Yen", Male, 1975, 8, 8, "robert.yen@linecorp.com");
        saveMember("Cid", "Change", Male, 1990, 10, 10, "cid.change@linecorp.com");
        saveMember("Miki", "Lai", Female, 1993, 4, 5, "miki.lai@linecorp.com");
        saveMember("Sherry", "Chen", Female, 1993, 8, 8, "sherry.lai@linecorp.com");
        saveMember("Peter", "Wang", Male, 1950, 12, 22, "peter.wang@linecorp.com");

        mockMvc.perform(get("/api/greeting/birthday"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("Subject: Happy birthday!\nHappy birthday, dear Peter!\n" +
                                "(A greeting picture here)\n" +
                                "We offer special discount 20% off for the following items:\nWhite Wine, iPhone X"));
    }

    private void today(int year, int month, int day) {
        DateProvider.setNow(year, month, day);
    }

    private void saveMember(String firstName, String lastName, Member.Gender gender, int birthYear, int birthMonth, int birthDate, String mail) {
        Birthday birthday = new Birthday(birthYear, birthMonth, birthDate);
        Member member = new Member(new Name(firstName, lastName), gender, birthday, new Mail(mail));
        memberRepository.save(member);
    }
}