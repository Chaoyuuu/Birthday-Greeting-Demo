package tw.chaoyu;

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
import static tw.chaoyu.primitive.Member.Gender.Male;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void GivenTodayIs0808RobertWhoseBirthdayIs19750808_WhenGreetBirthdayMembers_ShouldGreetRobert() throws Exception {
        today(2021, 8, 8);
        Birthday birthday = new Birthday(1975, 8, 8);
        Member member = new Member(new Name("Robert", "Yen"), Male, birthday, new Mail("robert.yen@linecorp.com"));
        memberRepository.save(member);

        mockMvc.perform(get("/api/greeting/birthday"))
                .andExpect(status().isOk())
                .andExpect(content().string("Subject: Happy birthday!\n" + "Happy birthday, dear Robert!"));
    }

    private void today(int year, int month, int day) {
        DateProvider.setNow(year, month, day);
    }
}