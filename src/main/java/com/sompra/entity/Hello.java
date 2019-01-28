package com.sompra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by somprasong
 * Date: 2019-01-27
 * Time: 14:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hello {

    private String id;
    private String url;
    private String value;
    private String icon_url;
}
