package com.audiologist.crm;

import com.mongodb.Mongo;
import com.github.fakemongo.Fongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class FongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "crm-test-db";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(getDatabaseName()).getMongo();
    }
}