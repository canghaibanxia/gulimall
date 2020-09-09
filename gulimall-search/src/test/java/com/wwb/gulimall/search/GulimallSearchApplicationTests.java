package com.wwb.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.wwb.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class GulimallSearchApplicationTests {

    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Test
    public void contextLoads() {
        System.out.println("==================================================================");
        System.out.println(restHighLevelClient);
    }

    @Data
    class User{
        private String userName;
        private String gender;
        private Integer age;
    }

    @Test
    public void indexDate() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        //indexRequest.source("userName","zhangsan","age",20);

        User user = new User();
        user.setAge(20);
        user.setGender("男");
        user.setUserName("李小白");
        String jsonSting = JSON.toJSONString(user);
        //indexRequest.source(jsonSting);
        indexRequest.source(jsonSting, XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Test
    public void searchIndex() throws IOException {
        SearchRequest searchRequest = new SearchRequest("newbank");

        SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.searchSource();
        MatchAllQueryBuilder matchQueryBuilder = QueryBuilders.matchAllQuery();
        //MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("address", "mill");
        searchSourceBuilder.query(matchQueryBuilder);

        TermsAggregationBuilder ageaggs = AggregationBuilders.terms("ageaggs").field("age").size(100);
        TermsAggregationBuilder genderaggs = AggregationBuilders.terms("genderaggs").field("gender.keyword").size(10);
        AvgAggregationBuilder field = AggregationBuilders.avg("avgbalance").field("balance");
        genderaggs.subAggregation(field);
        ageaggs.subAggregation(genderaggs);

        TermsAggregationBuilder agebalance = AggregationBuilders.terms("agebalance").field("balance").size(10);
        ageaggs.subAggregation(agebalance);

        SearchSourceBuilder aggregation = searchSourceBuilder.aggregation(ageaggs);
        searchRequest.source(searchSourceBuilder);

        System.out.println(searchRequest);
        SearchResponse response = restHighLevelClient.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);;
        System.out.println(response);
        Aggregations aggregations = response.getAggregations();
        Terms ageaggs1 = aggregations.get("ageaggs");
        for (Terms.Bucket bucket : ageaggs1.getBuckets()) {
            System.out.println(bucket.getKeyAsString());
        }

    }
}

