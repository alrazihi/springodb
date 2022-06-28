package com.alrazihi.arangodb;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = { "com.alrazihi.arangodb" })
public class ArangoDBConfiguration extends AbstractArangoConfiguration {

    /**
     * Database url (server + port) & credentials configs
     * @return
     */
    @Override
    public ArangoDB.Builder arango() {
        ArangoDB.Builder arango = new ArangoDB.Builder()
                .host("127.0.0.1", 8529)
                .useProtocol(Protocol.HTTP_JSON)
                .user("root")
                .password("Alrazihi.18");
        return arango;
    }
//    @Override
//    public ArangoDB.Builder arango() {
//        InputStream in = ArangoDBConfiguration.class.getResourceAsStream("arangodb.properties");
//        ArangoDB.Builder arango = new ArangoDB.Builder()
//                .loadProperties(in);
//        return arango;
//    }
    /**
     * Database name
     * @return
     */
    @Override
    public String database() {
        return "alibabacloudblog";
    }

}