import com.alipay.objquery.query.Group;
import com.alipay.objquery.query.Order;
import com.alipay.objquery.query.Query;
import com.alipay.objquery.service.impl.ObjectQueryServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ²âÊÔgroupÌõ¼þ
 */
public class TestGroup {

    @Test
    public void test(){
        List<TestData> data = new ArrayList<>();
        data.add(new TestData(1, "bbbb"));
        data.add(new TestData(2, "bbbb"));
        data.add(new TestData(3, "aaaa"));
        data.add(new TestData(4, "aaaa"));
        data.add(new TestData(5, "cccc"));
        data.add(new TestData(6, "cccc"));

        long start = System.currentTimeMillis();

        Group<TestData> group = new Group<>(TestData::getName);

        Query<TestData> query = new Query();
        query.setGroup(group);
        List<TestData> result = new ObjectQueryServiceImpl().query(data, query);

        result.forEach(e -> System.out.println(String.format("id: %s \t name: %s", e.getId(), e.getName())));
        assert result.size() == 3;
        System.out.println("cost time: " + (System.currentTimeMillis() - start));
    }
}
