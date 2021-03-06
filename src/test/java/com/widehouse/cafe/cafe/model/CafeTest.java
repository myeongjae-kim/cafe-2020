package com.widehouse.cafe.cafe.model;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class CafeTest {
    @Test
    void given_cafe_when_construct_then_valid() {
        // given
        var now = ZonedDateTime.now();
        var category = CategoryFixtures.life();
        // when
        var cafe = Cafe.builder()
                .name("name").nickname("nickname").description("desc").category(category).createdAt(now)
                .build();
        // then
        then(cafe).satisfies(c -> {
            then(c.getName()).isEqualTo("name");
            then(c.getNickname()).isEqualTo("nickname");
            then(c.getDescription()).isEqualTo("desc");
            then(c.getCategory()).isEqualTo(category);
            then(c.getCreatedAt()).isEqualTo(now);
        });
    }

    @Test
    void given_cafe_when_build_public_then_isPublic() {
        // when
        var cafe = Cafe.builder().visible(true).build();
        // then
        then(cafe.isPublic()).isTrue();
    }
}
