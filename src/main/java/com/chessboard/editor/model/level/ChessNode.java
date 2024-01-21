package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 棋子
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChessNode {

    @JsonProperty("x")
    public int x;

    @JsonProperty("y")
    public int y;

    /**
     * 掉落模式
     */
    @JsonProperty("patternOfDrop")
    public int patternOfDrop;
}
