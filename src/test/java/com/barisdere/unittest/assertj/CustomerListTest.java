package com.barisdere.unittest.assertj;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by baris on 15/03/15.
 */
public class CustomerListTest {

    @Test
    public void testListeler() throws Exception {

        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "john"));
        items.add(new Item(2, "jennifer"));
        items.add(new Item(3, "jennifer"));
        items.add(new Item(4, "marc"));
        items.add(new Item(5, "marc"));

        //
        assertThat(items)
                .extracting("name")
                .contains("john", "marc");

        assertThat(items)
                .extracting("name", "id")
                .contains(
                    tuple("john", 1),
                    tuple("marc", 5)
                );

        assertThat(
                    extractProperty("id", Integer.class).from(items)
                )
                .containsExactly(1,2,3,4,5);

    }

    @Data
    @AllArgsConstructor
    static class Item {

        private Integer id;

        private String name;
    }

}
