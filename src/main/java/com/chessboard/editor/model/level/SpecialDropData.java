package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 特殊掉落数据
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialDropData {

    @JsonProperty("ID")
    public int id;

    @JsonProperty("ColorWeight")
    public List<ColorWeight> colorWeight;

    @JsonProperty("TypeWeight")
    public List<TypeWeight> typeWeight;

    @JsonProperty("FixedGroupItems")
    public List<Element> fixedGroupItems;
}
