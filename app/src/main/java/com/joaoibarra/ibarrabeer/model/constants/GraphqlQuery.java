package com.joaoibarra.ibarrabeer.model.constants;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class GraphqlQuery {
    public static String poc = "query pocSearchMethod($now: DateTime!, $algorithm: String!, $lat: String!, $long: String!) {\n" +
            "  pocSearch(now: $now, algorithm: $algorithm, lat: $lat, long: $long) {\n" +
            "    __typename\n" +
            "    id\n" +
            "    status\n" +
            "    tradingName\n" +
            "    officialName\n" +
            "    deliveryTypes {\n" +
            "      __typename\n" +
            "      pocDeliveryTypeId\n" +
            "      deliveryTypeId\n" +
            "      price\n" +
            "      title\n" +
            "      subtitle\n" +
            "      active\n" +
            "    }\n" +
            "    paymentMethods {\n" +
            "      __typename\n" +
            "      pocPaymentMethodId\n" +
            "      paymentMethodId\n" +
            "      active\n" +
            "      title\n" +
            "      subtitle\n" +
            "    }\n" +
            "    pocWorkDay {\n" +
            "      __typename\n" +
            "      weekDay\n" +
            "      active\n" +
            "      workingInterval {\n" +
            "        __typename\n" +
            "        openingTime\n" +
            "        closingTime\n" +
            "      }\n" +
            "    }\n" +
            "    address {\n" +
            "      __typename\n" +
            "      address1\n" +
            "      address2\n" +
            "      number\n" +
            "      city\n" +
            "      province\n" +
            "      zip\n" +
            "      coordinates\n" +
            "    }\n" +
            "    phone {\n" +
            "      __typename\n" +
            "      phoneNumber\n" +
            "    }\n" +
            "  }\n" +
            "}";
    public static String products = "query pocCategorySearch($id: ID!, $search: String!, $categoryId: Int!) {  poc(id: $id) {    products(categoryId: $categoryId, search: $search) {productVariants {        title \n description \n imageUrl \n price \n } \n    } \n  } \n}";
}
