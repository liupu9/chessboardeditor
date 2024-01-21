package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关卡需要达成的过关目标
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goal {

    @JsonProperty("Id")
    public int id;

    @JsonProperty("ColorId")
    public int colorId;

    @JsonProperty("MaxCount")
    public int maxCount;
}
