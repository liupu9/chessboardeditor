package com.chessboard.editor.model.level;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CellData {

    @JsonProperty("id")
    public int id;

    @JsonProperty("isContinue")
    public boolean isContinue;

    @JsonProperty("colorWeights")
    public List<ColorWeight> colorWeights;
}
