package com.chessboard.editor.gameworld;

import com.chessboard.editor.gameworld.entity.characters.ClancyComponent;
import com.chessboard.editor.gameworld.entity.Launcher;
import com.chessboard.editor.gameworld.entity.ammo.Bullet;
import com.chessboard.editor.gameworld.entity.ammo.LauncherMissile;
import com.whitewoodcity.fxgl.app.ImageData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public interface ParallelCacheService {
  default Set<ImageData> cacheSet(Type... types) {
    var set = new HashSet<ImageData>();
    for (var type : types) {
      set.addAll(switch (type) {
        case GROUND -> List.of(new ImageData("backgrounds/back0.png", 1500, 713 * .625));
        case GROUND_FONT -> List.of(new ImageData("backgrounds/front0.png",2400*.625, 441*.625));
        case CLANCY -> ClancyComponent.getImageData();
        case BULLET -> Bullet.getImageData();
        case LAUNCHER_MISSILE -> LauncherMissile.getImageData();
        case LAUNCHER -> Launcher.getImageData();
        default -> Set.of();
      });
    }

    return set;
  }
}
