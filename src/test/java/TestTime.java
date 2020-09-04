import com.alipay.objquery.query.Query;
import com.alipay.objquery.query.Where;
import com.alipay.objquery.service.impl.ObjectQueryServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 性能测试条件
 */
public class TestTime {

    @Test
    public void test() {

        List<TestData> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(new TestData(1, UUID.randomUUID().toString()));
        }

        long start = System.currentTimeMillis();

        // name.contains("c") = true and ( name.contains("a") = true or name.contains("e") = true )
        Where<TestData> subWhere = new Where<>();
        subWhere.orEquals(e -> e.getName().contains("a"), true).orEquals(e -> e.getName().contains("e"), true);
        Where<TestData> where = new Where<>();
        where.andEquals(e -> e.getName().contains("c"), true);
        where.and(subWhere);

        Query<TestData> query = new Query();
        query.setWhere(where);
        List<TestData> query1 = new ObjectQueryServiceImpl().query(data, query);
        System.out.println(query1.size());
        System.out.println("cost time: " + (System.currentTimeMillis() - start));
    }
}
