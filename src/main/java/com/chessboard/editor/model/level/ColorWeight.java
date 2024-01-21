package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 颜色权重
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorWeight {

    @JsonProperty("colorId")
    public int colorId;

    @JsonProperty("weight")
    public int weight;
}
