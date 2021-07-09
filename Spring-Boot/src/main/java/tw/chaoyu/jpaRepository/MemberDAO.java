package tw.chaoyu.jpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Repository
public interface MemberDAO extends CrudRepository<MemberData, Integer> {
    MemberData save(MemberData member);

    List<MemberData> findByBirthMonthAndBirthDate(int month, int date);
}
