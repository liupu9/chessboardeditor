package com.chessboard.editor.constants;

import java.util.List;

/**
 * 常量定义
 *
 * @author liupu
 */
public interface GameConst {

    String APP_NAME = "*棋盘玩法编辑器";

    String APP_VERSION = "0.1.0-Alpha";

    int APP_HEIGHT = 800;

    String FONT_UI = "BlackOpsOne-Regular.ttf";

    /**
     * 感谢开源库作者名单列表
     */
    List<String> thanksList = List.of(
            "Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)",
            "赵老板 (fxcity库作者)",
            "风云0312"
    );
}
