package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 关卡棋盘数据
 *
 * @author liupu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LevelBoardData {

    @JsonProperty("Goals")
    public List<Goal> goals;

    @JsonProperty("LevelMap")
    public List<ChessNode> levelMap;

    @JsonProperty("MidElements")
    public List<MidElement> midElements;

    @JsonProperty("TopElements")
    public List<TopElement> topElements;

    @JsonProperty("BottomElements")
    public List<BottomElement> bottomElements;

    @JsonProperty("GlobalColorWeight")
    public List<ColorWeight> globalColorWeight;

    @JsonProperty("SpecialDropDatas")
    public List<SpecialDropData> specialDropDatas;

    @JsonProperty("PortalDatas")
    public List<PortalData> portalDatas;

    @JsonProperty("GenCellDatas")
    public List<CellData> genCellDatas;

    @JsonProperty("CurtainDatas")
    public List<CurtainData> curtainDatas;

    @JsonProperty("LevelDropObstacleData")
    public LevelDropObstacleData levelDropObstacleData;

    @JsonProperty("Moves")
    public int moves;

    @JsonProperty("DropContinue")
    public double dropContinue;

    @JsonProperty("Times")
    public int times;
}
