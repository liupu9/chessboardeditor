package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关卡掉落障碍数据
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LevelDropObstacleData {

    @JsonProperty("MaxNum")
    public int maxNum;

    @JsonProperty("MinNum")
    public int minNum;

    @JsonProperty("IntervalNum")
    public int intervalNum;
}
