import com.mongodb.client.model.Indexes;
import core.framework.mongo.MongoMigration;
import core.framework.util.Lists;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author Else
 */
public class Main {
    public static void main(String[] args) {
        var migration = new MongoMigration("sys.properties", "sys.mongo.adminURI");
        //禁止表扫描
        migration.migrate(mongo -> {
            mongo.runCommand(new Document().append("setParameter", 1).append("notablescan", 1));
        });

        migration = new MongoMigration("sys.properties");
        //创建索引
        migration.migrate(mongo -> {
            mongo.createIndex("products", Indexes.ascending("created_time"));
        });

        //创建索引
        migration.migrate(mongo -> {
            mongo.createIndex("products", Indexes.compoundIndex(new BsonDocument("name",new BsonInt32(1)),
                new BsonDocument( "desc",new BsonInt32(1))));
        });
    }
}
