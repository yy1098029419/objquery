import com.alipay.objquery.query.Query;
import com.alipay.objquery.query.Where;
import com.alipay.objquery.service.impl.ObjectQueryServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ²âÊÔwhereÌõ¼þ
 */
public class TestWhere {

    @Test
    public void test() {

        List<TestData> data = new ArrayList<>();
        data.add(new TestData(1, "wwww"));
        data.add(new TestData(2, "bbbb"));
        data.add(new TestData(3, "abcd"));
        data.add(new TestData(4, "ebac"));
        data.add(new TestData(5, "bdcq"));
        data.add(new TestData(6, "ccdd"));

        long start = System.currentTimeMillis();

        // name.contains("c") = true and ( name.contains("a") = true or name.contains("q") = true )
        Where<TestData> subWhere = new Where<>();
        subWhere.orEquals(e -> e.getName().contains("a"), true).orEquals(e -> e.getName().contains("q"), true);
        Where<TestData> where = new Where<>();
        where.andEquals(e -> e.getName().contains("c"), true);
        where.and(subWhere);

        Query<TestData> query = new Query();
        query.setWhere(where);
        List<TestData> query1 = new ObjectQueryServiceImpl().query(data, query);

        query1.forEach(e -> System.out.println(String.format("id: %s \t name: %s", e.getId(), e.getName())));
        assert query1.size() == 3;
        System.out.println("cost time: " + (System.currentTimeMillis() - start));
    }
}
