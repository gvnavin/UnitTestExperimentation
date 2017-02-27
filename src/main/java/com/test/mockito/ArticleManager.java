package com.test.mockito;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gnavin on 2/26/17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleManager {

    private User user;
    private ArticleDatabase database;

}
