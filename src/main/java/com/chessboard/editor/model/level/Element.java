package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础元素
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Element {

    @JsonProperty("id")
    public int id;

    @JsonProperty("color")
    public int color;
}
