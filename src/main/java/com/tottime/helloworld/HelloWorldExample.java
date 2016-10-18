package com.tottime.helloworld;

import java.util.Map;

import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

/**
 * @author zengcheng
 * @version $Id: HelloWorldExample.java, v 0.1 2016年10月18日 zengcheng Exp $
 */
public class HelloWorldExample {

    public static void main(String[] args) {
        GraphQLFieldDefinition fieldDefinition = GraphQLFieldDefinition.newFieldDefinition()
            .type(Scalars.GraphQLString).name("hello").staticValue("world").build();

        GraphQLObjectType queryType = GraphQLObjectType.newObject().name("helloworldquery")
            .field(fieldDefinition).build();

        GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();
        Map<String, Object> map = (Map) new GraphQL(schema).execute("{hello}").getData();
        System.out.println(map);
    }
}
